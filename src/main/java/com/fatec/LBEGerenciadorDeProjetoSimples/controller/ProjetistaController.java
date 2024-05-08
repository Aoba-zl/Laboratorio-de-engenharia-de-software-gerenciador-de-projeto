package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetoRepository;

public class ProjetistaController {
	private LoginController lController;
	
	@Autowired
	private IProjetoRepository projetistaRep;
	
	@RequestMapping(name = "projetista", value = "/projetista", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model) {
		
		return new ModelAndView("projetista");
	}
	
	@RequestMapping(name = "projetista", value = "/projetista", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("projetista");
	}
	public String cadastrar(String acao, Projetista projetista) {
		return null;
		
	}
	public String atualizar(String acao, Projetista projetista) {
		return null;
		
	}
	public String deletar(String acao, Projetista projetista) {
		return null;
		
	}
	public Projetista consultar(Projetista projetista) {
		return null;
		
	}
}
