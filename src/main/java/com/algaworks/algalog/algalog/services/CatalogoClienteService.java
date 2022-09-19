package com.algaworks.algalog.algalog.services;

import com.algaworks.algalog.algalog.exception.NegocioExecption;
import com.algaworks.algalog.algalog.model.Cliente;
import com.algaworks.algalog.algalog.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso){
            throw  new NegocioExecption("Já existe um email com este e-mail.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long ClienteId){
        clienteRepository.deleteById(ClienteId);
    }

}
