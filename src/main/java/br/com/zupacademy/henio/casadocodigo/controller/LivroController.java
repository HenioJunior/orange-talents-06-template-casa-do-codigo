package br.com.zupacademy.henio.casadocodigo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henio.casadocodigo.dto.request.LivroRequest;
import br.com.zupacademy.henio.casadocodigo.dto.response.DetalheLivroResponse;
import br.com.zupacademy.henio.casadocodigo.dto.response.ListarLivrosResponse;
import br.com.zupacademy.henio.casadocodigo.modelo.Livro;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalheLivroResponse> detalhar(@PathVariable("id") Long id) {
		
		Livro livroPesquisado = manager.find(Livro.class, id);
		if(livroPesquisado == null) {
			return ResponseEntity.notFound().build();
		}
		DetalheLivroResponse detalheLivroResponse = new DetalheLivroResponse(livroPesquisado);
		return ResponseEntity.ok(detalheLivroResponse);
	}
	
	@GetMapping
	public List<ListarLivrosResponse> exibirLista() {
	    List<Object[]> list = manager.createQuery("SELECT a.id, a.titulo FROM Livro a", Object[].class).getResultList();
	    return list.stream().map(listaDeLivros -> new ListarLivrosResponse(listaDeLivros)).collect(Collectors.toList());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> criar(@RequestBody @Valid LivroRequest request) {

		Livro livro = request.toModel(manager);
		manager.persist(livro);

		return ResponseEntity.ok().body(request.toString());
	}
}
