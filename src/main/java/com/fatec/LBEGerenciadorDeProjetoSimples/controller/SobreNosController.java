package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SobreNosController {
	
	@RequestMapping(name = "sobre-nos", value = "/sobre-nos", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model) {
		
		return new ModelAndView("sobre-nos");
	}
	@RequestMapping(name = "sobre-nos", value = "/sobre-nos", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("sobre-nos");
	}
}
