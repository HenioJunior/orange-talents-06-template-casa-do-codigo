package br.com.zupacademy.henio.casadocodigo.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;

@RequestMapping(value = "/estados")
@RestController
public class EstadoController {
		
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	PaisRepository paisRepository;
	
	@Transactional
	@PostMapping
	public ResponseEntity<EstadoResponse> criar(@RequestBody @Valid EstadoRequest request, UriComponentsBuilder uriBuilder) {
		
		Estado estado = request.toModel(paisRepository);
		estadoRepository.save(estado);
				
		URI uri = uriBuilder.path("/estados/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoResponse(estado));
	}	
}
