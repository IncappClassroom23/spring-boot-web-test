package com.example.springbootwebtest.repository;

import com.example.springbootwebtest.model.Note;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("customNoteRepository")
public class CustomNoteRepositoryImpl{

}
