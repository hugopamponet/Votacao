package br.com.api.votacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.votacao.DTO.AssociadosCadastroDTO;
import br.com.api.votacao.DTO.AssociadosLoginDTO;
import br.com.api.votacao.service.AssociadosService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/portal")
public record AssociadosController(AssociadosService assocaidosService) {
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastroAssociados(@RequestBody AssociadosCadastroDTO dto) {
		return assocaidosService.cadastroAssociados(dto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAssociados(@RequestBody AssociadosLoginDTO dto) {
		return assocaidosService.loginAssociado(dto);
	}
	
	}