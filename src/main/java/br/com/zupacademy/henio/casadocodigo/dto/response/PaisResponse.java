package br.com.zupacademy.henio.casadocodigo.dto.response;

import br.com.zupacademy.henio.casadocodigo.modelo.Pais;

public class PaisResponse {

    private String nome;
    private Long id;

    public PaisResponse(Pais pais) {
        id = pais.getId();
        nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
