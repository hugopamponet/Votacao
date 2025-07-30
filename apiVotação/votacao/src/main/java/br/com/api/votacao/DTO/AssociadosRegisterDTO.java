package br.com.api.votacao.DTO;

import java.time.LocalDate;


import br.com.api.votacao.enumeration.SexoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AssociadosRegisterDTO {

	private String name;
	private LocalDate nascimento;
	
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	
	private String email;
	private String cpf;
	private String user;
	private String empresa;
	private String senha;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}