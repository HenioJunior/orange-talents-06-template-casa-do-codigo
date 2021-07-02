package br.com.zupacademy.henio.casadocodigo.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.henio.casadocodigo.dto.request.AutorRequest;
import br.com.zupacademy.henio.casadocodigo.dto.response.AutorResponse;
import br.com.zupacademy.henio.casadocodigo.modelo.Autor;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
	
	@PersistenceContext
	private EntityManager manager;
			
	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> criar(@RequestBody @Valid AutorRequest request, UriComponentsBuilder uriBuilder) {

		Autor autor = request.toModel();
		manager.persist(autor);

		URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorResponse(autor));
	}	
}
