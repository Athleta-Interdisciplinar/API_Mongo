package com.example.api_mongo.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;

@Document("postagens")
@Schema(description = "Representa uma postagem no banco")
public class Postagem {

    @MongoId
    @Schema(description = "ID único da postagem", example = "60c72b2f9f1b2c001f8d4c1a")
    private String id;

    @Schema(description = "Legenda da postagem", example = "Este é um post muito interessante!")
    private String legenda;

    @Schema(description = "URL da imagem associada à postagem", example = "https://example.com/image.jpg")
    private String imagem;

    @Schema(description = "Nome de usuário da pessoa que fez a postagem", example = "johndoe")
    private String username;

    @Schema(description = "Foto de perfil do usuário", example = "https://example.com/user-profile.jpg")
    private String userFoto;

    @Schema(description = "Lista de IDs dos usuários que curtiram a postagem", example = "[\"60c72b2f9f1b2c001f8d4c1a\", \"60c72b2f9f1b2c001f8d4c1b\"]")
    private List<String> curtidas;

    @Schema(description = "Lista de IDs dos usuários que compartilharam a postagem", example = "[\"60c72b2f9f1b2c001f8d4c1c\", \"60c72b2f9f1b2c001f8d4c1d\"]")
    private List<String> compartilhamento;

    @Schema(description = "ID do usuário que criou a postagem", example = "60c72b2f9f1b2c001f8d4c1e")
    private String usuarioId;

    @Schema(description = "Data e hora da criação da postagem", example = "2023-11-06T15:00:00Z")
    private Date data;

    @Schema(description = "Lista de IDs de fóruns aos quais a postagem pertence", example = "[\"forum1\", \"forum2\"]")
    private List<String> foruns;

    public Postagem(String id, String legenda, String imagem, String username, String userFoto, List<String> curtidas, List<String> compartilhamento, String usuarioId, Date data, List<String> foruns) {
        this.id = id;
        this.legenda = legenda;
        this.imagem = imagem;
        this.username = username;
        this.userFoto = userFoto;
        this.curtidas = curtidas;
        this.compartilhamento = compartilhamento;
        this.usuarioId = usuarioId;
        this.data = data;
        this.foruns = foruns;
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

    public List<String> getForuns() {
        return foruns;
    }

    public void setForuns(List<String> foruns) {
        this.foruns = foruns;
    }
}
