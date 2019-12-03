package br.ifpb.iftech2019.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpb.iftech2019.exception.ResourceNotFoundException;
import br.ifpb.iftech2019.model.BoaPratica;
import br.ifpb.iftech2019.service.impl.BoaPraticaImpl;

@RestController
@RequestMapping(value = "/api/boapratica")
public class BoaPraticaController {

	@Autowired
	private BoaPraticaImpl boaPraticaImpl;
	
	@PostMapping(value = "/{idCategoria}")
	public ResponseEntity<BoaPratica> create(@Valid @RequestBody BoaPratica boaPratica , @PathVariable Long idCategoria) {
		
		BoaPratica criada = boaPraticaImpl.create(boaPratica, idCategoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(criada); 
	}
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<List<BoaPratica>> getAll() {
		
		return ResponseEntity.ok(boaPraticaImpl.getAll());
		
	}
	
	@CrossOrigin
	@GetMapping(value = "/{idBoaPratica}")
	public ResponseEntity<BoaPratica> getOne(@PathVariable Long idBoaPratica) {
		
		Optional<BoaPratica> boaPratica = boaPraticaImpl.getOne(idBoaPratica);
		
		if (boaPratica.isPresent())
			return ResponseEntity.ok(boaPratica.get());
		
		throw new ResourceNotFoundException(idBoaPratica);
	}
	
	@CrossOrigin
	@PutMapping(value = "/{idBoaPratica}")
	public ResponseEntity<BoaPratica> update(@PathVariable Long idBoaPratica, @Valid @RequestBody BoaPratica boaPratica) {
		
		BoaPratica atualizado = boaPraticaImpl.update(idBoaPratica, boaPratica);
		
		return ResponseEntity.ok(atualizado);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{idBoaPratica}")
	public ResponseEntity<BoaPratica> delete(@PathVariable Long idBoaPratica) {
		
		BoaPratica deletado = boaPraticaImpl.delete(idBoaPratica);
		
		return ResponseEntity.ok(deletado);
	}
	
}
