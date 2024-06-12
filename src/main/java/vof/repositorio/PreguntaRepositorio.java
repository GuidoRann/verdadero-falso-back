package vof.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vof.modelo.PreguntaEntidad;

import java.util.List;

@Repository
public interface PreguntaRepositorio extends JpaRepository<PreguntaEntidad, Long> {

    @Query("SELECT p FROM PreguntaEntidad p WHERE p.categoria = :categoria")
    List<PreguntaEntidad> filterQuestions(String categoria);
}
