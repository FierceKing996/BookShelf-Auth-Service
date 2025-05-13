package com.example.booklibrary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class bookdto {
    private Long id;
    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title cannot exceed 200 characters")
    private String title;
    @NotBlank(message = "Publisher is required")
    private String publisher;
    @NotNull(message = "AuthorId is required")
    private Long authorId;
    public bookdto(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public bookdto(Long id, String title, String publisher, Long authorId) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.authorId = authorId;
    }
}
