package com.example.springbootwebtest.repository;

import com.example.springbootwebtest.model.Note;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("customNoteRepository")
public class CustomNoteRepositoryImpl implements NoteRepository{
    @Override
    public Note getNoteById(int id) {
        return new Note(1,"Custom value");
    }
}
