package com.example.api_mongo.controllers;

import com.example.api_mongo.documents.Comentario;
import com.example.api_mongo.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Comentario> adicionarComentario(@RequestBody Comentario comentario){
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.salvarComentario(comentario));
    }

    @GetMapping("/listar/{idPostReferente}")
    public ResponseEntity<List<Comentario>> listarPorIdPostReferent(@PathVariable String idPostReferente){
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.listarPorIdPostReferente(idPostReferente));
    }
}
