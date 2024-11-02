package com.example.api_mongo.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document("comentarios")
public class Comentario {
    @MongoId
    private String id;

    private String idPostReferente;
    private String idUsuario;
    private String username;
    private String userFoto;

    private String idUsuarioReferente;

    private String texto;

    private Date data;

    public Comentario(String id, String idPostReferente, String idUsuario, String username, String userFoto, String idUsuarioReferente, String texto, Date data) {
        this.id = id;
        this.idPostReferente = idPostReferente;
        this.idUsuario = idUsuario;
        this.username = username;
        this.userFoto = userFoto;
        this.idUsuarioReferente = idUsuarioReferente;
        this.texto = texto;
        this.data = data;
    }

    public Comentario(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPostReferente() {
        return idPostReferente;
    }

    public void setIdPostReferente(String idPostReferente) {
        this.idPostReferente = idPostReferente;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getIdUsuarioReferente() {
        return idUsuarioReferente;
    }

    public void setIdUsuarioReferente(String idUsuarioReferente) {
        this.idUsuarioReferente = idUsuarioReferente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
