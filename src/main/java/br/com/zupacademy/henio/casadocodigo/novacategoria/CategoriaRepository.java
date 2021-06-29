package br.com.zupacademy.henio.casadocodigo.novacategoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Optional<Categoria> findByNome(String nome);

	

}
