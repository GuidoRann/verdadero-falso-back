package vof.servicios;

import vof.modelo.PreguntaEntidad;

import java.util.List;

public interface IPreguntaServicio {

    public List<PreguntaEntidad> listarPreguntas();

    public PreguntaEntidad buscarPreguntaPorID(Long id);

    public List<PreguntaEntidad> filtrarPreguntas(String categoria);

    public PreguntaEntidad crearPregunta(PreguntaEntidad pregunta);
}
