package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Libros;

@Repository
public interface CategoriaRepository extends JpaRepository<Libros, Long>{


}

