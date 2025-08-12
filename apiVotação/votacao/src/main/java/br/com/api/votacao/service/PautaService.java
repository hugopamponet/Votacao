package br.com.api.votacao.service;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.votacao.DTO.PautaDTO;
import br.com.api.votacao.model.PautaModel;
import br.com.api.votacao.repository.PautaRepository;

@Service
public record PautaService(PautaRepository pautaRepository) {

	public ResponseEntity<String> descricao(PautaDTO dto) {
		if(pautaRepository.existsByDescricao(dto.getDescricao())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Pauta já cadastrada");
		}
		
		PautaModel pauta = new PautaModel();
		pauta.setTitulo(dto.getTitulo());
		pauta.setDescricao(dto.getDescricao());
		pauta.setTempoPauta(LocalDateTime.now());
		pauta.setStatus("Aberta");
		
		pautaRepository.save(pauta);
		
		return ResponseEntity.ok("Pauta cadastrada e aberta para votação por 1min.");
	}
}
