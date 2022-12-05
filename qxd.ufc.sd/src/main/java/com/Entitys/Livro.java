package com.Entitys;

public class Livro {

    private String titulo;
    private String nomeAutor;
    private String isbn;

    public Livro(){}

    public Livro(String titulo, String autor, String isbn) {
        this.isbn = isbn;
        this.nomeAutor = autor;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        String data = "{titulo: " + this.getTitulo() + ", autor: "
                + this.getNomeAutor() + ", isbn: "
                + this.getIsbn().toString() + "}";

        return data;
    }



}
