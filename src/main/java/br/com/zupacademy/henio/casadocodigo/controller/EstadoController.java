package br.com.zupacademy.henio.casadocodigo.controller;

import java.net.URI;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.henio.casadocodigo.dto.request.EstadoRequest;
import br.com.zupacademy.henio.casadocodigo.dto.response.EstadoResponse;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.repository.EstadoRepository;

@RequestMapping(value = "/estados")
@RestController
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	PaisRepository paisRepository;

	@Transactional
	@PostMapping
	public ResponseEntity<?> criar(@RequestBody @Valid EstadoRequest request) {

		Estado estado = request.toModel(paisRepository);
		estadoRepository.save(estado);

		return ResponseEntity.ok().body("O estado foi cadastrado");
	}	
}
