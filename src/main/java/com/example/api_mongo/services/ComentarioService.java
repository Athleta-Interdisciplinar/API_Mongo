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

@Service
public class ComentarioService {
    private ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public String salvarComentario(Comentario comentario, HttpServletResponse response) throws JsonProcessingException, JSONException {
        JSONObject responseJson = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        if (comentario.getTexto() == null ||
                comentario.getIdPostReferente() == null ||
                comentario.getData() == null ||
                comentario.getIdUsuarioReferente() == null ||
        comentario.getIdUsuario() == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        comentario = comentarioRepository.save(comentario);
        JSONObject comentarioJSON = new JSONObject(mapper.writeValueAsString(comentario));
        comentarioJSON.put("id",comentario.getId());
        responseJson.put("saveComentarioResponse",comentarioJSON);
        return responseJson.toString();
    }
}
