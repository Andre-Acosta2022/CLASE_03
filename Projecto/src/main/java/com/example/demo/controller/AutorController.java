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

import com.example.demo.entity.Autor;
import com.example.demo.service.AutorService;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@RestController
@RequestMapping("/api/autor")
public class AutorController {
	@Autowired
	private AutorService service;

	@GetMapping
	public ResponseEntity<List<Autor>> readAll() {
		try {
			List<Autor> autor = service.readALL();
			if (autor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(autor, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Autor> createLibros(@Valid @RequestBody Autor a){
		try {
			Autor autor =service.create(a);
			return new ResponseEntity<>(autor,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping
	public ResponseEntity<Autor> readLibros(@PathVariable("id") Long id){
		Optional<Autor>au=service.read(id);
		if (au!=null) {
			return new ResponseEntity<>(au.get(),HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
@DeleteMapping("/{id}")
public ResponseEntity<Autor> delAutor(@PathVariable("id") Long id,@Valid @RequestBody Autor a){
	try {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/{id}")
public ResponseEntity<?> editLibros(@PathVariable("id") Long id ,@Valid @RequestBody 	Autor a){
	Optional<Autor>opt=service.read(id);
	if (opt.isPresent()) {
		Autor au =opt.get();
		
		/*au.setNombre(a.getNombre());
		au.setApellidos(a.getApellidos());
		au.setPais(a.getPais());
		au.setEstado(a.getEstado());
		*/
		return new ResponseEntity<Autor>(service.update(au),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
}
