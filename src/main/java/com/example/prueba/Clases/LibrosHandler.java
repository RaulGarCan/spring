package com.example.prueba.Clases;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class LibrosHandler extends DefaultHandler {
    private static final String LIBRO = "libro";
    private static final String CODLIBRO = "codLibro";
    private static final String TITULO = "titulo";
    private static final String AUTORES = "autores";
    private static final String AUTOR = "autor";
    private static final String NOMBREAUTOR = "nombreAutor";
    private static final String EDITORIAL = "editorial";
    private static final String LECTOR = "lector";
    private static final String NOMBRELECTOR = "nombreLector";
    private static final String APELLIDOSLECTOR = "apellidosLector";

    private Libros libros;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }
    @Override
    public void startDocument() throws SAXException {
        libros = new Libros();
    }
    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case LIBRO:
                libros.listaLibros.add(new Libro());
                break;
            case CODLIBRO:
                elementValue = new StringBuilder();
                break;
            case TITULO:
                elementValue = new StringBuilder();
                break;
            case AUTORES:
                libros.listaLibros.get(libros.listaLibros.size()-1).setAutores(new ArrayList<>());
                break;
            case AUTOR:
                libros.listaLibros.get(libros.listaLibros.size()-1).addAutor(new Autor());
                break;
            case NOMBREAUTOR:
                elementValue = new StringBuilder();
                break;
            case EDITORIAL:
                elementValue = new StringBuilder();
                break;
            case LECTOR:
                libros.listaLibros.get(libros.listaLibros.size()-1).setLector(new Lector());
                break;
            case NOMBRELECTOR:
                elementValue = new StringBuilder();
                break;
            case APELLIDOSLECTOR:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case CODLIBRO:
                libros.listaLibros.get(libros.listaLibros.size()-1).setCodLibro(Integer.parseInt(this.elementValue.toString()));
                break;
            case TITULO:
                libros.listaLibros.get(libros.listaLibros.size()-1).setTitulo(this.elementValue.toString());
                break;
            case NOMBREAUTOR:
                libros.listaLibros.get(libros.listaLibros.size()-1).getAutores().get(libros.listaLibros.get(libros.listaLibros.size()-1).getAutores().size()-1).setNombreAutor(this.elementValue.toString());
                break;
            case EDITORIAL:
                libros.listaLibros.get(libros.listaLibros.size()-1).setEditorial(this.elementValue.toString());
                break;
            case NOMBRELECTOR:
                libros.listaLibros.get(libros.listaLibros.size()-1).getLector().setNombreLector(this.elementValue.toString());
                break;
            case APELLIDOSLECTOR:
                libros.listaLibros.get(libros.listaLibros.size()-1).getLector().setApellidosLector(this.elementValue.toString());
                break;
        }
    }

    public Libros getLibros() {
        return libros;
    }
}
