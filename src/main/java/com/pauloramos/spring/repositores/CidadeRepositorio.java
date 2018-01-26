package com.pauloramos.spring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloramos.spring.domain.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {

}
