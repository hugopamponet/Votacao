package br.com.api.votacao.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.votacao.DTO.AssociadosCadastroDTO;
import br.com.api.votacao.DTO.AssociadosLoginDTO;
import br.com.api.votacao.model.AssociadosModel;
import br.com.api.votacao.repository.AssociadosRepository;

@Service
public record AssociadosService(AssociadosRepository associadosRepository) {
	
	public ResponseEntity<String> cadastroAssociados(AssociadosCadastroDTO dto) {
		
		if (associadosRepository.existsByNome(dto.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Associado já cadastrado!");
		}
		
		if (associadosRepository.existsByEmail(dto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail do associado já existe");
		}
		
		if (associadosRepository.existsByCpf(dto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF do associado já cadastrado!");
		}
		
		AssociadosModel associados = new AssociadosModel();
		associados.setNome(dto.getNome());
		associados.setCpf(dto.getCpf());
		associados.setEmail(dto.getEmail());
		associados.setNascimento(dto.getNascimento());
		associados.setEmpresa(dto.getEmpresa());
		associados.setSexo(dto.getSexo());
		associados.setSenha(dto.getSenha());
		
		associadosRepository.save(associados);
		
		return ResponseEntity.ok("Associado cadastrado com sucesso!");
	}
	
	public ResponseEntity<String> loginAssociado(AssociadosLoginDTO dto) {
		Optional<AssociadosModel> associados = associadosRepository.findByNome(dto.getUsuario());
		
		if (associados.isPresent() && associados.get().getSenha().equals(dto.getSenha())) {
			return ResponseEntity.ok("Login realizado");
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos.");
	}
}