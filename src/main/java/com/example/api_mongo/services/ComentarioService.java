package com.example.api_mongo.services;

import com.example.api_mongo.documents.Comentario;
import com.example.api_mongo.repositories.ComentarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComentarioService {
    private ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario salvarComentario(Comentario comentario){
        comentario.setData(new Date());
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarPorIdPostReferente(String idPostReferente){
        return comentarioRepository.findAllByIdPostReferente(idPostReferente);
    }
}
