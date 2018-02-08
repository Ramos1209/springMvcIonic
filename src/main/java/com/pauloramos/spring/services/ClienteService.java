package com.pauloramos.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloramos.spring.domain.Cliente;
import com.pauloramos.spring.repositores.ClienteRepositorio;
import com.pauloramos.spring.services.exception.ObjNotFoundException;


@Service
public class ClienteService {

	@Autowired
	public ClienteRepositorio repositorio;
	
	
	public Cliente buscar(Integer id) {
		Cliente obj = repositorio.findOne(id);
		if(obj ==null) {
			throw new ObjNotFoundException("Objeto nao encontrado : id " + id  );
		}
		return obj;
		
	}
	
}
