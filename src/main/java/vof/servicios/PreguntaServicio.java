package vof.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vof.modelo.PreguntaEntidad;
import vof.repositorio.PreguntaRepositorio;

import java.util.List;

@Service
public class PreguntaServicio implements IPreguntaServicio {

    @Autowired
    private PreguntaRepositorio preguntaRepositorio;

    @Override
    public List<PreguntaEntidad> listarPreguntas() {
        return preguntaRepositorio.findAll();
    }

    @Override
    public PreguntaEntidad buscarPreguntaPorID(Long id) {
        return preguntaRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<PreguntaEntidad> filtrarPreguntas(String categoria) {
        return preguntaRepositorio.filterQuestions(categoria);
    }

    @Override
    public PreguntaEntidad crearPregunta(PreguntaEntidad pregunta) {
        return preguntaRepositorio.save(pregunta);
    }
}
