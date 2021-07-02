package br.com.zupacademy.henio.casadocodigo.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.henio.casadocodigo.modelo.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	
	@Query("SELECT obj FROM Estado obj WHERE obj.pais.id = :idPais ORDER BY obj.nome")
	public List<Estado> findByEstado(@Param("idPais") Long idPais);

	public Estado findByNome(@NotBlank String estado);

}
