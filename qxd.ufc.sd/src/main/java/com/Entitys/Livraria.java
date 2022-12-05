package com.Entitys;

import java.util.ArrayList;

public class Livraria {

    private ArrayList<Livro> colecao;

    public Livraria() {
        this.colecao = new ArrayList<Livro>();
    }

    public void addLivro (Livro l) {
        colecao.add(l);
        System.out.println("[200]: Livro adicionado com sucesso");
    }

    public void removeLivro(Livro l) {
        this.colecao.remove(l);
        System.out.println("[200]: Livro removido com sucesso");
    }

    public Livro findLivroByTitulo(String titulo) {
        for (Livro it : this.colecao) {
            if(it.getTitulo().equals(titulo))
                return it;
        }

        return null;
    }
    public Livro findLivroByIsbn(String isbn) {
        for (Livro it: this.colecao) {
            if(it.getIsbn().equals( isbn))
                return it;
        }
        return null;
    }

    public ArrayList<Livro> listLivros() {
        return this.colecao;
    }
}
