package com.example.demo.daoimpl;
import java.util.List;
import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EditorialDao;
import com.example.demo.dao.SeccionDao;
import com.example.demo.entity.Editorial;
import com.example.demo.entity.Seccion;
import com.example.demo.service.EditorialService;

@Service
public class SeccionDaoImpl implements SeccionDao {

	@Override
	public Seccion create(Seccion s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seccion update(Seccion s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Seccion> read(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Seccion> readALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
