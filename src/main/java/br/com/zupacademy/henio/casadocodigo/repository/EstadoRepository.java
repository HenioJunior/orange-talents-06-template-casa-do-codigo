package br.com.zupacademy.henio.casadocodigo.repository;

import br.com.zupacademy.henio.casadocodigo.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	@Query("SELECT obj FROM Estado obj WHERE obj.pais.id = :idPais ORDER BY obj.nome")
	public List<Estado> findByEstado(@Param("idPais") Long idPais);

	public Optional<Estado> findByNome(@NotBlank String estado);

	Optional<Estado> findByNomeAndPaisId(String nome, long paisId);
}
