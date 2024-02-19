package com.example.prueba.Clases;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Manejador {
    public static Libro[] parsearXML(String xml){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            LibrosHandler handler = new LibrosHandler();
            InputSource inputSource = new InputSource(new StringReader(xml));
            parser.parse(inputSource,handler);
            Libros listaLibros = handler.getLibros();
            return listaLibros.recuperarLibros();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String exportarAJSON(Libro[] libros){
        String contenido = "[\n";
        for(int i=0; i<libros.length; i++){
            contenido += libros[i].exportToJson();
            if(i!=libros.length-1){
                contenido += ",\n";
            }else {
                contenido += "\n";
            }
        }
        contenido+="]";
        return contenido;
    }
    public static String exportarAXML(Libro[] libros){
        String contenido = "<libros>\n";
        for(int i=0; i<libros.length; i++){
            contenido += libros[i].exportToXML();
        }
        contenido+="\n</libros>";
        return contenido;
    }
    public static String exportarAYAML(Libro[] libros){
        String contenido = "";
        for(Libro l : libros){
            contenido += l.exportToYAML();
        }
        return contenido;
    }
    public static Libro[] importarYAML(String contenido){
        contenido = contenido.replaceAll("-","");
        contenido = contenido.replaceAll(":","");
        contenido = contenido.trim().replaceAll(" +"," ");
        String[] arrayContenido = contenido.split(" ");
        System.out.println(contenido);
        System.out.println(Arrays.toString(arrayContenido));
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Autor> autoresLibro;
        for(int i = 0; i<arrayContenido.length; i++){
            arrayContenido[i] = arrayContenido[i].replaceAll("\n","");
            arrayContenido[i] = arrayContenido[i].replaceAll("\r","");
        }
        int posicionLibro = -1;
        for(int i = 0; i<arrayContenido.length; i++){
            if(arrayContenido[i].equalsIgnoreCase("codLibro")) {
                libros.add(new Libro());
                posicionLibro++;
                try {
                    libros.get(posicionLibro).setCodLibro(Integer.parseInt(arrayContenido[i+1]));
                }catch (NumberFormatException e){
                    arrayContenido[i+1] = arrayContenido[i+1].replaceAll("\n","");
                    arrayContenido[i+1] = arrayContenido[i+1].replaceAll("\r","");
                    libros.get(posicionLibro).setCodLibro(Integer.parseInt(arrayContenido[i+1]));
                }
            } else if(arrayContenido[i].equalsIgnoreCase("titulo")){
                libros.get(posicionLibro).setTitulo(arrayContenido[i+1]);
            } else if (arrayContenido[i].equalsIgnoreCase("autores")) {
                autoresLibro = new ArrayList<>();
                int posicionAutor = i+1;
                while (!arrayContenido[posicionAutor].equalsIgnoreCase("editorial")){
                    autoresLibro.add(new Autor(arrayContenido[posicionAutor]));
                    posicionAutor++;
                }
                libros.get(posicionLibro).setAutores(autoresLibro);
            } else if (arrayContenido[i].equalsIgnoreCase("editorial")) {
                libros.get(posicionLibro).setEditorial(arrayContenido[i+1]);
            } else if (arrayContenido[i].equalsIgnoreCase("lector")) {
                libros.get(posicionLibro).setLector(new Lector(arrayContenido[i+2],arrayContenido[i+4]));
            }
        }
        System.out.println("Output: "+Arrays.toString(arrayContenido));
        return libros.toArray(Libro[]::new);
    }
}
