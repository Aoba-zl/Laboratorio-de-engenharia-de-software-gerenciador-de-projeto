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

import com.fatec.LBEGerenciadorDeProjetoSimples.controller.ProjetoController;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Equipe;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IAtividadeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IEquipeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.ILoginRepository;

@SpringBootTest
class LbeGerenciadorDeProjetoSimplesApplicationTests {
	
	@Autowired
	private ProjetoController pCon;
	
	@Autowired
	private AtividadeController aCon;
	
	@Autowired 
	private ProjetistaController projetistaCon;
	
	@Autowired
	private IEquipeRepository equipeRep;

	@Autowired
	private IProjetoRepository projetoRep;
	
	@Autowired
	private IAtividadeRepository atividadeRep;
	
	@Autowired
	private ILoginRepository lrep;
	
	
	@Test
	@Transactional
	void req_test_matheus() 
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
		
//		List<Atividade> atividades = aCon.listar();
		
//		atividades.forEach(a -> System.out.println(a));
		
		AtividadeId aId = new AtividadeId(a1.getId(), p1);
		Atividade at = atividadeRep.findById(aId).get();
		
		System.out.println(at);
		
		int i = atividadeRep.fn_count_id_atividade(3);
		System.out.println(i);
	}
		
	@Test
	void req_test_david() {
		
//		Projetista pro = new Projetista("a","a");
//		Login l = new Login("lulala","aranha",pro);
//		pro.setLogin(l);
////
//		Projeto p = new Projeto("lacração",LocalDate.now(), LocalDate.now(),"a");
//		Atividade a = new Atividade(p,LocalDate.now(),LocalDate.now(),"a","nome");
////		
//		Equipe e = new Equipe(pro, p);
//		
//		pCon.cadastrar(l,p);
//		projetistaCon.cadastrar(pro);
//		atividadeRep.save(a);
//		equipeRep.save(e);
//		
//		List<Projeto> projetos = pCon.listar();
//		Login login = new Login();
//		login = lrep.fn_login(null);
//		System.out.println(login);
		
//		Projetista pro = new Projetista();
//		pro.setId(2);
//		pro = projetistaCon.consultar(pro);
//		projetistaCon.deletar(pro);
	}

}
