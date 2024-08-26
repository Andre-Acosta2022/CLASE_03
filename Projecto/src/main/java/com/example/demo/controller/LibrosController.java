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

import com.example.demo.entity.Libros;
import com.example.demo.service.LibrosService;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@RestController
@RequestMapping("/api/libros")
public class LibrosController {
	@Autowired
	private LibrosService service;

	@GetMapping
	public ResponseEntity<List<Libros>> readAll() {
		try {
			List<Libros> libro = service.readALL();
			if (libro.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(libro, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Libros> createLibros(@Valid @RequestBody Libros l){
		try {
			Libros libro =service.create(l);
			return new ResponseEntity<>(libro,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping
	public ResponseEntity<Libros> readLibros(@PathVariable("id") Long id){
		Optional<Libros>lib=service.read(id);
		if (lib!=null) {
			return new ResponseEntity<>(lib.get(),HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
@DeleteMapping("/{id}")
public ResponseEntity<Libros> delLibros(@PathVariable("id") Long id){
	try {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/{id}")
public ResponseEntity<?> editLibros(@PathVariable("id") Long id ,@Valid @RequestBody Libros l){
	Optional<Libros>opt=service.read(id);
	if (opt.isPresent()) {
		Libros lib =opt.get();
	/*	lib.setTitulo(l.getTitulo());
		lib.setPaginas(l.getPaginas());
		lib.setEdicion(l.getEdicion());
		lib.setSección(l.getSeccion());
		lib.setEstado(l.getEstado());
		*/
		return new ResponseEntity<Libros>(service.update(lib),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
}
