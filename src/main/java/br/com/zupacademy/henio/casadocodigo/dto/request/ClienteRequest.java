package br.com.zupacademy.henio.casadocodigo.dto.request;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.henio.casadocodigo.exceptions.EntityNotFoundException;
import br.com.zupacademy.henio.casadocodigo.modelo.Cliente;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.henio.casadocodigo.validacao.CPFOrCNPJ;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

public class ClienteRequest {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	@CPFOrCNPJ
	private String documento;
	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotNull
	private long idPais;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
		
	public ClienteRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@Email @NotBlank String email, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String estado, @NotNull long idPais, @NotBlank String telefone,
			@NotBlank String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.email = email;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.idPais = idPais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getDocumento() {
		return documento;
	}

	public Cliente toModel(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		Optional<Estado> objEstado = estadoRepository.findByNome(this.estado);
		Estado estado = objEstado.orElseThrow(() -> new EntityNotFoundException("O estado não foi encontrado."));

		Optional<Pais> objPais = paisRepository.findById(this.idPais);
		Pais pais = objPais.orElseThrow(() -> new EntityNotFoundException("Id do pais não encontrado."));
		return new Cliente(nome, sobrenome, documento, email, endereco, complemento, cidade, estado, pais, telefone, cep);
	}
}
