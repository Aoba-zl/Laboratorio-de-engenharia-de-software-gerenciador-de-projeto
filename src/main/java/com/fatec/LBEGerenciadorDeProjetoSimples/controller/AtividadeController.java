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
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IAtividadeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IProjetoRepository;

import jakarta.persistence.Transient;
@Controller
public class AtividadeController {
	@Autowired
	private LoginController lController;
	
	@Autowired
	private IProjetoRepository projetoRep;
	@Autowired
	private IAtividadeRepository atividadeRep;
	
	@Transient
	@RequestMapping(name = "atividade", value = "/projeto/{codigoProjeto}/atividade", method = RequestMethod.GET)
    public ModelAndView atividadeGet(@PathVariable("codigoProjeto") int codigoProjeto, ModelMap model) {

        List<Atividade> atividades = listar();
        System.out.println(atividades);

        model.addAttribute("atividades", atividades);

        return new ModelAndView("atividade");
    }
	
	@RequestMapping(name = "atividade", value = "/atividade", method = RequestMethod.POST)
	public ModelAndView projetoPost(@RequestParam Map<String, String> allRequestParam) {
		return new ModelAndView("atividade");
	}
	
	public String cadastrar(String acao, Atividade atividade) {
		return null;
		
	}
	public String atualizar(String acao, Atividade atividade) {
		return null;
		
	}
	public String deletar(String acao, Atividade atividade) {
		return null;
		
	}
	public Atividade consultar(Atividade atividade) {
		return null;
		
	}
	public List<Atividade> listar(){
		return atividadeRep.findAll();
		
	}
	public void opAtividade() {

	}
}
