package com.valloo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valloo.models.Cartao;


public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

}
