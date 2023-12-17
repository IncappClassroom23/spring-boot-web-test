package com.example.springbootwebtest.controller;

import com.example.springbootwebtest.model.Note;
import com.example.springbootwebtest.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoteController {

    @Autowired
    NoteService noteService;

    @ResponseBody
    @GetMapping(value = "/getNoteById/{id}")
    public Note getNoteById(@PathVariable int id){
        Note note = noteService.getNoteById(id);
        System.out.println(note);
        return note;
    }
}
