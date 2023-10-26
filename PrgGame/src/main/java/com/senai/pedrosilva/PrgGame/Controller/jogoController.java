package com.senai.pedrosilva.PrgGame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.pedrosilva.PrgGame.entities.*;
import com.senai.pedrosilva.PrgGame.services.*;


@RestController
@RequestMapping("/jogos")
public class jogoController {

	private final jogoServices jogoServices;
	
	@Autowired
	public jogoController (jogoServices jogoServices) {
		this.jogoServices = jogoServices;
	}
	
	@PostMapping
	public jogo createJogo(@RequestBody jogo jogo) {
		return jogoServices.saveJogo(jogo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<jogo> getJogo(@PathVariable Long id) {
		jogo jogo = jogoServices.getJogoById(id);
		if(jogo != null) {
			return ResponseEntity.ok(jogo);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // Nome do seu arquivo HTML (sem a extensão)
	}
	
	
	public List<jogo> getAllJogo(){
		return jogoServices.getAllJogo();
	}
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		jogoServices.deleteJogo(id);
	}
	//Utilizando o ResponseEntity e RequestEntity
		@GetMapping
		public ResponseEntity<List<jogo>> getAllJogos(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<jogo> jogos = jogoServices.getAllJogo();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(jogos);
		}
		
		@PutMapping("/{id}")
		public jogo updateJogo(@PathVariable Long id, @RequestBody jogo jogo) {
		    return jogoServices.updateJogo(id, jogo);
		}
		
}	
	
	
	
	
	 
	
	
	
	

