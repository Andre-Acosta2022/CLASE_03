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


import com.example.demo.entity.Editorial;

import com.example.demo.service.EditorialService;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@RestController
@RequestMapping("/api/editorial")
public class EditorialController {
	@Autowired
	private EditorialService service;

	@GetMapping
	public ResponseEntity<List<Editorial>> readAll() {
		try {
			List<Editorial> editorial = service.readALL();
			if (editorial.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(editorial, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Editorial> createEditorial(@Valid @RequestBody Editorial E){
		try {
			Editorial edit =service.create(E);
			return new ResponseEntity<>(edit,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping
	public ResponseEntity<Editorial> readEditorial(@PathVariable("id") Long id){
		Optional<Editorial>edit=service.read(id);
		if (edit!=null) {
			return new ResponseEntity<>(edit.get(),HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
@DeleteMapping("/{id}")
public ResponseEntity<Editorial> delEditorial(@PathVariable("id") Long id,@Valid @RequestBody Editorial E){
	try {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/{id}")
public ResponseEntity<?> editEditorial(@PathVariable("id") Long id ,@Valid @RequestBody Editorial E){
	Optional<Editorial>opt=service.read(id);
	if (opt.isPresent()) {
		Editorial edit =opt.get();
		
		/*au.setNombre(a.getNombre());
		au.setApellidos(a.getApellidos());
		au.setPais(a.getPais());
		au.setEstado(a.getEstado());
		*/
		return new ResponseEntity<Editorial>(service.update(edit),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
}
