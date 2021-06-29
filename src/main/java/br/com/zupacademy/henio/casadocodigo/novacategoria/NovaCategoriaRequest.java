package br.com.zupacademy.henio.casadocodigo.novacategoria;

import javax.validation.constraints.NotBlank;


public class NovaCategoriaRequest {

	@NotBlank
	private String nome;

	public NovaCategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
		
	public NovaCategoriaRequest() {
		super();
	}

	public String getNome() {
		return nome;
	}
	
}
