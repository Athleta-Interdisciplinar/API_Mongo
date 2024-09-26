package com.example.api_mongo.repositories;

import com.example.api_mongo.documents.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ComentarioRepository extends MongoRepository<Comentario,String> {

    @Query("{idPostReferente:'?0'}")
    List<Comentario> findAll(String idPostReferente);
}
