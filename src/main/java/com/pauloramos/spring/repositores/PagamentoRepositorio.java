package com.pauloramos.spring.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauloramos.spring.domain.Pagamento;;

@Repository
public interface PagamentoRepositorio extends JpaRepository<Pagamento, Integer> {

}
