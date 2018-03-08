package com.pauloramos.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloramos.spring.domain.Pedido;
import com.pauloramos.spring.repositores.PedidoRepositorio;
import com.pauloramos.spring.services.exception.ObjNotFoundException;


@Service
public class PedidoService {

	@Autowired
	public PedidoRepositorio repositorio;
	
	
	public Pedido buscar(Integer id) {
		Pedido obj = repositorio.findOne(id);
		if(obj ==null) {
			throw new ObjNotFoundException("Objeto nao encontrado : id " + id  );
		}
		return obj;
		
	}
	
}
