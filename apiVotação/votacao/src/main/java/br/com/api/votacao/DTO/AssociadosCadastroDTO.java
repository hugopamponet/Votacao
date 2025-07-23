package br.com.api.votacao.DTO;

import br.com.api.votacao.enumeration.SexoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AssociadosCadastroDTO {
	
	private String nome;
	private String nascimento;
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	private String email;
	private String cpf;
	private String empresa;
	private String senha;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}	
}