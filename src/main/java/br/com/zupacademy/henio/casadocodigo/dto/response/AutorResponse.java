package br.com.zupacademy.henio.casadocodigo.dto.response;

import br.com.zupacademy.henio.casadocodigo.modelo.Autor;

public class AutorResponse {
	
	private String autor;
	private String descricao;

	public AutorResponse(Autor entidade) {
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
