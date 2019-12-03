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
import br.ifpb.iftech2019.model.Categoria;
import br.ifpb.iftech2019.service.impl.CategoriaImpl;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaImpl categoriaService;
	
	@CrossOrigin
	@PostMapping()
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
		
		Categoria criado = categoriaService.create(categoria);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(criado); 
	}
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<List<Categoria>> getAll() {
		
		return ResponseEntity.ok(categoriaService.getAll());
		
	}
	
	@CrossOrigin
	@GetMapping(value = "/{idCategoria}")
	public ResponseEntity<Categoria> getOne(@PathVariable Long idCategoria) {
		
		Optional<Categoria> categoriaOpicional = categoriaService.getOne(idCategoria);
		
		if (categoriaOpicional.isPresent())
			return ResponseEntity.ok(categoriaOpicional.get());
		
		throw new ResourceNotFoundException(idCategoria);
	}
	
	@CrossOrigin
	@PutMapping(value = "/{idCategoria}")
	public ResponseEntity<Categoria> update(@PathVariable Long idCategoria, @Valid @RequestBody Categoria categoria) {
		
		Categoria atualizado = categoriaService.update(idCategoria, categoria);
		
		return ResponseEntity.ok(atualizado);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{idCategoria}")
	public ResponseEntity<Categoria> delete(@PathVariable Long idCategoria) {
		
		Categoria deletado = categoriaService.delete(idCategoria);
		
		return ResponseEntity.ok(deletado);
	}
}