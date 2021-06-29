package br.com.zupacademy.henio.casadocodigo.novacategoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		NovaCategoriaRequest request = (NovaCategoriaRequest) target;
		
		Optional <Categoria> possivelAutor = categoriaRepository.findByNome(request.getNome());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma outra Categoria cadastrada com esse nome: "
					+ request.getNome());
		}
	}
}
