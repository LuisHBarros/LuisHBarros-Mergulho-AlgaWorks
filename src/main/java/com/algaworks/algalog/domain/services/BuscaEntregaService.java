package com.algaworks.algalog.domain.services;


import com.algaworks.algalog.domain.model.Entrega;
import org.springframework.stereotype.Service;

@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;
    public Entrega buscar(Long entredaId){
        return entregaRepository
    }
}
