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

import br.com.zupacademy.henio.casadocodigo.dto.request.CategoriaRequest;
import br.com.zupacademy.henio.casadocodigo.modelo.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@PostMapping
	public ResponseEntity<String> criar(@RequestBody @Valid CategoriaRequest request) {
		
		Categoria categoria = new Categoria(request.getNome());
		manager.persist(categoria);

		return ResponseEntity.ok().body("Categoria " + request.getNome() + " cadastrada com sucesso.");
	}
}
