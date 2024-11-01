package com.example.api_mongo.services;

import com.example.api_mongo.documents.Postagem;
import com.example.api_mongo.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class PostagemService {
    private PostagemRepository postagemRepository;

    @Autowired
    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public Postagem salvarPostagem(Postagem postagem){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        String formattedDate = dateFormat.format(new Date());

        try {
            postagem.setData(dateFormat.parse(formattedDate));
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return postagemRepository.save(postagem);
    }

    public List<Postagem> listarPostagens(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by(Sort.Direction.DESC, "data"));
        Page<Postagem> postagens = postagemRepository.findAll(pageable);
        return postagens.getContent();
    }

    public List<Postagem> listarPostagensPorId(int pagina, int tamanho, String usuarioId) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by(Sort.Direction.DESC, "data"));
        Page<Postagem> postagens = postagemRepository.findAllByUsuarioId(pageable, usuarioId);
        return postagens.getContent();
    }

    public void excluirPostagem(String id){
        postagemRepository.deleteById(id);
    }

}
