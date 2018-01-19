package com.pauloramos.spring.resources;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pauloramos.spring.domain.Categoria;
import com.pauloramos.spring.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {

	 public CategoriaService service;
	
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	
	
	}
}
