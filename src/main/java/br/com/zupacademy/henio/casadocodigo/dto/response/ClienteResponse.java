package br.com.zupacademy.henio.casadocodigo.dto.response;

import br.com.zupacademy.henio.casadocodigo.modelo.Cliente;
import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import br.com.zupacademy.henio.casadocodigo.modelo.Pais;

public class ClienteResponse {
	private String nome;
	private String sobrenome;
	private String documento;
	private String email;
	private String endereco;
	private String complemento;
	private String cidade;
	private String pais;
	private String estado;
	private String telefone;
		
	public ClienteResponse() {
		
	}

	public ClienteResponse(Cliente cliente) {
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.email = cliente.getEmail();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.telefone = cliente.getTelefone();
	}
	
	public ClienteResponse(Cliente cliente, Estado estado, Pais pais){
        this(cliente);
        this.estado = estado.getNome();
        this.pais = pais.getNome();
    }

	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getDocumento() {
		return documento;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public String getPais() {
		return pais;
	}
	public String getEstado() {
		return estado;
	}
	public String getTelefone() {
		return telefone;
	}
}
