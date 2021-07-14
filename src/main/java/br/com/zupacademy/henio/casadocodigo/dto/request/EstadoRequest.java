package br.com.zupacademy.henio.casadocodigo.dto.request;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.henio.casadocodigo.exceptions.EntityNotFoundException;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.henio.casadocodigo.validacao.ExistsId;

public class EstadoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@NotBlank
	private String nomeEstado;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private long paisId;

	public EstadoRequest(String nome, long paisId) {
		this.nomeEstado = nome;
		this.paisId = paisId;
	}
		
	public String getNomeEstado() {
		return nomeEstado;
	}

	public long getPaisId() {
		return paisId;
	}

	public Estado toModel(PaisRepository paisRepository) {
		Optional<Pais> obj = paisRepository.findById(this.paisId);
		Pais pais = obj.orElseThrow(() -> new EntityNotFoundException("Id do pais não encontrado."));
		return new Estado(nomeEstado, pais);
	}

	@Override
	public String toString() {
		return "Novo Estado [nomeEstado=" + nomeEstado + ", paisId=" + paisId + "]";
	}
	
}
