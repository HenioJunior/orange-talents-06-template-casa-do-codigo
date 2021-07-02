package br.com.zupacademy.henio.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.henio.casadocodigo.modelo.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
	
	public List<Pais> findAllByOrderByNome();

	public Pais findByNome(String nomePais);

}
