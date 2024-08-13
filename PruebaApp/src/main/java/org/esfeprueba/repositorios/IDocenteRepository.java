package org.esfeprueba.repositorios;

import org.esfeprueba.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {
}
