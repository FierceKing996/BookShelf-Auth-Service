package com.example.booklibrary.repository;

import com.example.booklibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface authorrepository extends JpaRepository<Author,Long> {
}
