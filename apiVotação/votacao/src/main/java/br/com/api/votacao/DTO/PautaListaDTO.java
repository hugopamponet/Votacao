package br.com.api.votacao.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PautaListaDTO {

	private String titulo;
    private String descricao;
    private String status;
    private long tempoRestante;
}