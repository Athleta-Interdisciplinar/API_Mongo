package com.example.api_mongo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("comentarios")
public class Comentario {

    /*
    	Comentário{
	Id:
	Id_post_referente
	Id_usuario
	Id_usuario_referente
	Texto
	data
	}

     */
    @Id
    private String id;

    private String idPostReferente;
    private String idUsuario;

    private String idUsuarioReferente;

    private String texto;

    private Date data;
}
