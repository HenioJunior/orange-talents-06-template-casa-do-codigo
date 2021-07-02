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

import br.com.zupacademy.henio.casadocodigo.dto.request.ClienteRequest;
import br.com.zupacademy.henio.casadocodigo.dto.response.ClienteResponse;
import br.com.zupacademy.henio.casadocodigo.modelo.Cliente;
import br.com.zupacademy.henio.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.henio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
		
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
			
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteResponse> criar(@RequestBody @Valid ClienteRequest request, UriComponentsBuilder uriBuilder) {
		Cliente cliente = request.toModel(estadoRepository, paisRepository );
		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteResponse(cliente, cliente.getEstado(), cliente.getPais()) {
		});
	}
}
