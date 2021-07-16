package br.com.zupacademy.henio.casadocodigo.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.henio.casadocodigo.dto.request.EstadoRequest;
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
	public String criarEstado(@RequestBody @Valid EstadoRequest request) {
		boolean naoExisteEstado = verificaQueNaoExisteOEstadoNoPais(request);

		if (naoExisteEstado) {
			Estado estado = request.toModel(paisRepository);

			estadoRepository.save(estado);

			return request.toString();
		}
		return "O estado já existe para este país.";
	}

	private boolean verificaQueNaoExisteOEstadoNoPais(EstadoRequest request) {
		Optional<Estado> estado = estadoRepository.findByNomeAndPaisId(request.getNomeEstado(), request.getPaisId());
		if (estado.isPresent()) {
			return false;
		}
		return true;
	}
}
