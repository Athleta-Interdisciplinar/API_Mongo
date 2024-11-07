package com.example.api_mongo.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Date;

@Document("comentarios")
@Schema(description = "Representa um comentário em um post no banco")
public class Comentario {
    @MongoId
    @Schema(description = "ID único do comentário", example = "60c72b2f9f1b2c001f8d4c1a")
    private String id;

    @Schema(description = "ID do post referente ao comentário", example = "60c72b2f9f1b2c001f8d4c1b")
    private String idPostReferente;

    @Schema(description = "ID do usuário que fez o comentário", example = "60c72b2f9f1b2c001f8d4c1c")
    private String idUsuario;

    @Schema(description = "Nome de usuário do comentarista", example = "johndoe")
    private String username;

    @Schema(description = "Foto de perfil do usuário que comentou", example = "https://example.com/user-profile.jpg")
    private String userFoto;

    @Schema(description = "ID do usuário referente a quem o comentário se destina", example = "60c72b2f9f1b2c001f8d4c1d")
    private String idUsuarioReferente;

    @Schema(description = "Texto do comentário", example = "Excelente post, muito informativo!")
    private String texto;

    @Schema(description = "Data e hora da postagem do comentário", example = "2023-11-06T15:00:00Z")
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
