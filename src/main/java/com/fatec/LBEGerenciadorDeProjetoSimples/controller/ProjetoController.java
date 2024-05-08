package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IEquipeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetoRepository;

@Controller
public class ProjetoController {
	private LoginController lController;
	
	@Autowired
	private IProjetoRepository projetoRep;
	private IProjetoRepository projetistaRep;
	private IEquipeRepository equipeRep;
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model) {
		
		return new ModelAndView("projeto");
	}
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("projeto");
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
}
