package com.pauloramos.spring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloramos.spring.domain.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
