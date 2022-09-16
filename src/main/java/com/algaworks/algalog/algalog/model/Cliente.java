package com.algaworks.algalog.algalog.model;

import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name="cliente")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    @Column(name ="nome")
    private String nome;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;


    @NotBlank
    @Size(max = 20)
    private String telefone;


    public Cliente(Long id, String nome, String email, String telefone) {
        this.id = 1l;
        this.nome = "sssss";
        this.email = "dxdsdd@yahoo.com.br";
        this.telefone = "65132132";
    }

    public Cliente(){

    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cliente cliente = (Cliente) o;
//        return id.equals(cliente.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
