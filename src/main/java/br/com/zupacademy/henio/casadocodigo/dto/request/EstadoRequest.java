package br.com.zupacademy.henio.casadocodigo.dto.request;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;

public class EstadoRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	@NotNull
	private Long paisId;
	
	public EstadoRequest(String nome, long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}

	public long getPaisId() {
		return paisId;
	}

	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class,paisId);
		return new Estado(nome, pais);
	}
}


