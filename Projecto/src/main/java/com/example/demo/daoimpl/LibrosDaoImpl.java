package com.example.demo.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.LibrosDao;
import com.example.demo.entity.Libros;
import com.example.demo.repository.LibrosRepository;

@Component
public class LibrosDaoImpl implements LibrosDao {
@Autowired
LibrosRepository librosRepository;
	@Override
	public Libros create(Libros l) {
		// TODO Auto-generated method stub
		return librosRepository.save(l);
	}

	@Override
	public Libros update(Libros l) {
		// TODO Auto-generated method stub
		return librosRepository.save(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		librosRepository.deleteById(id);
	}

	@Override
	public Optional<Libros> read(long id) {
		// TODO Auto-generated method stub
		return librosRepository.findById(id);
	}

	@Override
	public List<Libros> readALL() {
		// TODO Auto-generated method stub
		return librosRepository.findAll();
	}

}
