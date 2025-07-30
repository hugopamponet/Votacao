package br.com.api.votacao.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.votacao.DTO.AssociadosLoginDTO;
import br.com.api.votacao.DTO.AssociadosRegisterDTO;
import br.com.api.votacao.model.AssociadosModel;
import br.com.api.votacao.repository.AssociadosRepository;

@Service
public record AssociadosService(AssociadosRepository associadosRepository) {
	
	public ResponseEntity<String> register(AssociadosRegisterDTO dto) {
		if (associadosRepository.existsByName(dto.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já existe");
		}
		if (associadosRepository.existsByCpf(dto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já existe");
		}
		if (associadosRepository.existsByEmail(dto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já existe");
		}
		if (associadosRepository.existsByUser(dto.getUser())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");
		}
		
		AssociadosModel associados = new AssociadosModel();
		associados.setName(dto.getName());
		associados.setCpf(dto.getCpf());
		associados.setEmail(dto.getEmail());
		associados.setEmpresa(dto.getEmpresa());
		associados.setNascimento(dto.getNascimento());
		associados.setUser(dto.getUser());
		associados.setSenha(dto.getSenha());
		
		associadosRepository.save(associados);
		
		return ResponseEntity.ok("Cadastro Realizado com sucesso!");
	}
	
	public ResponseEntity<String> login(AssociadosLoginDTO dto) {
		Optional<AssociadosModel> associados = associadosRepository.findByUser(dto.getUser());
		
		if (associados.isPresent() && associados.get().getSenha().equals(dto.getSenha()) ) {
			return ResponseEntity.ok("Login realizado");
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos.");
	}
}