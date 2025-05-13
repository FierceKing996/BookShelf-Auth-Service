package com.example.booklibrary.service;

import com.example.booklibrary.model.Author;
import com.example.booklibrary.repository.authorrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class authorservice {
    private final authorrepository repo;
    public authorservice(authorrepository repo){ this.repo = repo;}
    public Author create(Author a){return repo.save(a);}
    public List<Author> list(){return repo.findAll();}
    public Author get(Long id){return repo.findById(id).orElseThrow();}
    public void delete(Long id) { repo.deleteById(id); }

}
