package com.pauloramos.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pauloramos.spring.domain.Categoria;
import com.pauloramos.spring.domain.Produto;
import com.pauloramos.spring.repositores.CategoriaRepositorio;
import com.pauloramos.spring.repositores.ProdutoRepositorio;

@SpringBootApplication
public class SpringMvcIonicApplication implements CommandLineRunner {

	@Autowired
	public CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	public ProdutoRepositorio produtoRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcIonicApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",20.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepositorio.save(Arrays.asList(cat1,cat2));
		produtoRepositorio.save(Arrays.asList(p1,p2,p3));
		
	}
}
