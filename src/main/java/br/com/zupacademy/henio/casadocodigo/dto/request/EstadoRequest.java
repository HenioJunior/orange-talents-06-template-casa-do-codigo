package br.com.zupacademy.henio.casadocodigo.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;

public class EstadoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	@NotBlank
	private String pais;

	public EstadoRequest(@NotBlank String nome, String pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}
	
	public String getPais() {
		return pais;
	}

	public Estado toModel(PaisRepository paisRepository) {
		Pais pais = paisRepository.findByNome(this.pais);
		return new Estado(nome, pais);
	}
}


