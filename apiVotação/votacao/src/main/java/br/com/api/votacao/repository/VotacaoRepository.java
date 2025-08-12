package br.com.api.votacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.votacao.model.PautaModel;
import br.com.api.votacao.model.VotacaoModel;

public interface VotacaoRepository extends JpaRepository<VotacaoModel, String>{
	
	List<VotacaoModel> findByPauta(PautaModel pauta);

}