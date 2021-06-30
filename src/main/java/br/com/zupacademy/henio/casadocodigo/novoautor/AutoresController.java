package br.com.zupacademy.henio.casadocodigo.novoautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autores")
public class AutoresController {
	
	@PersistenceContext
	private EntityManager manager;
			
	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid NovoAutorRequest request) {

		Autor autor = request.toModel();
		manager.persist(autor);

		return autor.toString();
	}	
}
