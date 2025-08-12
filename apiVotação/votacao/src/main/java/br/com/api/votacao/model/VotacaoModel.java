package br.com.api.votacao.model;

import br.com.api.votacao.enumeration.VotingEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "votacao")
@Getter
@Setter
public class VotacaoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "votacao")
	private VotingEnum votacao;
	
	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private PautaModel pauta;
}