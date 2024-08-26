package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Editorial;

public interface EditorialService {
	Editorial create(Editorial E);
    Editorial update(Editorial E);
	void delete(Long id);
	Optional<Editorial>read(long id);
	List<Editorial> readALL();

}
