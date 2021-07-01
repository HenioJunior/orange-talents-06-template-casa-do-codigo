package br.com.zupacademy.henio.casadocodigo.detalhelivro;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henio.casadocodigo.novolivro.Livro;

@RestController
@RequestMapping(value = "/livros")
public class DetalheLivroController {
	
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
}
