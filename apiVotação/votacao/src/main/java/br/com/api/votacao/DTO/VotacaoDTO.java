package br.com.api.votacao.DTO;

import br.com.api.votacao.enumeration.VotingEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotacaoDTO {

	@Enumerated(EnumType.STRING)
	private VotingEnum votacao;
}