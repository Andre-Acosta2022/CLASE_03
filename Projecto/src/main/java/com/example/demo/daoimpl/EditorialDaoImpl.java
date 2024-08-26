package com.example.demo.daoimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EditorialDao;
import com.example.demo.entity.Editorial;


@Service
public class EditorialDaoImpl implements EditorialDao{
	@Autowired
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
