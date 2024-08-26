package com.example.demo.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CategoriaDao;
import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;
@Component
public class CategoriaDaoImpl implements CategoriaDao{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria create(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(c);
	}

	@Override
	public Categoria update(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Categoria> read(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Categoria> readALL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
