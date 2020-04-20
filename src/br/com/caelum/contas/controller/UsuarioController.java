package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("/loginForm") 
	public String formulario{
		return "usuario/login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		new UsuarioDAO dao= new Usuario(); 
		if (dao.existeUsuario(usuario)) {
			session.setAtribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm"
	}

}
