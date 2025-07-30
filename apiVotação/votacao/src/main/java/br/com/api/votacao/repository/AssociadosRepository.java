package br.com.api.votacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.votacao.model.AssociadosModel;

public interface AssociadosRepository extends JpaRepository<AssociadosModel, Long>{
	
	Optional<AssociadosModel> findByUser(String user);
	boolean existsByName(String name);
	boolean existsByUser(String user);
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);
}