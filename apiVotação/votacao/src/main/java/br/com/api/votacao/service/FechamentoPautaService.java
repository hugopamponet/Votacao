package br.com.api.votacao.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import br.com.api.votacao.enumeration.VotingEnum;
import br.com.api.votacao.model.PautaModel;
import br.com.api.votacao.model.VotacaoModel;
import br.com.api.votacao.repository.PautaRepository;
import br.com.api.votacao.repository.VotacaoRepository;

public record FechamentoPautaService(PautaRepository pautaRepository, VotacaoRepository votacaoRepository) {

	public FechamentoPautaService(PautaRepository pautaRepository, VotacaoRepository votacaoRepository) {
		this.pautaRepository = pautaRepository;
		this.votacaoRepository = votacaoRepository;
	}
	
	@Scheduled(fixedRate = 10000)
	public void verificarPautas() {
		LocalDateTime agora = LocalDateTime.now();
		List<PautaModel> abertas = pautaRepository.findByStatus("Aberta");
		
		for(PautaModel pauta : abertas) {
			if(pauta.getTempoPauta().plusMinutes(1).isBefore(agora)) {
				pauta.setStatus("Fechada");
				pautaRepository.save(pauta);
				contabilizarVotos(pauta);
			}
		}
	}
	
	private void contabilizarVotos(PautaModel pauta) {
		List<VotacaoModel> votos = votacaoRepository.findByPauta(pauta);
		
		long sim = votos.stream().filter(v -> v.getVotacao() == VotingEnum.Sim).count();
		long nao = votos.stream().filter(v -> v.getVotacao() == VotingEnum.Nao).count();
		
		System.out.println("Resultado da pauta '" + pauta.getTitulo() + "': SIM = " + sim + " | NÃO = " + nao);
	}
}
