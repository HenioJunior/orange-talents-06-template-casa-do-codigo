package br.com.zupacademy.henio.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henio.casadocodigo.dto.request.EstadoRequest;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;

@RequestMapping(value = "/estados")
@RestController
public class EstadoController {
	
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@PostMapping
	public ResponseEntity<String> criar(@RequestBody @Valid EstadoRequest request) {
		
		Estado estado = request.toModel(manager);
		manager.persist(estado);
		
		return ResponseEntity.ok().body(request.toString());		
	}	

}
