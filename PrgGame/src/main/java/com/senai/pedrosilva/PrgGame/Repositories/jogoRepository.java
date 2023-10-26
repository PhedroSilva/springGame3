package com.senai.pedrosilva.PrgGame.Repositories;

	import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.senai.pedrosilva.PrgGame.entities.jogo;
	
	public interface jogoRepository extends JpaRepository<jogo, Long>{
	
}
