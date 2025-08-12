package br.com.api.votacao.service;

import org.springframework.http.ResponseEntity;

import br.com.api.votacao.DTO.VotacaoDTO;
import br.com.api.votacao.model.PautaModel;
import br.com.api.votacao.model.VotacaoModel;
import br.com.api.votacao.repository.PautaRepository;
import br.com.api.votacao.repository.VotacaoRepository;

public record VotacaoService(VotacaoRepository votacaoRepository, PautaRepository pautaRepository) {

	public ResponseEntity<String> registroVoto(String pautaId, VotacaoDTO dto) {
		PautaModel pauta = pautaRepository.findById(pautaId).orElse(null);
		
		if(pauta == null) {
			return ResponseEntity.badRequest().body("Pauta não existe");
		}
		if(!"Aberta".equals(pauta.getStatus())) {
			return ResponseEntity.badRequest().body("Pauta fechada.");
		}
		
		VotacaoModel votacao = new VotacaoModel();
		votacao.setVotacao(dto.getVotacao());
		votacao.setPauta(pauta);
		
		votacaoRepository.save(votacao);
		
		return ResponseEntity.ok("Voto Registrado.");
	}
}