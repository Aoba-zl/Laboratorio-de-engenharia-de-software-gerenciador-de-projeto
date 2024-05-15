package com.fatec.LBEGerenciadorDeProjetoSimples;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.LBEGerenciadorDeProjetoSimples.controller.AtividadeController;
import com.fatec.LBEGerenciadorDeProjetoSimples.controller.ProjetistaController;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.AtividadeId;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IAtividadeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetoRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class LbeGerenciadorDeProjetoSimplesApplicationTests {
	
	@Autowired
	IProjetoRepository projetoRep;
	
	@Autowired
	IAtividadeRepository atividadeRep;
	
	@Autowired
	AtividadeController aCon;
	
	
	@Test
	@Transactional
	void contextLoads() 
	{
		Projeto p1 = new Projeto("Projeto 1", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), "test1");
		Projeto p2 = new Projeto("Projeto 2", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), "test2");
		Projeto p3 = new Projeto("Projeto 3", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), "test3");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		projetoRep.save(p1);
		projetoRep.save(p2);
		projetoRep.save(p3);
		
		Atividade a1 = new Atividade(1, "test 1", "test1", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p1);
		Atividade a2 = new Atividade(2, "test 2", "test2", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p2);
		Atividade a3 = new Atividade(3, "test 3", "test3", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p3);
		Atividade a4 = new Atividade(1, "test 4", "test4", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p3);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		atividadeRep.save(a1);
		atividadeRep.save(a2);
		atividadeRep.save(a3);
		atividadeRep.save(a4);
		
		List<Atividade> atividades = aCon.listar();
		
		atividades.forEach(a -> System.out.println(a));
		
		AtividadeId aId = new AtividadeId(a1.getId(), p1);
		Atividade at = atividadeRep.findById(aId).get();
		
		System.out.println(at);
		
		int i = atividadeRep.fn_count_id_atividade(3);
		System.out.println(i);
		
		
	}

}
