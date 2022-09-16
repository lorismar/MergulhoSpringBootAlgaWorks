package com.algaworks.algalog.algalog.controller;

import com.algaworks.algalog.algalog.model.Cliente;
import com.algaworks.algalog.algalog.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@AllArgsConstructor /* Gera o Código */
@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listar(){

        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());

    }

    @GetMapping("/lista_clientes")
    public List<Cliente> lista_clientes() {
        return clienteRepository.findByNomeIsContaining("Lorismar");
    }

    @GetMapping("/clientes/{id}")
    public Cliente listar(@PathVariable Long id){
        Optional<Cliente> cliente =  clienteRepository.findById(id);

        return cliente.orElse(null);

    }

    @GetMapping("/listar_cliente_id/{id}")
    public ResponseEntity<Object> listar_cliente_id(@PathVariable Long id){

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(!cliente.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
        }

        return ResponseEntity.status(HttpStatus.OK).body(cliente.get());

    }

    @GetMapping("/listar_cliente_lambada/{id}")
    public ResponseEntity<String> listar_cliente_lambada(@PathVariable Long id){

        return clienteRepository.findById(id).map( cliente -> ResponseEntity.ok(cliente.getNome())).orElse(null);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public  Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }


    @PutMapping("clientes/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente) {

        if (!clienteRepository.existsById((clienteId))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
        }
        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){

        if(!clienteRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        clienteRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
