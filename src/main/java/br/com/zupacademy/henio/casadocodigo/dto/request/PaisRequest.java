package br.com.zupacademy.henio.casadocodigo.dto.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

public class PaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	@Deprecated
	public PaisRequest() {
	}

	public PaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
