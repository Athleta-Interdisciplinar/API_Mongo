package com.example.api_mongo.controllers;

import com.example.api_mongo.documents.Comentario;
import com.example.api_mongo.documents.Curtida;
import com.example.api_mongo.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curtida")
public class CurtidaController {

    private CurtidaService curtidaService;

    @Autowired
    public CurtidaController(CurtidaService curtidaService) {
        this.curtidaService = curtidaService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Curtida> adicionarComentario(@RequestBody Curtida curtida){
        return ResponseEntity.status(HttpStatus.OK).body(curtidaService.salvarCurtida(curtida));
    }

    @GetMapping("/listar/{idPostReferente}")
    public ResponseEntity<List<Curtida>> listarPorIdPostReferent(@PathVariable String idPostReferente){
        return ResponseEntity.status(HttpStatus.OK).body(curtidaService.listarPorIdPostReferente(idPostReferente));
    }

    @GetMapping("/keepalive")
    public ResponseEntity<?> keepAlive(){
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
