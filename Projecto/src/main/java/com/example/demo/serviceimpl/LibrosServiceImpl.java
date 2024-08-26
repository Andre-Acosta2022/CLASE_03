package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LibrosDao;
import com.example.demo.entity.Libros;
import com.example.demo.service.LibrosService;

@Service
public class LibrosServiceImpl implements LibrosService{
@Autowired
private LibrosDao dao;
	@Override
	public Libros create(Libros l) {
		// TODO Auto-generated method stub
		return dao.create(l);
	}

	@Override
	public Libros update(Libros l) {
		// TODO Auto-generated method stub
		return dao.update(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Libros> read(long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Libros> readALL() {
		// TODO Auto-generated method stub
		return dao.readALL();
	}

	
}
