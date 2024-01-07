package com.example.springbootwebtest.model;

import jakarta.persistence.Id;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
