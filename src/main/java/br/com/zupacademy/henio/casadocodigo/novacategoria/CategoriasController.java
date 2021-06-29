package br.com.zupacademy.henio.casadocodigo.novacategoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}
			
	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid NovaCategoriaRequest request) {
		
		Categoria novaCategoria = new Categoria(request.getNome());
		manager.persist(novaCategoria);
		return novaCategoria.toString();
	}
}
