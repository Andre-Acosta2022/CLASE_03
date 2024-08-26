package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Autor;
import com.example.demo.entity.Libros;

public interface AutorService {

	Autor create(Autor a);
	Autor update(Autor a);
	void delete(Long id);
	Optional<Autor >read(long id);
	List<Autor> readALL();
}
