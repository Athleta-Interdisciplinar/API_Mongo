package com.example.api_mongo.controllers;

import com.example.api_mongo.documents.Comentario;
import com.example.api_mongo.services.ComentarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Adicionar comentário", description = "Cadastra um novo comentário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentário adicionado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comentario.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao adicionar o comentário",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/adicionar")
    public ResponseEntity<Comentario> adicionarComentario(@RequestBody Comentario comentario){
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.salvarComentario(comentario));
    }

    @Operation(summary = "Listar comentários por ID do post", description = "Retorna uma lista de comentários relacionados a um post específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentários encontrados com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comentario.class))),
            @ApiResponse(responseCode = "404", description = "Post não encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/listar/{idPostReferente}")
    public ResponseEntity<List<Comentario>> listarPorIdPostReferente(@PathVariable String idPostReferente){
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.listarPorIdPostReferente(idPostReferente));
    }
}
