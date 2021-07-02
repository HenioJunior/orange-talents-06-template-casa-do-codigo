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

import br.com.zupacademy.henio.casadocodigo.dto.request.PaisRequest;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@PostMapping
	public ResponseEntity<String> criar(@RequestBody @Valid PaisRequest request) {
		
		Pais pais = new Pais(request.getNome());
		manager.persist(pais);		
		
		return ResponseEntity.ok().body("O país " + request.getNome() + " foi cadastrado com sucesso.");		
	}	
}
