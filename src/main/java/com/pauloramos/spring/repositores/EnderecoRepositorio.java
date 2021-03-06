package com.pauloramos.spring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloramos.spring.domain.Endereco;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {

}
