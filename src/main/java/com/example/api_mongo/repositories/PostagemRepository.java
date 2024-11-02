package com.example.api_mongo.repositories;

import com.example.api_mongo.documents.Postagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostagemRepository extends MongoRepository<Postagem,String> {
    Page<Postagem> findAll(Pageable pageable);
    Page<Postagem> findAllByUsuarioId(Pageable pageable,String userId);
    Page<Postagem> findAllByIdForum(Pageable pageable, int idForum);
}
