package com.example.api_mongo.repositories;

import com.example.api_mongo.documents.Comentario;
import com.example.api_mongo.documents.Curtida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurtidaRepository extends MongoRepository<Curtida,String> {
    List<Curtida> findAllByIdPostReferente(String idPostReferente);

}
