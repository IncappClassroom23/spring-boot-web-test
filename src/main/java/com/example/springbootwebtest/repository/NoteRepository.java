package com.example.springbootwebtest.repository;

import com.example.springbootwebtest.model.Note;

public interface NoteRepository {
    Note getNoteById(int id);
}
