package br.com.zupacademy.henio.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String nome;
		
	public Pais() {
	}

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
