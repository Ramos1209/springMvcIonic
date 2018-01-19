package com.pauloramos.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloramos.spring.domain.Categoria;
import com.pauloramos.spring.repositores.CategoriaRepositorio;


@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepositorio repositorio;
	
	
	public Categoria buscar(Integer id) {
		Categoria obj = repositorio.findOne(id);
		return obj;
		
	}
	
}
