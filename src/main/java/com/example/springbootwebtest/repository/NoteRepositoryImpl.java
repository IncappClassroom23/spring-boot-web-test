package com.example.springbootwebtest.repository;

import com.example.springbootwebtest.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositoryImpl implements NoteRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Note getNoteById(int id) {
        return jdbcTemplate.queryForObject("Select * from note where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Note.class));
    }
}
