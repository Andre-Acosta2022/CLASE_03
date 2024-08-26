package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Libros;

public interface LibrosService {
	Libros create(Libros l);
	Libros update(Libros l);
	void delete(Long id);
	Optional<Libros>read(long id);
	List<Libros> readALL();
}
