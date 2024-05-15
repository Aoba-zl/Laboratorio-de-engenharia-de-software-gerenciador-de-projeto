package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetistaRepository;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class ProjetistaController {
	@Autowired
	private LoginController lController;
	@Autowired
	private IProjetistaRepository projetistaRep;
	
	@RequestMapping(name = "cadastro", value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView projetistaAddGet(ModelMap model) {
		
		return new ModelAndView("cadastro");
	}
	@RequestMapping(name = "cadastro", value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView projetistaAddPost(@RequestParam Map<String, String> allRequestParam) {
		String usuario = allRequestParam.get("nomeUsuario").trim();
		String senha = allRequestParam.get("senha").trim();
		String email = allRequestParam.get("email").trim();
		String nome = allRequestParam.get("nome").trim();
		if(validarCadastro(usuario,senha,email,nome)) {
			Projetista pro = new Projetista(email,nome);
			Login l = new Login(usuario,senha,pro);
			pro.setLogin(l);
			cadastrar(pro);
			return new ModelAndView("redirect:/login");
		}
		return new ModelAndView("cadastro");
	}
	
	@RequestMapping(name = "atualizar", value = "/atualizar/{codigo}", method = RequestMethod.GET)
	public ModelAndView projetoAtualizarGet(@PathVariable("codigo") int codigo, @RequestParam Map<String, String> allRequestParam, ModelMap model,HttpServletRequest request) {
		if(!lController.verificarLogin(request)) {
			return new ModelAndView("redirect:/login");
		}
		Projetista projetista = new Projetista();
		projetista.setId(codigo);
		projetista = consultar(projetista);
		model.addAttribute(projetista);
		return new ModelAndView("atualizar");
	}
	
	@RequestMapping(name = "atualizar", value = "/atualizar/{codigo}", method = RequestMethod.POST)
	public ModelAndView projetistaAttPost(@PathVariable("codigo") int codigo,@RequestParam Map<String, String> allRequestParam, ModelMap model,HttpServletRequest request) {
		String cmd = allRequestParam.get("botao");
		String usuario = allRequestParam.get("nomeUsuario").trim();
		String senha = allRequestParam.get("senha").trim();
		String email = allRequestParam.get("email").trim();
		String nome = allRequestParam.get("nome").trim();
		if(validarCadastro(usuario,senha,email,nome)) {
			Projetista projetista = new Projetista();
			projetista.setId(codigo);
			projetista.setEmail(email);
			projetista.setNome(nome);
			Login login = new Login();
			login.setSenha(senha);
			login.setUsuario(usuario);
			projetista.setLogin(login);
			if (cmd.contains("Atualizar")) {
				atualizar(projetista);
			}
			if (cmd.contains("Excluir")) {
				deletar(projetista);
				return new ModelAndView("redirect:/login");
			}
		}
		return projetoAtualizarGet(codigo, allRequestParam,model, request);
	}
	
	
	
	private void cadastrar(Projetista projetista) {
		projetistaRep.save(projetista);
	}
	private void atualizar(Projetista projetista) {
		projetistaRep.sp_upt_projetista(projetista.getId(), projetista.getEmail(), projetista.getNome(), projetista.getLogin().getUsuario(), projetista.getLogin().getSenha());
	}
	private void deletar(Projetista projetista) {
		projetistaRep.sp_del_projetista(projetista.getId());
		
	}	
	private Projetista consultar(Projetista projetista) {
		Optional<Projetista> projetistas = projetistaRep.findById(projetista.getId());
		return projetistas.get();
	}
	private boolean validarCadastro(String usuario,String senha,String email,String nome) {
		if(usuario == "" || usuario.length() > 80) {return false;}
		if(senha == "" || senha.length() > 30) {return false;}
		if(email == "" || email.length() >50) {return false;}
		if(nome == "" || nome.length() >100) {return false;}
		return true;
	}
}
