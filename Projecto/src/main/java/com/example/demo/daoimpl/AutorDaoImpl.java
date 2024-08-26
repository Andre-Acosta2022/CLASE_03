package com.example.demo.daoimpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AutorDao;
import com.example.demo.entity.Autor;
import com.example.demo.service.AutorService;

@Service
public class AutorDaoImpl implements AutorService{

	@Override
	public Autor create(Autor a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor update(Autor a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Autor> read(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Autor> readALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
