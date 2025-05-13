package com.example.booklibrary.service;

import com.example.booklibrary.dto.bookdto;
import com.example.booklibrary.model.Author;
import com.example.booklibrary.model.book;
import com.example.booklibrary.repository.authorrepository;
import com.example.booklibrary.repository.bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class bookservice {
    @Autowired
    private bookrepository bookRepository;

    @Autowired
    private authorrepository authorRepository;

    public bookdto create(bookdto bookdto1) {
        book book1 = new book();
        book1.setTitle(bookdto1.getTitle());
        book1.setPublisher(bookdto1.getPublisher());
        Author author = authorRepository.findById(bookdto1.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found with id: " + bookdto1.getAuthorId()));
        System.out.println(">> author fetched: " + author.getKey());
        book1.setAuthor(author);
        book saved = bookRepository.save(book1);

        bookdto out = new bookdto();
        out.setId(saved.getId());
        out.setTitle(saved.getTitle());
        out.setPublisher(saved.getPublisher());
        out.setAuthorId(saved.getAuthor().getKey());
        return out;
    }
    public List<book> list() { return bookRepository.findAll(); }
    public book get(Long id) { return bookRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { bookRepository.deleteById(id); }
}
