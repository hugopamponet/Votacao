package br.com.api.votacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.votacao.DTO.AssociadosLoginDTO;
import br.com.api.votacao.DTO.AssociadosRegisterDTO;
import br.com.api.votacao.service.AssociadosService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public record AssociadosController(AssociadosService associadosService) {
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody AssociadosRegisterDTO dto) {
		return associadosService.register(dto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AssociadosLoginDTO dto) {
		return associadosService.login(dto);
	}

}
