package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Equipe;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IEquipeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetistaRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProjetoController {
	@Autowired
	private LoginController lController;
	@Autowired
	private IProjetoRepository projetoRep;
	@Autowired
	private IProjetistaRepository projetistaRep;
	@Autowired
	private IEquipeRepository equipeRep;
	
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.GET)
	public ModelAndView projetoGet(ModelMap model ,HttpServletRequest request) {

		if(!lController.verificarLogin(request)) {
			 return new ModelAndView("redirect:/login");
		}
		HttpSession session = request.getSession(false);
		Login login = (Login) session.getAttribute("login");
		List<Projeto> projetos = projetoRep.fn_projeto(login.getId());
		model.addAttribute("projetos",projetos);
		model.addAttribute("login",login);
		return new ModelAndView("projeto");
	}
	
	@RequestMapping(name = "projeto", value = "/projeto", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam, HttpServletRequest request, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		int id = Integer.parseInt(allRequestParam.get("botaoId"));
		if (cmd.contains("Excluir")) {
			HttpSession session = request.getSession(false);
            Login login = (Login) session.getAttribute("login");
			Projeto projeto = new Projeto();
			projeto.setId(id);
			projeto = consultar(projeto);
			deletar(projeto, login);
		}
		List<Projeto> projetos = listar();
		model.addAttribute("projetos",projetos);
		return new ModelAndView("projeto");
	}
	
	@RequestMapping(name = "projeto-adicionar", value = "/projeto/adicionar-projeto", method = RequestMethod.GET)
	public ModelAndView projetoAddGet(@RequestParam Map<String, String> allRequestParam,HttpServletRequest request) {
		 if(!lController.verificarLogin(request)) {
			 return new ModelAndView("redirect:/login");
		 }
		return new ModelAndView("projeto-adicionar");
	}
	
	@RequestMapping(name = "projeto-adicionar", value = "/projeto/adicionar-projeto", method = RequestMethod.POST)
	public ModelAndView projetoAddPost(@RequestParam Map<String, String> allRequestParam,ModelMap model,HttpServletRequest request) {
		 HttpSession session = request.getSession(false);
		String nome = allRequestParam.get("nomeProjeto").trim();
		String inicial = allRequestParam.get("dataInicial");
		String fina = allRequestParam.get("dataFinal");
		String descricao = allRequestParam.get("descricao").trim();
		if (validar(nome,inicial,fina,descricao)){
			LocalDate dInicial = toLocalDate(inicial);
			LocalDate dFinal = toLocalDate(fina);
			if (ChronoUnit.DAYS.between(dInicial,dFinal) > 0) {
				Login login = (Login) session.getAttribute("login");
				Projeto p = new Projeto(nome,dInicial,dFinal,descricao);
				cadastrar(login, p);
				return new ModelAndView("redirect:/projeto");
			}
		}
		model.addAttribute("nome",nome);
		model.addAttribute("inicial",inicial);
		model.addAttribute("fina",fina);
		model.addAttribute("descricao",descricao);
		return new ModelAndView("projeto-adicionar");
	}
	
	@RequestMapping(name = "projeto-atualizar", value = "/projeto/atualizar/{codigo}", method = RequestMethod.GET)
	public ModelAndView projetoAtualizarGet(@PathVariable("codigo") int codigo, @RequestParam Map<String, String> allRequestParam, ModelMap model,HttpServletRequest request) {
		if(!lController.verificarLogin(request)) {
			 return new ModelAndView("redirect:/login");
		}
		Projeto projeto = new Projeto();
		projeto.setId(codigo);
		projeto = consultar(projeto);
		model.addAttribute("projeto",projeto);
		return new ModelAndView("projeto-atualizar");
	}
	
	@RequestMapping(name = "projeto-atualizar", value = "/projeto/atualizar/{codigo}", method = RequestMethod.POST)
	public ModelAndView projetoAtualizarPost(@PathVariable("codigo") int codigo, @RequestParam Map<String, String> allRequestParam, ModelMap model,HttpServletRequest request) {
		String nome = allRequestParam.get("nomeProjeto").trim();
		String inicial = allRequestParam.get("dataInicial");
		String fina = allRequestParam.get("dataFinal");
		String descricao = allRequestParam.get("descricao").trim();
		Projeto projeto = new Projeto();
		if (validar(nome, inicial, fina, descricao)){
			LocalDate dInicial = toLocalDate(inicial);
			LocalDate dFinal = toLocalDate(fina);
			if (ChronoUnit.DAYS.between(dInicial,dFinal) > 0) {
			projeto.setId(codigo);
			projeto = consultar(projeto);
			projeto.setNome(nome);
			projeto.setDataInicial(dInicial);
			projeto.setDataFinal(dFinal);
			projeto.setDescricao(descricao);
			atualizar(projeto);
			return new ModelAndView("redirect:/projeto");
			}
		}
		return projetoAtualizarGet(codigo,allRequestParam,model,request);
	}
	
	private void cadastrar(Login login, Projeto projeto) {
		projetoRep.save(projeto);
		Optional<Projetista> o = projetistaRep.findById(login.getId());
		Equipe equipe = new Equipe(o.get(),projeto);
		equipeRep.save(equipe);
	}
	
	private void atualizar(Projeto projeto) {
		projetoRep.save(projeto);
		
	}
	
	private void deletar(Projeto projeto, Login login) {
		projetoRep.sp_del_projeto(projeto.getId(), login.getId());
		
	}
	
	private Projeto consultar(Projeto projeto) {
		Optional<Projeto> p = projetoRep.findById(projeto.getId());
		return p.get();
	}
	
	private List<Projeto> listar() {
		return projetoRep.findAll();
	}
	
	private LocalDate toLocalDate (String data) {
		LocalDate localdate = LocalDate.parse(data);
		return localdate;
		
	}
	private boolean validar(String nome, String dInicial, String dFinal, String descricao) {
		if(nome == "" || nome.length() > 40) {return false;}
		if(dInicial == null) {return false;}
		if(dFinal == null) {return false;}
		if(descricao == "" || descricao.length() > 100) {return false;}
		return true;
	}
}
