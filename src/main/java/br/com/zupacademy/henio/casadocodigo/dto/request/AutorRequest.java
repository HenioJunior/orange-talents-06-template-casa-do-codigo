package br.com.zupacademy.henio.casadocodigo.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.henio.casadocodigo.modelo.Autor;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;


public class AutorRequest {
       
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;
	
    public AutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
    
    public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
    
    @Override
	public String toString() {
		return "Autor cadastrado: [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "] ";
	}
}
