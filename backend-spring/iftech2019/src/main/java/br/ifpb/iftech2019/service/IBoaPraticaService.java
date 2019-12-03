package br.ifpb.iftech2019.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ifpb.iftech2019.model.BoaPratica;

@Service
public interface IBoaPraticaService {

	public BoaPratica create(BoaPratica boaPratica, Long categoriaId);
	
	public List<BoaPratica> getAll();
	
	public Optional<BoaPratica> getOne(Long idBoaPratica);
	
	public BoaPratica update(Long idBoaPratica, BoaPratica boaPratica);
	
	public BoaPratica delete(Long idBoaPratica);
	
}
