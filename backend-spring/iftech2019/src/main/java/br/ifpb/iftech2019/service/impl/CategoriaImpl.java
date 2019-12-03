package br.ifpb.iftech2019.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.iftech2019.exception.ResourceNotFoundException;
import br.ifpb.iftech2019.model.Categoria;
import br.ifpb.iftech2019.repository.ICategoriaRepository;
import br.ifpb.iftech2019.service.ICategoriaService;

@Service
public class CategoriaImpl implements ICategoriaService {
	
	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	public Categoria create(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}

	public Optional<Categoria> getOne(Long categoriaId) {
		return categoriaRepository.findById(categoriaId);
	}

	public Categoria update(Long idCategoria, Categoria categoria) {
		Optional<Categoria> categoriaOpcional = categoriaRepository.findById(idCategoria);

		if (categoriaOpcional.isPresent()) {
			categoria.setId(idCategoria);
			return categoriaRepository.save(categoria);
		}

		throw new ResourceNotFoundException(idCategoria);
	}

	public Categoria delete(Long idCategoria) {
		Optional<Categoria> categoriaOpcional = categoriaRepository.findById(idCategoria);

		if (!categoriaOpcional.isPresent())
			throw new ResourceNotFoundException(idCategoria);

		categoriaRepository.deleteById(idCategoria);
		return categoriaOpcional.get();
	}
}