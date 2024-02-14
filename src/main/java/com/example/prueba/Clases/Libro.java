package com.example.prueba.Clases;

import java.util.ArrayList;
import java.util.Arrays;


public class Libro {
    private int codLibro;
    private String titulo;
    private ArrayList<Autor> autores;
    private String editorial;
    private Lector lector;

    public Libro(int codLibro, String titulo, ArrayList<Autor> autores, String editorial, Lector lector) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.lector = lector;
    }
    public Libro(){}

    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(ArrayList<Autor> autores) {
        ArrayList<Autor> copiaAutores = new ArrayList<>();
        for(Autor a : autores){
            copiaAutores.add(new Autor(a));
        }
        this.autores = copiaAutores;
    }
    public void addAutor(Autor autor){
        this.autores.add(autor);
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }


    public int getCodLibro() {
        return codLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public Lector getLector() {
        return lector;
    }

    public String exportToJson(){
        String result = "{\n";
        result+="\"codLibro\":"+getCodLibro()+",\n";
        result+="\"titulo\":\""+getTitulo()+"\",\n";
        result+="\"autores\":[\n";
        for(int i = 0; i< autores.size(); i++){
            result+=autores.get(i).exportToJSON();
            if(i!= autores.size()-1){
                result+=",\n";
            } else {
                result+="\n";
            }
        }
        result+="],\n";
        result+="\"editorial\":\""+getEditorial()+"\",\n";
        result+="\"lector\":"+lector.exportToJSON()+"\n";
        result+="}";
        return result;
    }
    public String exportToXML(){
        String result="<libro>\n";
        result+="<codLibro>"+getCodLibro()+"</codLibro>\n";
        result+="<titulo>"+getTitulo()+"</titulo>\n";
        result+="<autores>\n";
        for(Autor a : autores){
            result+=a.exportToXML()+"\n";
        }
        result+="</autores>\n";
        result+="<editorial>"+getEditorial()+"</editorial>\n";
        result+=lector.exportToXML()+"\n";
        result+="</libro>";
        return result;
    }
    public String exportToYAML(){
        String result = "- codLibro: "+getCodLibro()+"\n";
        result += "  titulo: "+getTitulo()+"\n";
        result += "  autores:"+"\n";
        for(Autor a : autores){
            result+="    "+a.exportToYAML()+"\n";
        }
        result += "  editorial: "+getEditorial()+"\n";
        result += "  lector:"+"\n";
        result += getLector().exportToYAML()+"\n";
        return result;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codLibro=" + codLibro +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores.toString() +
                ", editorial='" + editorial + '\'' +
                ", lector=" + lector +
                '}';
    }
}
