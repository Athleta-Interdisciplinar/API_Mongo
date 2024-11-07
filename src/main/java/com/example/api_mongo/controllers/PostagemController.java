package com.example.api_mongo.controllers;

import com.example.api_mongo.documents.Postagem;
import com.example.api_mongo.services.PostagemService;
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
@RequestMapping("/api/postagem")
public class PostagemController {
    private PostagemService postagemService;

    @Autowired
    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @Operation(summary = "Salvar postagem", description = "Cadastra uma nova postagem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Postagem salva com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Postagem.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar postagem",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/adicionar")
    public ResponseEntity<Postagem> salvarPostagem(@RequestBody Postagem postagem){
        try{
            Postagem postagemSalva = postagemService.salvarPostagem(postagem);
            return ResponseEntity.status(HttpStatus.OK).body(postagemSalva);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Operation(summary = "Listar postagens", description = "Retorna uma lista de postagens paginadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Postagens encontradas com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Postagem.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao listar postagens",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/listar")
    public ResponseEntity<List<Postagem>> listarPostagens(@RequestParam(defaultValue = "0") int pagina,
                                                          @RequestParam(defaultValue = "10") int tamanho){
        try {
            List<Postagem> listaPostagens = postagemService.listarPostagens(pagina, tamanho);
            return ResponseEntity.status(HttpStatus.OK).body(listaPostagens);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Operation(summary = "Excluir postagem", description = "Exclui uma postagem específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Postagem excluída com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Erro ao excluir postagem",
                    content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirPostagem(@PathVariable String id){
        try {
            postagemService.excluirPostagem(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Operation(summary = "Listar postagens por ID", description = "Retorna uma lista de postagens filtradas pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Postagens filtradas encontradas com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Postagem.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao listar postagens",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/listarPorId")
    public ResponseEntity<List<Postagem>> listarPostagensPorId(@RequestParam(defaultValue = "0") int pagina,
                                                               @RequestParam(defaultValue = "10") int tamanho,
                                                               @RequestParam() int id){
        try {
            List<Postagem> listaPostagens = postagemService.listarPostagensPorId(pagina, tamanho, Integer.toString(id));
            return ResponseEntity.status(HttpStatus.OK).body(listaPostagens);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Operation(summary = "Listar postagens por fórum", description = "Retorna uma lista de postagens filtradas por fórum")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Postagens filtradas por fórum encontradas com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Postagem.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao listar postagens por fórum",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/listar/{forum}")
    public ResponseEntity<List<Postagem>> listarPostagensPorForum(@RequestParam(defaultValue = "0") int pagina,
                                                                  @RequestParam(defaultValue = "10") int tamanho,
                                                                  @PathVariable String forum){
        try{
            List<Postagem> listaPostagens = postagemService.listarPostagensPorForum(pagina, tamanho, forum);
            return ResponseEntity.status(HttpStatus.OK).body(listaPostagens);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Operation(summary = "Curtir postagem", description = "Adiciona uma curtida à postagem especificada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curtida adicionada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Postagem.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao adicionar curtida",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/like/{id}/{username}")
    public ResponseEntity<Postagem> interaçãoCurtirPostagem(@PathVariable String id, @PathVariable String username){
        try{
            Postagem response = postagemService.adicionarCurtida(id, username);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
