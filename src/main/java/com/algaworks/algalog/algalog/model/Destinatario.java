package com.algaworks.algalog.algalog.model;


import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Embeddable
public class Destinatario {

    @Column(name = "destinario_nome")
    private String nome;

    @Column(name = "destinario_logradouro")
    private String logradouro;


    @Column(name = "destinatario_numero")
    private String numero;

    @Column(name = "destinatario_complemento")
    private String complemento;

  @NotNull
    @Column(name = "destinario_bairro")
    private String bairro;
}
