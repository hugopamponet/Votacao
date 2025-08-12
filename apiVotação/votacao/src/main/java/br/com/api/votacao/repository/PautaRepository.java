package br.com.api.votacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.votacao.model.PautaModel;

public interface PautaRepository extends JpaRepository<PautaModel, String>{

	Optional<PautaModel> findByDescricao(String descricao);
	boolean existsByDescricao(String descricao);
	
	List<PautaModel> findByStatus(String status);
}