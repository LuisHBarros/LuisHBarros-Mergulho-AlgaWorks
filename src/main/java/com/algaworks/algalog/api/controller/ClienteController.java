package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.services.CRUDClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

     private final ClienteRepository clienteRepository;

     private final CRUDClienteService clienteService;
     public ClienteController(ClienteRepository clienteRepository, CRUDClienteService clienteService){
         super();
         this.clienteRepository = clienteRepository;
         this.clienteService = clienteService;
     }

    @PersistenceContext
    private EntityManager manager;

    @GetMapping()
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Cliente> adicionar(@Valid @RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Object> atualizar(@PathVariable Long clienteId,
                                            @Valid @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe nenhum cliente cadastrado com esse Id.");
        }
        cliente.setId(clienteId);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
    }
    @DeleteMapping("{clienteId}")
    public ResponseEntity<Object> deletar(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe nenhum cliente cadastrado com esse Id.");
        }
        clienteService.deletar(clienteId);
        return ResponseEntity.status(204).build();
    }

}



