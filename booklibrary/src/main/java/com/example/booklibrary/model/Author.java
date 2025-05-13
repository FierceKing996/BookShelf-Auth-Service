package com.example.booklibrary.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    public String name;
    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<book> books;

    public Long getKey() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<book> getBooks() {
        return books;
    }

    public void setKey(Long key) {
        this.id = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<book> books) {
        this.books = books;
    }
}
