package com.example.demo.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoriaDao;
import com.example.demo.dao.LibrosDao;
import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	private CategoriaDao dao;
	@Override
	public Categoria create(Categoria c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria update(Categoria c) {
		// TODO Auto-generated method stub
		return null;
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
