package com.algaworks.algalog.algalog.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany  /** Entidade Entrega/Cliente Muitas entregas possuem um Cliente */
    private Cliente cliente;

    @Embedded  /* Quer abstrair tudo para tabela em Entrada */
    private Destinatario destinatario;
    private BigDecimal taxa;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;


}
