package com.example.springbootwebtest.service;

import com.example.springbootwebtest.model.Note;
import org.springframework.stereotype.Service;


public interface NoteService {
    Note getNoteById(int id);
}
