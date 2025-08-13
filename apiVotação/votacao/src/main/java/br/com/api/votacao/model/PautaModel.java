package br.com.api.votacao.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pauta")
@Getter
@Setter
public class PautaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "tempoPauta")
	private LocalDateTime tempoPauta;
	
	@Column(name = "status")
	private String status;
	
	@PrePersist
	public void prePersist() {
		if (tempoPauta == null) {
			tempoPauta = LocalDateTime.now();
		}
		if (status == null) {
			status = "Aberta";
		}
	}
}