package com.algaworks.algalog.algalog.controller;

import com.algaworks.algalog.algalog.model.Cliente;
import com.algaworks.algalog.algalog.repository.ClienteRepository;
import com.algaworks.algalog.algalog.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@AllArgsConstructor /* Gera o Código */
@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

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
    public  Cliente adicionar(@Valid @RequestBody Cliente cliente){
        return clienteService.salvar(cliente);

    }

    @PutMapping("clientes/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {

        if (!clienteRepository.existsById((clienteId))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
        }
        cliente.setId(clienteId);
        cliente = clienteService.salvar(cliente);

        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){

        if(!clienteRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        clienteService.excluir(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
