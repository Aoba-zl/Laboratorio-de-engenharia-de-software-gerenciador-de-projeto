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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginRepository loginRep;
	
	@RequestMapping(name = "login", value = "/login", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model,HttpServletRequest request) {
		 HttpSession session = request.getSession(false);
		 if (session != null) {
			 session.removeAttribute("login");
		 }
		 return new ModelAndView("login");
	}
	@RequestMapping(name = "login", value = "/login", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam,HttpServletRequest request) {
		String usuario = allRequestParam.get("nomeUsuario").trim();
		String senha = allRequestParam.get("senha").trim();
		if (validar(usuario, senha)) {
			Login login = loginRep.fn_login(usuario);
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			return new ModelAndView("redirect:/projeto");
		}
		return new ModelAndView("login");
	}
	
	public boolean verificarLogin (HttpServletRequest request) {
		 HttpSession session = request.getSession(false);
		 if (session == null) {
			 return false;
		 }
		 Login login = (Login) session.getAttribute("login");
		 if (login == null) {
			 return false;
		 }
		 return true;
	}
	private boolean validar (String usuario, String senha) {
		if(usuario == "" || usuario.length() > 80) {return false;}
		if(senha == "" || senha.length() > 30) {return false;}
		return true;
	}
}
