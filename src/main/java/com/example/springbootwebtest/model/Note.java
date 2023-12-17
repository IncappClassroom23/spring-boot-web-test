package com.example.springbootwebtest.model;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    private int id;
    private String content;
}
