package com.kapital.sitramas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kapital.sitramas.be.Persona;
import com.kapital.sitramas.be.Usuario;
import com.kapital.sitramas.dao.UsuarioDAO;
import com.kapital.sitramas.seguridad.service.PersonaService;
import com.kapital.sitramas.seguridad.service.UsuarioService;
import com.kapital.sitramas.usuario.dao.PersonaDAO;


@Controller
public class IndexController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/error")
	public String pageError(){
		return "error";
	}
	
	@RequestMapping(value={"/","/index**"}, method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		String username = request.getUserPrincipal().getName();
		Usuario oUsuario = usuarioService.findUsuarioByUsername(username);
		String oUserName = oUsuario.getPersona().getNombres() + " " +oUsuario.getPersona().getApellidoPaterno();
		request.getSession().setAttribute("sUser", oUserName);
		request.getSession().setAttribute("usuario", oUsuario);
		if(oUsuario!=null)
			request.getSession().setAttribute("userDNI", oUsuario.getPersona().getDni());
		return model;
	}
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView inicio(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request){

		ModelAndView model = new ModelAndView();
		if(error != null){
			model.addObject("error", "Usuario y/o contraseña Inválidos");
		}
		
		if(logout != null){
			model.addObject("msg", "Su Sesión ha Terminado.");
		}
		model.setViewName("login");
		
		return model;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if(auth != null){
			 new SecurityContextLogoutHandler().logout(request, response, auth);
		 }
		 return "redirect:/login?logout";
		
		
	}
}
