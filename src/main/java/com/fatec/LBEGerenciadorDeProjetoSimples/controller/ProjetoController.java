package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IEquipeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetistaRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetoRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

@Controller
public class ProjetoController {
	private LoginController lController;
	
	@Autowired
	private IProjetoRepository projetoRep;
	@Autowired
	private IProjetistaRepository projetistaRep;
	@Autowired
	private IEquipeRepository equipeRep;
	
	// teria que fazer um listar especializado onde ele só puxa projetos em que a pessoa esta
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model) {
		List<Projeto> projetos = listar();
		model.addAttribute("projetos",projetos);
		return new ModelAndView("projeto");
	}
	
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		int id = Integer.parseInt(allRequestParam.get("botaoId"));
		if (cmd.contains("Excluir")) {
			Projeto projeto = new Projeto();
			projeto.setId(id);
			projeto = consultar(projeto);
			deletar("D",projeto);
		}
		List<Projeto> projetos = listar();
		model.addAttribute("projetos",projetos);
		return new ModelAndView("projeto");
	}
	
	@RequestMapping(name = "projeto-adicionar", value = "/projeto/adicionar-projeto", method = RequestMethod.GET)
	public ModelAndView projetoAddGet(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("projeto-adicionar");
	}
	
	// Precisa fazer ela adicionar a equipe tbm
	@RequestMapping(name = "projeto-adicionar", value = "/projeto/adicionar-projeto", method = RequestMethod.POST)
	public ModelAndView projetoAddPost(@RequestParam Map<String, String> allRequestParam) {
		String nome = allRequestParam.get("nomeProjeto").trim();
		String inical = allRequestParam.get("dataInicial");
		String fina = allRequestParam.get("dataFinal");
		String descricao = allRequestParam.get("descricao").trim();
		
		LocalDate dInicial = toLocalDate(inical);
		LocalDate dFinal = toLocalDate(fina);
		
		Projeto p = new Projeto(nome,dInicial,dFinal,descricao);
		cadastrar("d", p);
		return new ModelAndView("redirect:/projeto");
	}
	
	@RequestMapping(name = "projeto-atualizar", value = "/projeto/atualizar/{codigo}", method = RequestMethod.GET)
	public ModelAndView projetoAtualizarGet(@PathVariable("codigo") int codigo, @RequestParam Map<String, String> allRequestParam, ModelMap model) {
		Projeto projeto = new Projeto();
		projeto.setId(codigo);
		projeto = consultar(projeto);
		model.addAttribute("projeto",projeto);
		return new ModelAndView("projeto-atualizar");
	}
	
	@RequestMapping(name = "projeto-atualizar", value = "/projeto/atualizar/{codigo}", method = RequestMethod.POST)
	public ModelAndView projetoAtualizarPost(@PathVariable("codigo") int codigo, @RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String nome = allRequestParam.get("nomeProjeto").trim();
		String inical = allRequestParam.get("dataInicial");
		String fina = allRequestParam.get("dataFinal");
		String descricao = allRequestParam.get("descricao").trim();
		LocalDate dInicial = toLocalDate(inical);
		LocalDate dFinal = toLocalDate(fina);
		Projeto projeto = new Projeto();
		projeto.setId(codigo);
		projeto = consultar(projeto);
		projeto.setNome(nome);
		projeto.setDataInicial(dInicial);
		projeto.setDataFinal(dFinal);
		projeto.setDescricao(descricao);

		atualizar("a", projeto);
		return new ModelAndView("redirect:/projeto");
	}
	
	public String cadastrar(String acao, Projeto projeto) {
		projetoRep.save(projeto);
		return "Projeto Cadastrado";
	}
	public String atualizar(String acao, Projeto projeto) {
		projetoRep.save(projeto);
		return "Projeto Atualizado";
		
	}
	public String deletar(String acao, Projeto projeto) {
		projetoRep.sp_del_projeto(projeto.getId());
		return "Projeto Excluido";
		
	}
	public Projeto consultar(Projeto projeto) {
		Optional<Projeto> p = projetoRep.findById(projeto.getId());
		return p.get();
		
	}
	public List<Projeto> listar() {
		return projetoRep.findAll();
	}
	
	private LocalDate toLocalDate (String data) {
		LocalDate localdate = LocalDate.parse(data);
		return localdate;
		
	}
}
