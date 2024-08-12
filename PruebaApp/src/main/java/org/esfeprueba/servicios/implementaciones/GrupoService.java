package org.esfeprueba.servicios.implementaciones;

import org.esfeprueba.modelos.Grupo;
import org.esfeprueba.repositorios.IGrupoRepository;
import org.esfeprueba.servicios.interfaces.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoService implements IGrupoService {
    @Autowired
    private IGrupoRepository grupoRepository;

    @Override
    public Page<Grupo> buscarTodosPaginados(Pageable pageable) {
        return grupoRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public List<Grupo> obtenerTodos() {
        return grupoRepository.findAll();
    }

    @Override
    public Optional<Grupo> obtenerPorId(Integer pId) {
        return grupoRepository.findById(pId);
    }

    @Override
    public Grupo guardarOEditar(Grupo pGrupo) {
        return grupoRepository.save(pGrupo);
    }

    @Override
    public void eliminarPorId(Integer pId) {
        grupoRepository.deleteById(pId);
    }
}
