package com.example.prueba.Constroller;

import com.example.prueba.Clases.Libro;
import com.example.prueba.Clases.Manejador;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/api")
public class Controller {
    @PostMapping("/xmlToJson")
    public String xmlToJson(@RequestBody String libros) {
        Libro[] xml = Manejador.parsearXML(libros);
        String json = Manejador.exportarAJSON(xml);
        return json;
    }
    @PostMapping("/xmlToYaml")
    public String xmlToYaml(@RequestBody String libros) {
        Libro[] xml = Manejador.parsearXML(libros);
        String yaml = Manejador.exportarAYAML(xml);
        return yaml;
    }
    @PostMapping("/jsonToXml")
    public String jsonToXml(@RequestBody String libros) {
        Gson gson = new Gson();
        Libro[] json = gson.fromJson(libros,Libro[].class);
        String xml = Manejador.exportarAXML(json);
        return xml;
    }
    @PostMapping("/jsonToYaml")
    public String jsonToYaml(@RequestBody String libros) {
        Gson gson = new Gson();
        Libro[] json = gson.fromJson(libros,Libro[].class);
        String yaml = Manejador.exportarAYAML(json);
        return yaml;
    }
    @PostMapping("/yamlToXml")
    public String yamlToXml(@RequestBody String libros) {
        Libro[] yaml = Manejador.importarYAML(libros);
        String xml = Manejador.exportarAXML(yaml);
        return xml;
    }
    @PostMapping("/yamlToJson")
    public String yamlToJson(@RequestBody String libros) {
        Libro[] yaml = Manejador.importarYAML(libros);
        String json = Manejador.exportarAJSON(yaml);
        return json;
    }
}
