package vof.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vof.modelo.PreguntaEntidad;
import vof.servicios.IPreguntaServicio;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(value = "http://localhost:5173")
public class PreguntaControlador {

    @Autowired
    private IPreguntaServicio preguntaServicio;

    @GetMapping("/preguntas")
    public List<PreguntaEntidad> obtenerPreguntas(){
        return preguntaServicio.listarPreguntas();
    }

    @GetMapping("/preguntasFiltradas")
    public List<PreguntaEntidad> obtenerPreguntasFiltradas(@RequestParam String categoria){
        return preguntaServicio.filtrarPreguntas(categoria);
    }

    @PostMapping("/nuevaPregunta")
    public PreguntaEntidad agregarPregunta(@RequestBody PreguntaEntidad pregunta){
        return preguntaServicio.crearPregunta(pregunta);
    }
}
