package com.example.api_mongo.controllers;

import com.example.api_mongo.documents.Postagem;
import com.example.api_mongo.services.PostagemService;
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

    @PostMapping("/adicionar")
    public ResponseEntity<Postagem> salvarPostagem(@RequestBody Postagem postagem){
        try{
            Postagem postagemSalva = postagemService.salvarPostagem(postagem);
            return ResponseEntity.status(HttpStatus.OK).body(postagemSalva);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

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

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirPostagem(@PathVariable String id){
        try {
            postagemService.excluirPostagem(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

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

    @PostMapping("/like/{id}/{username}")
    public ResponseEntity<Postagem> interaçãoCurtirPostagem(@PathVariable String id, @PathVariable String username){
        try{
            Postagem response = postagemService.adicionarCurtida(id,username);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
