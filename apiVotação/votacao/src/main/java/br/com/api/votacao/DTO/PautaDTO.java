package br.com.api.votacao.DTO;

import java.time.LocalDateTime;

import br.com.api.votacao.enumeration.VotingEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PautaDTO {

	private String titulo;
	
	private String descricao;
	
	private LocalDateTime tempoPauta;
	
	@Enumerated(EnumType.STRING)
	private VotingEnum voto;
}