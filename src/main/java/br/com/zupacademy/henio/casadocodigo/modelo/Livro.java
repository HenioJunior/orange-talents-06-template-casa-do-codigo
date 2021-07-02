package br.com.zupacademy.henio.casadocodigo.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

	@Deprecated
	public Livro() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;
	private LocalDate dataDePublicacao;

	@ManyToOne
	private Autor autor;

	@ManyToOne
	private Categoria categoria;

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn,
			LocalDate dataDePublicacao, Autor autor, Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}
		
	public Autor getAutor() {
		return autor;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}
	
}
