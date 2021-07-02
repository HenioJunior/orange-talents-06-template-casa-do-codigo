package br.com.zupacademy.henio.casadocodigo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String documento;
    private Integer tipoDocumento;
    @Column(unique = true)
    private String email;
    private String endereco;
    private String complemento;
    private String cidade;
    @ManyToOne
    private Estado estado;
    
    @ManyToOne
    private Pais pais;
    private String telefone;
    
    private String cep;
        
	public Cliente() {
	}

	public Cliente(String nome, String sobrenome, String documento, Integer tipoDocumento, String email,
			String endereco, String complemento, String cidade, Estado estado, Pais pais, String telefone, String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.email = email;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public long getId() {
		return id;
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

	public Integer getTipoDocumento() {
		return tipoDocumento;
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

	public Estado getEstado() {
		return estado;
	}

	public Pais getPais() {
		return pais;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
}
