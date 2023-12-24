package com.example.springbootwebtest.service;

import com.example.springbootwebtest.model.Note;
import com.example.springbootwebtest.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    @Qualifier("noteRepository")
    NoteRepository noteRepository;

    @Override
    public Note getNoteById(int id) {
        return noteRepository.getNoteById(id);
    }
}
