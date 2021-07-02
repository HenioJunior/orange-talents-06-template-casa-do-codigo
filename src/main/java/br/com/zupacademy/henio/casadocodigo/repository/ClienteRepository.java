package br.com.zupacademy.henio.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.henio.casadocodigo.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	}
