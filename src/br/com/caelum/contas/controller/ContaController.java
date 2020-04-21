package br.com.caelum.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	private ContaDAO dao;
	
	@Autowired
	public ContaController(ContaDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/form")
	public String form() {
		return "formulario";
	}
	
	@RequestMapping("/acicionaConta")
	public String adiciona(@Valid Conta conta, BidingResult result) {
	
		If (result.hasErros()){
			return "formulario";
		}
		
		System.out.println("Conta Adicionada é: " +conta.getDescrição()); 
		dao.adiciona(conta);
		return "conta-adicionada";
	}
	
	@requestMapping("/pagaConta")
	public void paga(Conta conta. HttpServletResponse response) {
		dao.paga(conta.getId());
		
		response.setStatus(200);		
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta) {
		dao.remove(conta);

		return "redirect:listaContas";
	}
	
	@RequestMapping("listaContas")
	public ModelAndView lista() {
		List<Conta> contas = dao.lista();
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas", contas);
		return mv;
	}

	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
		ContaDAO dao = new ContaDAO();
		model.addAttribute("conta", dao.buscaPorId(id));
		return "conta/mostra";
	}

	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.altera(conta);
		return "redirect:listaContas";
	}

	

}
