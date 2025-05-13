package com.example.booklibrary.repository;

import com.example.booklibrary.model.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookrepository extends JpaRepository<book, Long> {
}
