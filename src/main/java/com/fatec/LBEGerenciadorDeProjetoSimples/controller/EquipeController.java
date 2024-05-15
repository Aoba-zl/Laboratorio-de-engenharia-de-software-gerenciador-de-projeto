package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.AtividadeId;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Equipe;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.EquipeId;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IAtividadeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IEquipeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetistaRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetoRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EquipeController {
	@Autowired
	private LoginController lController;
	
	@Autowired
	private IProjetistaRepository projetistaRep;
	
	@Autowired
	private IProjetoRepository projetoRep;
	
	@Autowired
	private IEquipeRepository equipeRep;
	
	@RequestMapping(name = "equipe", value = "/projeto/{codigoProjeto}/atividade/equipe", method = RequestMethod.GET)
	public ModelAndView equipeGet(@PathVariable("codigoProjeto") int codigoProjeto, HttpServletRequest request, ModelMap model) {
		
		HttpSession session = request.getSession(false);
		
		Projeto p = consultarProjeto(codigoProjeto);
		
		List<Equipe> e = listarEquipe(p);
		
		model.addAttribute("equipe", e);
		
		return new ModelAndView("equipe");
	}
	
	@RequestMapping(name = "equipe", value = "/projeto/{codigoProjeto}/atividade/equipe", method = RequestMethod.POST)
	public ModelAndView equipePost(@PathVariable("codigoProjeto") int codigoProjeto, @RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("equipe");
	}
	
	@RequestMapping(name = "equipe", value = "/projeto/{codigoProjeto}/atividade/equipe/adicionar-membro", method = RequestMethod.GET)
	public ModelAndView equipeMembroGet(@PathVariable("codigoProjeto") int codigoProjeto, ModelMap model) {
		
		List<Projetista> p = listarProjetista();
		
		model.addAttribute("projetista", p);
		
		return new ModelAndView("equipe-adicionar-membro");
	}
	
	@RequestMapping(name = "equipe", value = "/projeto/{codigoProjeto}/atividade/equipe/adicionar-membro", method = RequestMethod.POST)
	public ModelAndView equipeMembroPost(@PathVariable("codigoProjeto") int codigoProjeto, @RequestParam Map<String, String> allRequestParam) {
		
		int idProjetista = Integer.parseInt(allRequestParam.get("comboBoxProjetista"));
		
		Projetista p = consultarProjetista(idProjetista);
		Projeto pr = consultarProjeto(codigoProjeto);
		
		Equipe e = new Equipe(p, pr);
		
		cadastrar(e);
		
		return new ModelAndView("redirect:/projeto/{codigoProjeto}/atividade/equipe");
	}
	
	@RequestMapping(name = "equipe", value = "/projeto/{codigoProjeto}/atividade/equipe/excluir/{codigoProjetista}", method = RequestMethod.POST)
	public ModelAndView equipeExcluirPost(@PathVariable("codigoProjeto") int codigoProjeto, @PathVariable("codigoProjetista") int codigoProjetista, @RequestParam Map<String, String> allRequestParam) {
		
		Projetista p = consultarProjetista(codigoProjetista);
		Projeto pr = consultarProjeto(codigoProjeto);
		
		EquipeId eId = new EquipeId(p, pr);
		
		deletar(eId);
		
		return new ModelAndView("redirect:/projeto/{codigoProjeto}/atividade/equipe");
	}
	
	private void cadastrar(Equipe equipe) {
		equipeRep.save(equipe);
		
	}
	
	private void deletar(EquipeId eId) {
		equipeRep.deleteById(eId);;
	}
	private Projetista consultarProjetista(int codigoProjetista) {
		return projetistaRep.findById(codigoProjetista).get();
	}
	
	private Projeto consultarProjeto(int codigoProjeto) {
		return projetoRep.findById(codigoProjeto).get();
	}
	
	private List<Projetista> listarProjetista() {
		return projetistaRep.findAll();
	}
	
	private List<Equipe> listarEquipe(Projeto projetoId){
		return equipeRep.findByProjeto(projetoId);
	}
	
	
	public void opAtividade() {

	}
}
