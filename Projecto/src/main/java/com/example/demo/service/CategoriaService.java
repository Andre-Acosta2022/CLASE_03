package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Libros;

public interface CategoriaService {
	Categoria create(Categoria c);
	Categoria update(Categoria c);
	void delete(Long id);
	Optional<Categoria>read(long id);
	List<Categoria> readALL();

}
