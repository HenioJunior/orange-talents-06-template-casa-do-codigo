package br.com.zupacademy.henio.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String nome;
	
	@ManyToOne
	private Pais pais;

	public Estado() {
	}

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Estado(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
}
