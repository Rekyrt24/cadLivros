package com.senai.PrjGerenciamentoDeLivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.PrjGerenciamentoDeLivros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
