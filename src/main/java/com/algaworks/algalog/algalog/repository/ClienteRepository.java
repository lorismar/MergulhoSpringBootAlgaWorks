package com.algaworks.algalog.algalog.repository;

import com.algaworks.algalog.algalog.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public  interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeIsContaining(String nome);  /* Like do SQL */

     Optional<Cliente> findByEmail(String email);

}
