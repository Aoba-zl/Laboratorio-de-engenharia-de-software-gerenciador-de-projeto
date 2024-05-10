package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.ILoginRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private ILoginRepository cadastroRep;
	
	@RequestMapping(name = "cadastro", value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model) {
		
		return new ModelAndView("cadastro");
	}
	@RequestMapping(name = "cadastro", value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("redirect:/login");
	}
}
