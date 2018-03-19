package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.UsuarioService;

@Controller
public class LoginController {
	private UsuarioService usuarioService;
	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	

	@RequestMapping("login")
	public String telaLogin() {
		return "login";
	}
	
	@RequestMapping("/fazer_login")
	public String efetuaLogin(Usuario usuario, HttpSession session) throws IOException{
		if(usuarioService.validarLogin(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "index";
		}
		return "redirect:login";
	}
	
}
