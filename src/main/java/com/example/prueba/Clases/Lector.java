package com.example.prueba.Clases;

public class Lector {
    private String nombreLector;
    private String apellidosLector;

    public Lector(String nombreLector, String apellidosLector) {
        this.nombreLector = nombreLector;
        this.apellidosLector = apellidosLector;
    }
    public Lector(){}

    public void setNombreLector(String nombreLector) {
        this.nombreLector = nombreLector;
    }

    public void setApellidosLector(String apellidosLector) {
        this.apellidosLector = apellidosLector;
    }

    public String getNombreLector() {
        return nombreLector;
    }

    public String getApellidosLector() {
        return apellidosLector;
    }
    public String exportToJSON(){
        String result="{";
        result+="\"nombreLector\":\""+getNombreLector()+"\",\n";
        result+="\"apellidosLector\":\""+getApellidosLector()+"\"";
        result+="}";
        return result;
    }
    public String exportToXML(){
        String result = "<lector>\n";
        result+="<nombreLector>"+getNombreLector()+"</nombreLector>\n";
        result+="<apellidosLector>"+getApellidosLector()+"</apellidosLector>\n";
        result+="</lector>";
        return result;
    }
    public String exportToYAML(){
        String result = "    nombreLector: "+getNombreLector()+"\n";
        result += "    apellidosLector: "+getApellidosLector();
        return result;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "nombreLector='" + nombreLector + '\'' +
                ", apellidosLector='" + apellidosLector + '\'' +
                '}';
    }
}
