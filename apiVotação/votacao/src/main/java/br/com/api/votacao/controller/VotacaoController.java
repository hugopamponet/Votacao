package br.com.api.votacao.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.votacao.DTO.VotacaoDTO;
import br.com.api.votacao.model.VotacaoModel;
import br.com.api.votacao.repository.VotacaoRepository;
import br.com.api.votacao.service.VotacaoService;

@RestController
@RequestMapping("/votacao")
public record VotacaoController(VotacaoService votacaoService, VotacaoRepository votacaoRepository) {

	@PostMapping("/{pautaId}")
    public ResponseEntity<String> votar(@PathVariable String pautaId, @RequestBody VotacaoDTO dto) {
        return votacaoService.registroVoto(pautaId, dto);
    }

    @GetMapping
    public List<VotacaoModel> listarVotos() {
        return votacaoRepository.findAll();
    }
}