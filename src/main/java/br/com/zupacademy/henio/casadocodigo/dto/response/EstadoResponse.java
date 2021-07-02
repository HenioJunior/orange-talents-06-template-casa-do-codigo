package br.com.zupacademy.henio.casadocodigo.dto.response;

import br.com.zupacademy.henio.casadocodigo.modelo.Estado;

public class EstadoResponse {

	private String nome;
	private Long id;
	
	public EstadoResponse(Estado estado) {
		this.nome = estado.getNome();
		this.id = estado.getId();
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}
}
