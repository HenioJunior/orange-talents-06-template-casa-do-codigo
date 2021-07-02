package br.com.zupacademy.henio.casadocodigo.dto.response;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.henio.casadocodigo.modelo.Livro;

public class DetalheLivroResponse {

	private AutorResponse autor;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;
	private String dataDePublicacao;

	public DetalheLivroResponse(Livro entidade) {
		titulo = entidade.getTitulo();
		autor = new AutorResponse(entidade.getAutor());
		isbn = entidade.getIsbn();
		numeroDePaginas = entidade.getNumeroDePaginas();
		resumo = entidade.getResumo();
		sumario = entidade.getSumario();
		preco = entidade.getPreco();
		dataDePublicacao = entidade.getDataDePublicacao()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
		
	public AutorResponse getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
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

	public String getDataDePublicacao() {
		return dataDePublicacao;
	}
}
