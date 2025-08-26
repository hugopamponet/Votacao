package br.com.api.votacao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
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

    public String getTempoPautaFormatado() {
        if (tempoPauta != null) {
            return tempoPauta.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        }
        return null;
    }
}
