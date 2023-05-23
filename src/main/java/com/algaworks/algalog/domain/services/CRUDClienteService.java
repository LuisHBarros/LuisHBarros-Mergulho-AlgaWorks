package com.algaworks.algalog.domain.services;

import com.algaworks.algalog.domain.Exception.APIException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CRUDClienteService {

    private final ClienteRepository clienteRepository;

    public CRUDClienteService(ClienteRepository clienteRepository){
        super();
        this.clienteRepository = clienteRepository;
    }
    @Transactional
    public Cliente salvar(Cliente cliente){
        if(clienteRepository.findByEmail(cliente.getEmail()).isPresent()){
            throw new APIException("Ja existe um cliente cadastrado com este e-mail");
        }
        return clienteRepository.save(cliente);
    }
    public void deletar(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
