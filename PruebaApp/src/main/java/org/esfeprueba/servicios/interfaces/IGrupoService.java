package org.esfeprueba.servicios.interfaces;

import org.esfeprueba.modelos.Grupo;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface IGrupoService {
    Page<Grupo> buscarTodosPaginados(Pageable pPageable);

    List<Grupo> obtenerTodos();

    Optional<Grupo> obtenerPorId(Integer pId);

    Grupo guardarOEditar(Grupo pGrupo);

    void eliminarPorId(Integer pId);
}
