package com.rogerdenisvieira.hellowebflux.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Playlist {

    @Id
    private String id;

    public Playlist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String name;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
