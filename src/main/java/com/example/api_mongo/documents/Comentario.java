package com.example.api_mongo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("comentarios")
public class Comentario {
    @Id
    private String id;

    private String idPostReferente;
    private String idUsuario;

    private String idUsuarioReferente;

    private String texto;

    private Date data;

    public Comentario(String id, String idPostReferente, String idUsuario, String idUsuarioReferente, String texto, Date data) {
        this.id = id;
        this.idPostReferente = idPostReferente;
        this.idUsuario = idUsuario;
        this.idUsuarioReferente = idUsuarioReferente;
        this.texto = texto;
        this.data = data;
    }
}
