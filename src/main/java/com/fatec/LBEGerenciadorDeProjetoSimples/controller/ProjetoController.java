package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model) {
		
		return new ModelAndView("projeto");
	}
	
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("projeto");
	}
	
	@RequestMapping(name = "projeto-adicionar", value = "/projeto/adicionar-projeto", method = RequestMethod.GET)
	public ModelAndView projetoAddGet(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("projeto-adicionar");
	}
	
	@RequestMapping(name = "projeto-adicionar", value = "/projeto/adicionar-projeto", method = RequestMethod.POST)
	public ModelAndView projetoAddPost(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("redirect:/projeto");
	}
	
	@RequestMapping(name = "projeto-atualizar", value = "/projeto/atualizar/{codigo}", method = RequestMethod.GET)
	public ModelAndView projetoAtualizarGet(@PathVariable("codigo") int codigo, @RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("projeto-atualizar");
	}
	
	@RequestMapping(name = "projeto-atualizar", value = "/projeto/atualizar/{codigo}", method = RequestMethod.POST)
	public ModelAndView projetoAtualizarPost(@PathVariable("codigo") int codigo, @RequestParam Map<String, String> allRequestParam) {
		System.out.println(codigo);
		return new ModelAndView("redirect:/projeto");
	}
	
	@RequestMapping(name = "projeto-excluir", value = "/projeto/excluir/{codigo}", method = RequestMethod.POST)
	public ModelAndView projetoExcluirPost(@PathVariable("codigo") int codigo) {
		
		return new ModelAndView("redirect:/projeto");
	}
	
	public String cadastrar(String acao, Projeto projeto) {
		return null;
		
	}
	public String atualizar(String acao, Projeto projeto) {
		return null;
		
	}
	public String deletar(String acao, Projeto projeto) {
		return null;
		
	}
	public Projeto consultar(Projeto projeto) {
		return null;
		
	}
	public List<Projeto> listar(){
		return null;
		
	}
	public void opProjeto() {
		Projeto p = new Projeto("lacração",LocalDate.now(), LocalDate.now(),"a");
		projetoRep.save(p);
	}
}
