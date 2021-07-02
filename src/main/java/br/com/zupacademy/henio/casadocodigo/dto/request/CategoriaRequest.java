package br.com.zupacademy.henio.casadocodigo.dto.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henio.casadocodigo.modelo.Categoria;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

public class CategoriaRequest {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public CategoriaRequest() {
	}

	public CategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
