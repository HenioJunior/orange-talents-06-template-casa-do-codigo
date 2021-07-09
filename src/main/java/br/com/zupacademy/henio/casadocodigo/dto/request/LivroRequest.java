package br.com.zupacademy.henio.casadocodigo.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.henio.casadocodigo.modelo.Autor;
import br.com.zupacademy.henio.casadocodigo.modelo.Categoria;
import br.com.zupacademy.henio.casadocodigo.modelo.Livro;
import br.com.zupacademy.henio.casadocodigo.validacao.UniqueValue;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @Min(value = 20)
    @NotNull
    private BigDecimal preco;

    @Min(value = 100)
    @NotNull
    private Integer numeroDePaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDePublicacao;

    @NotNull
    private long idAutor;

    @NotNull
    private long idCategoria;

    @JsonCreator
    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
    		Integer numeroDePaginas, String isbn, LocalDate dataDePublicacao, long idAutor, long idCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
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
	
	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

    public Livro toModel(EntityManager manager) {
       @NotNull Autor autor = manager.find(Autor.class, idAutor);
       @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn, this.dataDePublicacao, autor, categoria);
    }

	@Override
	public String toString() {
		return "Livro cadastrado: [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroDePaginas=" + numeroDePaginas + ", isbn=" + isbn + ", dataDePublicacao=" + dataDePublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "]";
	}
      
}
