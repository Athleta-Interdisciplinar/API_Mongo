package com.example.api_mongo.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document("curtidas")
public class Curtida {
    @MongoId
    private String id;

    private String idPostReferente;
    private String idUsuario;

    private String idUsuarioReferente;

    private Date data;

    public Curtida(String id, String idPostReferente, String idUsuario, String idUsuarioReferente, Date data) {
        this.id = id;
        this.idPostReferente = idPostReferente;
        this.idUsuario = idUsuario;
        this.idUsuarioReferente = idUsuarioReferente;
        this.data = data;
    }

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

    public String getIdUsuarioReferente() {
        return idUsuarioReferente;
    }

    public void setIdUsuarioReferente(String idUsuarioReferente) {
        this.idUsuarioReferente = idUsuarioReferente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
