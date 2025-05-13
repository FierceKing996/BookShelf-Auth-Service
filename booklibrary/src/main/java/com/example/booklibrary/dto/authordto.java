package com.example.booklibrary.dto;

public class authordto {
    private Long id;
    private String name;
    public authordto(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public authordto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
