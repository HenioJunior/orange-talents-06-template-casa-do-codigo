package br.com.zupacademy.henio.casadocodigo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.henio.casadocodigo.dto.request.PaisRequest;
import br.com.zupacademy.henio.casadocodigo.dto.response.EstadoResponse;
import br.com.zupacademy.henio.casadocodigo.dto.response.PaisResponse;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Transactional
	@PostMapping
	public ResponseEntity<PaisResponse> criar(@RequestBody @Valid PaisRequest request, UriComponentsBuilder uriBuilder) {
		
		Pais pais = new Pais(request.getNome());
		paisRepository.save(pais);
		
		URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
		return ResponseEntity.created(uri).body(new PaisResponse(pais));
	}
	
	@GetMapping
	public ResponseEntity<List<PaisResponse>> listarTodos() {
		List<Pais> list = paisRepository.findAllByOrderByNome();
		List<PaisResponse> paisResponse = list.stream().map(x -> new PaisResponse(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(paisResponse);	
	}
	
	@GetMapping(value = "/{idPais}/estados")
	public ResponseEntity<List<EstadoResponse>> listarEstados(@PathVariable Long idPais) {
		List<Estado> list = estadoRepository.findByEstado(idPais);
		List<EstadoResponse> estadoResponse = list.stream().map(x -> new EstadoResponse(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(estadoResponse);	
	}
}
