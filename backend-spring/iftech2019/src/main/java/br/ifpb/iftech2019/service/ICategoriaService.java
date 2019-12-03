package br.ifpb.iftech2019.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ifpb.iftech2019.model.Categoria;

@Service
public interface ICategoriaService {

    public Categoria create(Categoria categoria);

    public List<Categoria> getAll();

    public Optional<Categoria> getOne(Long idCategoria);

    public Categoria update(Long idCategoria, Categoria categoria);

    public Categoria delete(Long idCategoria);

}

