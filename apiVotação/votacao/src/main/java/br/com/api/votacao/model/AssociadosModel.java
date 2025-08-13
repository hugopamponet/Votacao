package br.com.api.votacao.model;

import java.time.LocalDate;

import br.com.api.votacao.enumeration.SexoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "associados")
@Getter
@Setter
public class AssociadosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dtaNascimento")
	private LocalDate nascimento;
	
	
	@Column(name = "sexo")
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "senha")
	private String senha;
}