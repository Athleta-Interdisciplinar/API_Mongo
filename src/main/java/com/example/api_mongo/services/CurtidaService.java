package com.example.api_mongo.services;

import com.example.api_mongo.documents.Curtida;
import com.example.api_mongo.repositories.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CurtidaService {

    private CurtidaRepository curtidaRepository;

    @Autowired
    public CurtidaService(CurtidaRepository curtidaRepository) {
        this.curtidaRepository = curtidaRepository;
    }

    public Curtida salvarCurtida(Curtida curtida){
        curtida.setData(new Date());
        return curtidaRepository.save(curtida);
    }

    public List<Curtida> listarPorIdPostReferente(String idPostReferente){
        return curtidaRepository.findAllByIdPostReferente(idPostReferente);
    }

}
