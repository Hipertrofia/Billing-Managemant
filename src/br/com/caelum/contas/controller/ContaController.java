package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/acicionaConta")
	public String adiciona(Conta Conta) {
		ContaDAO dao = new ContaDao();
		dao.adiciona(conta);
		return "conta-adicionada";
	}

	@RequestMapping(value = "/form")
	public String form() {
		return "formulario";
	}

	@RequestMapping("/removeConta")
	public String remove(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.remove(conta);

		return "redirect:listaContas";

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

	@RequestMapping("listaContas")
	public ModelAndView lista() {
		ContaDAO dao = new ContaDAO();
		List<Conta> contas = dao.lista();
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas", contas);
		return mv;
	}

}