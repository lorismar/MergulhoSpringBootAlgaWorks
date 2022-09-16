package com.algaworks.algalog.algalog.execptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class Problema {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Campo{
        private String nome;
        private String mensagem;
    }

}
