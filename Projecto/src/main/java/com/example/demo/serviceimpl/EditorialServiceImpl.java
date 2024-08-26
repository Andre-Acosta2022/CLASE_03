package com.example.demo.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EditorialDao;
import com.example.demo.entity.Editorial;
import com.example.demo.service.EditorialService;

@Service
public class EditorialServiceImpl implements EditorialDao {

	@Override
	public Editorial create(Editorial e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editorial update(Editorial e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Editorial> read(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Editorial> readALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
