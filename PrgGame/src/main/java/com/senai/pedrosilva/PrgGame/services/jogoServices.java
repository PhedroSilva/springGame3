package com.senai.pedrosilva.PrgGame.services;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.senai.pedrosilva.PrgGame.entities.*;

import com.senai.pedrosilva.PrgGame.Repositories.*;


@Service
public class jogoServices {
	private final jogoRepository jogoRepository;
	
	@Autowired
	public jogoServices (jogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public jogo saveJogo(jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	public List<jogo> getAllJogo(){
		return jogoRepository.findAll();
	}
	
	public jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
	// fazendo o update do jogo com o optional
		public jogo updateJogo(Long id, jogo novoJogo) {
	        Optional<jogo> jogoOptional = jogoRepository.findById(id);
	        if (jogoOptional.isPresent()) {
	        	jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setName(novoJogo.getName());
	        	jogoExistente.setPlataform(novoJogo.getPlataform());          
	            return jogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	    }
		
		
}
	