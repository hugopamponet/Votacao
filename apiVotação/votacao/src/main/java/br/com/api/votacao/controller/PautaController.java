package br.com.api.votacao.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.votacao.DTO.PautaDTO;
import br.com.api.votacao.enumeration.VotingEnum;
import br.com.api.votacao.model.PautaModel;
import br.com.api.votacao.model.VotacaoModel;
import br.com.api.votacao.repository.PautaRepository;
import br.com.api.votacao.repository.VotacaoRepository;
import br.com.api.votacao.service.PautaService;

@RestController
@RequestMapping("/pauta")
public record PautaController(PautaService pautaService, PautaRepository pautaRepository,
		VotacaoRepository votacaoRepository) {

	@PostMapping
	public ResponseEntity<String> criarPauta(@RequestBody PautaDTO dto) {
		return pautaService.descricao(dto);
	}

	@GetMapping
	public List<PautaModel> listarPautas() {
		return pautaRepository.findAll();
	}

	public ResponseEntity<PautaModel> buscarPauta(@PathVariable String id) {
		return pautaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/{id}/resultado")
	public ResponseEntity<String> resultadoPauta(@PathVariable String id) {
		return pautaRepository.findById(id).map(pauta -> {
			if (!"Fechada".equals(pauta.getStatus())) {
				return ResponseEntity.badRequest().body("A pauta ainda está aberta para votação.");
			}

			List<VotacaoModel> votos = votacaoRepository.findByPauta(pauta);

			long sim = votos.stream().filter(v -> VotingEnum.Sim.equals(v.getVotacao())).count();

			long nao = votos.stream().filter(v -> VotingEnum.Nao.equals(v.getVotacao())).count();

			String resultado = String.format("Resultado da pauta '%s': SIM = %d | NÃO = %d", pauta.getTitulo(), sim,
					nao);

			return ResponseEntity.ok(resultado);

		}).orElse(ResponseEntity.notFound().build());
	}
}