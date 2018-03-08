package com.pauloramos.spring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloramos.spring.domain.Pedido;;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {

}
