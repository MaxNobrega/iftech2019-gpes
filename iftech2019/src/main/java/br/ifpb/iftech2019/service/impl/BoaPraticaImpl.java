package br.ifpb.iftech2019.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.iftech2019.exception.ResourceNotFoundException;
import br.ifpb.iftech2019.model.BoaPratica;
import br.ifpb.iftech2019.model.Categoria;
import br.ifpb.iftech2019.repository.IBoaPraticaRepository;
import br.ifpb.iftech2019.repository.ICategoriaRepository;
import br.ifpb.iftech2019.service.IBoaPraticaService;

@Service
public class BoaPraticaImpl implements IBoaPraticaService {

	@Autowired
	private IBoaPraticaRepository boaPraticaRepository;
	@Autowired
	private ICategoriaRepository categoriaRepository;
	 
	@Override
	public BoaPratica create(BoaPratica boaPratica, Long categoriaId) {
		Optional<Categoria> categoriaTmp = categoriaRepository.findById(categoriaId);
		
		boaPratica.getCategorias().add(categoriaTmp.get());
		categoriaTmp.get().getBoasPraticas().add(boaPratica); 
		boaPraticaRepository.save(boaPratica);
		categoriaRepository.save(categoriaTmp.get());
		return boaPratica;
	}

	@Override
	public List<BoaPratica> getAll() {
		return boaPraticaRepository.findAll();
	}

	@Override
	public Optional<BoaPratica> getOne(Long idBoaPratica) {
		return boaPraticaRepository.findById(idBoaPratica);
	}

	@Override
	public BoaPratica update(Long idBoaPratica, BoaPratica boaPratica) {
		
		Optional<BoaPratica> praticaOpcional = boaPraticaRepository.findById(idBoaPratica);

		if (praticaOpcional.isPresent()) {
			boaPratica.setId(idBoaPratica);
			return boaPraticaRepository.save(boaPratica);
		}

		throw new ResourceNotFoundException(idBoaPratica);
	}

	@Override
	public BoaPratica delete(Long idBoaPratica) {
		Optional<BoaPratica> praticaOpcional = boaPraticaRepository.findById(idBoaPratica);


		if (!praticaOpcional.isPresent())
			throw new ResourceNotFoundException(idBoaPratica);
		
		for (Categoria categ : praticaOpcional.get().getCategorias()) {
			categ.getBoasPraticas().remove(praticaOpcional.get());
			categoriaRepository.save(categ);
		}
		praticaOpcional.get().getCategorias().clear();
		boaPraticaRepository.deleteById(idBoaPratica);
		return praticaOpcional.get();
	}

}
