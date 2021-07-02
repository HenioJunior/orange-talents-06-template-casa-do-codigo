package br.com.zupacademy.henio.casadocodigo.dto.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

public class PaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public PaisRequest() {
	}

	public PaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}
		
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "NovoPais [nome=" + nome + "]";
	}
}
