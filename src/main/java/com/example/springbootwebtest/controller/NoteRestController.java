package com.example.springbootwebtest.controller;

import com.example.springbootwebtest.model.Note;
import com.example.springbootwebtest.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/note/")
public class NoteRestController {

    @Autowired
    NoteService noteService;

    @GetMapping(value = "{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id){
        Note note = noteService.getNoteById(id);
        return note!=null ? ResponseEntity.ok().body(note):ResponseEntity.notFound().build();
    }

    @PostMapping(value = "addNote")
    public ResponseEntity<String> addNote(@RequestBody Note note){
        int result = noteService.save(note);
        return result>0?ResponseEntity.ok().body("Successfully Added"):ResponseEntity.badRequest().build();
    }
}
