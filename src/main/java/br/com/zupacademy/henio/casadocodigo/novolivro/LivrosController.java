package br.com.zupacademy.henio.casadocodigo.novolivro;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivrosController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid NovoLivroRequest request) {

		Livro livro = request.toModel(manager);
		manager.persist(livro);

		return livro.toString();
	}

	@GetMapping
	public List<LivrosResponse> exibirLista() {
	    List<Livro> list = manager.createQuery("SELECT a FROM Livro a", Livro.class).getResultList();
	    return list.stream().map(x -> new LivrosResponse(x)).collect(Collectors.toList());
	}
}
