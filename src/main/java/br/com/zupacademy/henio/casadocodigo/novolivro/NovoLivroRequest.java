package br.com.zupacademy.henio.casadocodigo.novolivro;

import br.com.zupacademy.henio.casadocodigo.novacategoria.Categoria;
import br.com.zupacademy.henio.casadocodigo.novoautor.Autor;
import br.com.zupacademy.henio.casadocodigo.validacao.ExistId;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
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
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDePublicacao;

    @NotNull
    @ExistId(domainClass = Autor.class, fieldName = "id")
    private long idAutor;

    @NotNull
    @ExistId(domainClass = Categoria.class, fieldName = "id")
    private long idCategoria;

    @JsonCreator
    public NovoLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
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

    public Livro toModel(EntityManager manager) {
       @NotNull Autor autor = manager.find(Autor.class, idAutor);
       @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn, this.dataDePublicacao, autor, categoria);
    }
}
