package br.com.zupacademy.henio.casadocodigo.novacategoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
