package com.pauloramos.spring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloramos.spring.domain.ItemPedido;;

@Repository
public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Integer> {

}
