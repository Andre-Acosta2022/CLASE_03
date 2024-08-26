package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Seccion;

public interface SeccionDao {
	Seccion create(Seccion s);
	Seccion update(Seccion s);
	void delete(Long id);
	Optional<Seccion>read(long id);
	List<Seccion> readALL();
}
