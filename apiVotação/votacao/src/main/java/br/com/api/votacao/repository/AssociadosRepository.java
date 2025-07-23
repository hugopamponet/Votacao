package br.com.api.votacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.votacao.model.AssociadosModel;

public interface AssociadosRepository extends JpaRepository<AssociadosModel, Long>{
	
	List<AssociadosModel> findByNomeContainingIgnoreCase(String nome);
	
	Optional<AssociadosModel> findByNome(String nome);
	boolean existsByNome(String nome);
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);
}