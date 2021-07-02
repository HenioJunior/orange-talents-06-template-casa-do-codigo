package br.com.zupacademy.henio.casadocodigo.dto.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.validacao.ExistId;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

public class EstadoRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
    @ExistId(domainClass = Pais.class, fieldName = "id")
    private long idPais;
		

	public EstadoRequest(@NotBlank String nome, @NotNull long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}
		
	public String getNome() {
		return nome;
	}

	public long getIdPais() {
		return idPais;
	}

	public Estado toModel(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		return new Estado(this.nome, pais);
	}

	@Override
	public String toString() {
		return "Estado cadastrado: [nome=" + nome + ", idPais=" + idPais + "]";
	}
}
