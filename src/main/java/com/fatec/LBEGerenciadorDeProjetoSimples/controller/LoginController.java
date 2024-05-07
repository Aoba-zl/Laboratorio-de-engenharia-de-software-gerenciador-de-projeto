package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;

@Controller
public class LoginController {
	@RequestMapping(name = "projetistaLogin", value = "/projetistaLogin", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model) {
		
		return new ModelAndView("projetistaLogin");
	}
	@RequestMapping(name = "projetistaLogin", value = "/projetistaLogin", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("projetistaLogin");
	}
	public boolean verificarLogin (Login login) {
		return false;
		
	}
}