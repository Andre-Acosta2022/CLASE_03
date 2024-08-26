package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Autor;

public interface AutorDao {
	Autor create(Autor a);
	Autor update(Autor a);
	void delete(Long id);
	Optional<Autor >read(long id);
	List<Autor> readALL();
}
