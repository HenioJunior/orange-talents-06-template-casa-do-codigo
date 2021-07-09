package br.com.zupacademy.henio.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String nome;
			
	public Categoria() {
	}
	
	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}
		
}
