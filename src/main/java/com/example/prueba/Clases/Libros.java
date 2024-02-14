package com.example.prueba.Clases;

import java.util.ArrayList;
import java.util.List;

public class Libros {
    List<Libro> listaLibros;
    public Libros(){
        listaLibros = new ArrayList<>();
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    public Libro[] recuperarLibros(){
        return listaLibros.toArray(Libro[]::new);
    }
}
