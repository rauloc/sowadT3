package com.web.rest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entidades.PeliculaEL;
import com.negocio.PeliculaBL;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value = "/listacontactos", method = RequestMethod.GET, 
			produces="application/JSON")	
	public @ResponseBody List<PeliculaEL>  listacontactos(int IdUsuario ) {
		List<PeliculaEL> ur  = null;
		try {
			ur = PeliculaBL.Instancia().ListarPeliculas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ur;
	}
	
}
