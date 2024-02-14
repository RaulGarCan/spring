package com.example.prueba.Clases;

public class Autor {
    private String nombreAutor;

    public Autor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    public Autor(Autor origen){
        this.nombreAutor = origen.nombreAutor;
    }
    public Autor(){}

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    public String exportToJSON(){
        String result="{";
        result+="\"nombreAutor\":\""+getNombreAutor()+"\"";
        result+="}";
        return result;
    }
    public String exportToXML(){
        String result = "<autor>\n";
        result+="<nombreAutor>"+getNombreAutor()+"</nombreAutor>\n";
        result+="</autor>";
        return result;
    }
    public String exportToYAML(){
        String result = "- "+getNombreAutor();
        return result;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombreAutor='" + nombreAutor + '\'' +
                '}';
    }
}
