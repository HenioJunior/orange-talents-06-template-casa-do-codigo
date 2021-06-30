package br.com.zupacademy.henio.casadocodigo.novolivro;

public class LivrosResponse {
	
	private Long id;
	private String titulo;

	
	public LivrosResponse(Livro entidade){
        this.id = entidade.getId();
        this.titulo = entidade.getTitulo();
    }


	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}
