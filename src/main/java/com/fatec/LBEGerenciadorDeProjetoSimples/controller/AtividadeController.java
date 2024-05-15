package com.fatec.LBEGerenciadorDeProjetoSimples.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import jakarta.transaction.Transactional;
@Controller
public class AtividadeController {
	private LoginController lController;
	
	@Autowired
	private IProjetoRepository projetoRep;
	
	@Autowired
	private IAtividadeRepository atividadeRep;
	
	@Transactional
	public void testAtividade()
	{
		Projeto p1 = new Projeto("Projeto 1", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), "test1");
		Projeto p2 = new Projeto("Projeto 2", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), "test2");
		Projeto p3 = new Projeto("Projeto 3", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), "test3");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		projetoRep.save(p1);
		projetoRep.save(p2);
		projetoRep.save(p3);
		
		Atividade a1 = new Atividade(1, "test 1", "test1", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p1);
		Atividade a2 = new Atividade(2, "test 2", "test2", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p2);
		Atividade a3 = new Atividade(3, "test 3", "test3", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p3);
		Atividade a4 = new Atividade(1, "test 4", "test4", LocalDate.of(2000, 02, 02), LocalDate.of(2000, 03, 02), p3);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		atividadeRep.save(a1);
		atividadeRep.save(a2);
		atividadeRep.save(a3);
		atividadeRep.save(a4);
		
		List<Atividade> atividades = listar();
		
		atividades.forEach(a -> System.out.println(a));
		
		AtividadeId aId = new AtividadeId(a1.getId(), p1);
		Atividade at = atividadeRep.findById(aId).get();
		
		System.out.println(at);
		
		int i = atividadeRep.fn_count_id_atividade(3);
		System.out.println(i);
		
		
		
	}
	
	@RequestMapping(name = "atividade", value = "/projeto/{codigoProjeto}/atividade", method = RequestMethod.GET)
	public ModelAndView atividadeGet(@PathVariable("codigoProjeto") int codigoProjeto, ModelMap model) {
		
		List<Atividade> atividadesDeProjeto = listar();
		List<Atividade> atividades = new ArrayList<>();
		Projeto projeto = consultarProjeto(codigoProjeto);
		
		atividadesDeProjeto.forEach(a -> {if(a.getProjeto().getId() == codigoProjeto) {atividades.add(a);} });
		
		model.addAttribute("projeto", projeto);
		model.addAttribute("atividades", atividades);
		
		return new ModelAndView("atividade");
	}
	
	@RequestMapping(name = "atividade", value = "/projeto/{codigoProjeto}/atividade", method = RequestMethod.POST)
	public ModelAndView atividadePost(@PathVariable("codigoProjeto") int codigoProjeto, @RequestParam Map<String, String> allRequestParam) {
		
		return new ModelAndView("atividade");
	}
	
	@DeleteMapping
	
	@RequestMapping(name = "atividade", value = "/projeto/{codigoProjeto}/atividade/{codigoAtividade}", method = RequestMethod.GET)
	public ModelAndView umAtividadeGet(@PathVariable("codigoProjeto") int codigoProjeto, @PathVariable("codigoAtividade") int codigoAtividade, ModelMap model) {
		
		Atividade a = new Atividade();
		Projeto p = consultarProjeto(codigoProjeto);
		a.setId(codigoAtividade);
		
		AtividadeId aId = new AtividadeId(a.getId(), p);
		
		a = consultar(aId);
		
		List<Atividade> aListProjeto = listar();
		List<Atividade> atividades = new ArrayList<>();
		
		p = consultarProjeto(codigoProjeto);
		
		aListProjeto.forEach(v -> {if(v.getProjeto().getId() == codigoProjeto) {atividades.add(v);} });
		
		model.addAttribute("projeto", p);
		model.addAttribute("atividade", a);
		model.addAttribute("atividades", atividades);
		
		return new ModelAndView("atividade");
	}
	
	@RequestMapping(name = "atividade-atualizar", value = "/projeto/{codigoProjeto}/atividade/{codigoAtividade}/atualizar", method = RequestMethod.GET)
	public ModelAndView atividadeAtualizarGet(@PathVariable("codigoProjeto") int codigoProjeto, @PathVariable("codigoAtividade") int codigoAtividade, @RequestParam Map<String, String> allRequestParam, ModelMap model) {
		
		Projeto p = consultarProjeto(codigoProjeto);
		AtividadeId aId = new AtividadeId(codigoAtividade, p);
		Atividade a = consultar(aId);
		
		model.addAttribute("atividade", a);
		
		return new ModelAndView("atividade-atualizar");
	}
	
	@RequestMapping(name = "atividade-atualizar", value = "/projeto/{codigoProjeto}/atividade/{codigoAtividade}/atualizar", method = RequestMethod.POST)
	public ModelAndView atividadeAtualizarPost(@PathVariable("codigoProjeto") int codigoProjeto, @RequestParam Map<String, String> allRequestParam, ModelMap model) {
		
		String nome = allRequestParam.get("nome");
		String dataInicial = allRequestParam.get("dataInicial");
		String dataFinal = allRequestParam.get("dataFinal");
		String descricao = allRequestParam.get("descricao");
		
		Projeto p = consultarProjeto(codigoProjeto);
		
		Atividade a = new Atividade();
		a.setNome(nome);
		a.setDataInicial(LocalDate.parse(dataInicial));
		a.setDataFinal(LocalDate.parse(dataFinal));
		a.setDescricao(descricao);
		a.setProjeto(p);
		
		atualizar(a);
		
		return new ModelAndView("redirect:/projeto/{codigoProjeto}/atividade/{codigoAtividade}");
	}
	
	@RequestMapping(name = "atividade-adicionar", value = "/projeto/{codigoProjeto}/atividade/adicionar-atividade", method = RequestMethod.GET)
	public ModelAndView atividadeAdicionarGet(@PathVariable("codigoProjeto") int codigoProjeto, ModelMap model) {
		
		return new ModelAndView("atividade-adicionar");
	}
	
	@RequestMapping(name = "atividade-adicionar", value = "/projeto/{codigoProjeto}/atividade/adicionar-atividade", method = RequestMethod.POST)
	public ModelAndView atividadeAdicionarPost(@PathVariable("codigoProjeto") int codigoProjeto, @RequestParam Map<String, String> allRequestParam) {
		
		String nome = allRequestParam.get("nome");
		String dataInicial = allRequestParam.get("dataInicial");
		String dataFinal = allRequestParam.get("dataFinal");
		String descricao = allRequestParam.get("descricao");
		
		Projeto p = consultarProjeto(codigoProjeto);
		
		Atividade a = new Atividade();
		a.setId(conutId(codigoProjeto));
		a.setNome(nome);
		a.setDataInicial(LocalDate.parse(dataInicial));
		a.setDataFinal(LocalDate.parse(dataFinal));
		a.setDescricao(descricao);
		a.setProjeto(p);
		
		cadastrar(a);
		
		return new ModelAndView("redirect:/projeto/{codigoProjeto}/atividade");
	}
	
	@RequestMapping(name = "atividade-excluir", value = "/projeto/{codigoProjeto}/atividade/{codigoAtividade}/excluir", method = RequestMethod.POST)
	public ModelAndView atividadeExcluirPost(@PathVariable("codigoProjeto") int codigoProjeto, @PathVariable("codigoAtividade") int codigoAtividade) {
		
		Projeto p = consultarProjeto(codigoProjeto);
		AtividadeId aId = new AtividadeId(codigoAtividade, p);
		
		deletar(aId);
		
		return new ModelAndView("redirect:/projeto/{codigoProjeto}/atividade");
	}
	
	private void cadastrar(Atividade atividade) {
		atividadeRep.save(atividade);
		
	}
	private void atualizar(Atividade atividade) {
		atividadeRep.save(atividade);
	}
	
	private void deletar(AtividadeId atividade) {
		atividadeRep.deleteById(atividade);;
	}
	private Atividade consultar(AtividadeId aId) {
		return atividadeRep.findById(aId).get();
	}
	
	public List<Atividade> listar(){
		return atividadeRep.findAll();
	}
	
	private Projeto consultarProjeto(int codigoProjeto) {
		return projetoRep.findById(codigoProjeto).get();
	}
	
	private int conutId(int idProjeto)
	{
		
		return atividadeRep.fn_count_id_atividade(idProjeto);
	}
}
