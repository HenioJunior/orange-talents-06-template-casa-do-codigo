package br.com.zupacademy.henio.casadocodigo.dto.request;

import br.com.zupacademy.henio.casadocodigo.exceptions.EntityNotFoundException;
import br.com.zupacademy.henio.casadocodigo.modelo.Cliente;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;
import br.com.zupacademy.henio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.henio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.henio.casadocodigo.validacao.DocumentType;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@DocumentType
public class ClienteRequest {

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
	private String estado;
	@NotNull
	private long idPais;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public ClienteRequest(String nome, String sobrenome, String documento, Integer tipoDocumento, String email,
						  String endereco, String complemento, String cidade, String estado, long idPais,
						  String telefone, String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.email = email;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.idPais = idPais;
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
		Optional<Estado> objEstado = estadoRepository.findByNome(this.estado);
		Estado estado = objEstado.orElseThrow(() -> new EntityNotFoundException("O estado não foi encontrado."));

		Optional<Pais> objPais = paisRepository.findById(this.idPais);
		Pais pais = objPais.orElseThrow(() -> new EntityNotFoundException("Id do pais não encontrado."));
		return new Cliente(nome, sobrenome, documento, tipoDocumento, email, endereco, complemento, cidade, estado, pais, telefone, cep);
	}
}
