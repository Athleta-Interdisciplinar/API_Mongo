package com.example.api_mongo.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document("postagens")
public class Postagem {

    @MongoId
    private String id;
    private String legenda;
    private String imagem;
    private String username;
    private String userFoto;
    private List<String> curtidas;
    private List<String> compartilhamento;
    private String usuarioId;
    private Date data;

    public Postagem(String id, String legenda, String imagem, String username, String userFoto, List<String> curtidas, List<String> compartilhamento, String usuarioId, Date data) {
        this.id = id;
        this.legenda = legenda;
        this.imagem = imagem;
        this.username = username;
        this.userFoto = userFoto;
        this.curtidas = curtidas;
        this.compartilhamento = compartilhamento;
        this.usuarioId = usuarioId;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFoto() {
        return userFoto;
    }

    public void setUserFoto(String userFoto) {
        this.userFoto = userFoto;
    }

    public List<String> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<String> curtidas) {
        this.curtidas = curtidas;
    }

    public List<String> getCompartilhamento() {
        return compartilhamento;
    }

    public void setCompartilhamento(List<String> compartilhamento) {
        this.compartilhamento = compartilhamento;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
