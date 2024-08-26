package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@RestController
@RequestMapping("/api/Categoria")
public class CategoriaController {
	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> readAll() {
		try {
			List<Categoria> categorias = service.readALL();
			if (categorias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorias, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria c){
		try {
			Categoria categorias =service.create(c);
			return new ResponseEntity<>(categorias,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping
	public ResponseEntity<Categoria> readCategoria(@PathVariable("id") Long id){
		Optional<Categoria>cat=service.read(id);
		if (cat!=null) {
			return new ResponseEntity<>(cat.get(),HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
@DeleteMapping("/{id}")
public ResponseEntity<Categoria> delCategoria(@PathVariable("id") Long id){
	try {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/{id}")
public ResponseEntity<?> editCategoria(@PathVariable("id") Long id ,@Valid @RequestBody Categoria c){
	Optional<Categoria>cat=service.read(id);
	if (cat.isEmpty()) {
		return new ResponseEntity<Categoria>(service.update(c),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
}
