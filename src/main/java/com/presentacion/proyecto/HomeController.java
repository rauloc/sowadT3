package com.presentacion.proyecto;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accesoadatos.ButacaDL;
import com.entidades.ButacasEL;
import com.entidades.FuncionesEL;
import com.entidades.PeliculaEL;
import com.entidades.ReservasEL;
import com.entidades.UsuarioEL;
import com.negocio.ButacaBL;
import com.negocio.FuncionBL;
import com.negocio.PeliculaBL;
import com.negocio.ReservaBL;
import com.negocio.UsuarioBL;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		return new ModelAndView("home", "command", new UsuarioEL());
	}
	@RequestMapping(value = "/Registrar", method = RequestMethod.GET)
	public ModelAndView Registrar(Locale locale, Model model) {
		
		return new ModelAndView("Registrarse", "command", new UsuarioEL());
	}
	@RequestMapping(value = "/Inicia", method = RequestMethod.GET)
	public ModelAndView Inicia(Locale locale, Model model) {
		
		return new ModelAndView("Login", "command", new UsuarioEL());
	}
	@RequestMapping(value = "/RegistroUsuario", method = RequestMethod.POST)
	public ModelAndView RegistroUsuario(@ModelAttribute UsuarioEL p) {
	    try {
	    	UsuarioBL.Instancia().InsertarUsuario(p);
	    	return new ModelAndView("Principal", "command", new UsuarioEL());
		} catch (Exception e) {
			return new ModelAndView("redirect:/RegistroUsuario?"+e.getMessage());
		}
	}
	@RequestMapping(value = "/VerificarAcceso", method = RequestMethod.POST)
	public String VerificarAcceso(@ModelAttribute("SpringWeb")UsuarioEL u, 
								ModelMap model,HttpServletRequest request){
		try {
			String _Usuario = u.getUsuario();
			String _Pass = u.getPassword();
			u=UsuarioBL.Instancia().VerificarAcceso(_Usuario, _Pass);
			HttpSession ses = request.getSession();
			ses.setAttribute("usuario", u);
			if(u.getTipoUsuario().equals("Espectador")){
				return "Principal";}
				
			else
				return "Error";
		} catch (Exception e) {
			return "Error";
		} 
	}
	@RequestMapping(value = "/Reserva", method = RequestMethod.GET)
	public ModelAndView EReserva() {
		try {
			ModelAndView m = new ModelAndView("Reserva");
			return m;
		} catch (Exception e) {
			return new ModelAndView("Principal", "command",null);
		}
		
	}
	
	@RequestMapping(value = "/Sala", method = RequestMethod.GET)
	public ModelAndView Sala() {
		try {
			ModelAndView m = new ModelAndView("Sala");
			return m;
		} catch (Exception e) {
			return new ModelAndView("Principal", "command",null);
		}	
	}
	@RequestMapping(value = "/Guardar", method = RequestMethod.GET)
	public ModelAndView Guardar() {
		try {
			ModelAndView m = new ModelAndView("Guarda");
			return m;
		} catch (Exception e) {
			return new ModelAndView("Principal", "command",null);
		}
		
	}
}
