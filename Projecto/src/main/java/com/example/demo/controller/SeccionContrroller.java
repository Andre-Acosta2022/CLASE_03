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

import com.example.demo.entity.Seccion;
import com.example.demo.service.SeccionService;
import com.example.demo.service.SeccionService;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@RestController
@RequestMapping("/api/seccion")
public class SeccionContrroller {
	@Autowired
	private SeccionService service;

	@GetMapping
	public ResponseEntity<List<Seccion>> readAll() {
		try {
			List<Seccion> seccion = service.readALL();
			if (seccion.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(seccion, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Seccion> createSeccion(@Valid @RequestBody Seccion s){
		try {
			Seccion seccion =service.create(s);
			return new ResponseEntity<>(seccion,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping
	public ResponseEntity<Seccion> readSeccion(@PathVariable("id") Long id){
		Optional<Seccion>sec=service.read(id);
		if (sec!=null) {
			return new ResponseEntity<>(sec.get(),HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
@DeleteMapping("/{id}")
public ResponseEntity<Seccion> delSeccion(@PathVariable("id") Long id,@Valid @RequestBody Seccion s){
	try {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/{id}")
public ResponseEntity<?> editSeccion(@PathVariable("id") Long id ,@Valid @RequestBody Seccion s){
	Optional<Seccion>opt=service.read(id);
	if (opt.isPresent()) {
		Seccion sec =opt.get();
		
		/*au.setNombre(a.getNombre());
		au.setApellidos(a.getApellidos());
		au.setPais(a.getPais());
		au.setEstado(a.getEstado());
		*/
		return new ResponseEntity<Seccion>(service.update(sec),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
}
