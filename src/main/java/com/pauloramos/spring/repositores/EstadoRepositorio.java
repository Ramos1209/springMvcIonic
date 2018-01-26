package com.pauloramos.spring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloramos.spring.domain.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer> {

}
