package br.com.zupacademy.henio.casadocodigo.dto.response;

public class ListarLivrosResponse {
	
	private Object[] listaDeLivros;
		
	public ListarLivrosResponse(Object[] listaDeLivros){
       this.listaDeLivros = listaDeLivros;
    }

	public Object[] getListaDeLivros() {
		return listaDeLivros;
	}
}
