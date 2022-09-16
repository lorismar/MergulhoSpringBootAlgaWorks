package com.algaworks.algalog.algalog.services;

import com.algaworks.algalog.algalog.model.Cliente;
import com.algaworks.algalog.algalog.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long ClienteId){
        clienteRepository.deleteById(ClienteId);
    }

}
