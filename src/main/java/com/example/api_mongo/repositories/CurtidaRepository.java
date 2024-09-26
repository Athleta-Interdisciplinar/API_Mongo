package com.example.api_mongo.repositories;

import com.example.api_mongo.documents.Comentario;
import com.example.api_mongo.documents.Curtida;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CurtidaRepository extends MongoRepository<Curtida,String> {
    List<Curtida> findAllByIdPostReferente(String idPostReferente);
}
