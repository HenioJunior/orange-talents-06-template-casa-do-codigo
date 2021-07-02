package br.com.zupacademy.henio.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Table(name="estado", uniqueConstraints = {@UniqueConstraint(columnNames={"nome", "pais_id"})} )
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

	public Estado(String nome, @NotBlank Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
		
	public Estado(@NotBlank String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
}
