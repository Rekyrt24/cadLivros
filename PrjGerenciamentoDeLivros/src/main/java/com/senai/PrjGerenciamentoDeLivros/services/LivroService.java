package com.senai.PrjGerenciamentoDeLivros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.PrjGerenciamentoDeLivros.entities.Livro;
import com.senai.PrjGerenciamentoDeLivros.repository.LivroRepository;

@Service
public class LivroService {
	private final LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
	}

	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}
	// fazendo o update do livro com o optional
		public Livro updateLivro(Long id, Livro novoLivro) {
	        Optional<Livro> livroOptional = livroRepository.findById(id);
	        if (livroOptional.isPresent()) {
	        	Livro livroExistente = livroOptional.get();
	           	livroExistente.setDescricao(novoLivro.getDescricao());
	        	livroExistente.setIsbn(novoLivro.getIsbn());          
	            return livroRepository.save(livroExistente); 
	        } else {
	            return null; 
	            
	        }
	    }
}

