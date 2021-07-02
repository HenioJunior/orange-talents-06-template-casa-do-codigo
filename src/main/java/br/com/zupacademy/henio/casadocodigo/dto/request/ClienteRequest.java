package br.com.zupacademy.henio.casadocodigo.dto.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.henio.casadocodigo.modelo.Cliente;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.henio.casadocodigo.validacao.DocumentType;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

@DocumentType
public class ClienteRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	private Integer tipoDocumento;
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
	private String pais;
	@NotBlank
	private String estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public ClienteRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			Integer tipoDocumento, @Email @NotBlank String email, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade, @NotBlank String pais, @NotBlank String estado,
			@NotBlank String telefone, @NotBlank String cep) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.email = email;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	
	public String getDocumento() {
		return documento;
	}

	public Cliente toModel(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		Estado estado = estadoRepository.findByNome(this.estado);
		Pais pais = paisRepository.findByNome(this.pais);
		return new Cliente(nome, sobrenome, documento, tipoDocumento, email, endereco, complemento, cidade, estado, pais, telefone, cep);
	}
}
