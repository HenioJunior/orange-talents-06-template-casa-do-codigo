package br.com.zupacademy.henio.casadocodigo.detalhelivro;

import br.com.zupacademy.henio.casadocodigo.novoautor.Autor;

public class DetalheAutorResponse {
	
	private String autor;
	private String descricao;

	public DetalheAutorResponse(Autor entidade) {
		autor = entidade.getNome();
		descricao = entidade.getDescricao();
	}

	public String getAutor() {
		return autor;
	}

	public String getDescricao() {
		return descricao;
	}
}
