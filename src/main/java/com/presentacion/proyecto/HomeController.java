package com.presentacion.proyecto;

import java.sql.Time;
import java.text.DateFormat;
import java.sql.Date;
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
	    	return new ModelAndView("Exito", "command", new UsuarioEL());
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
	@RequestMapping(value = "/Guardar", method = RequestMethod.POST)
	public ModelAndView Guardar(int ReservaIdFucion, HttpServletRequest request, int cantbutacas) {
		try {
			FuncionesEL f=FuncionBL.Instancia().BuscarFuncion(ReservaIdFucion);
			ReservasEL r=new ReservasEL();
			Time h=f.getHorario().getHorario();
			int fu,s,p;
			fu=f.getIdFuncion();
			s=f.getSala().getIdSala();
			p=f.getPelicula().getIdPelicula();
			r.setFuncionid(fu);
			r.setSalaid(s);
			r.setPelucilaid(p);
			r.setHorarios(h);
			r.setFuncion(f);
			HttpSession session = request.getSession();
			UsuarioEL usuario = (UsuarioEL) session.getAttribute("usuario");
			r.setUsuarioid(usuario.getIdUsuario());
			double monto=(f.getHorario().getPrecio()*cantbutacas);
			r.setPrecio((int)monto);
			ReservaBL.Instancia().InsertarReserva(r);
			if (cantbutacas != 0)
	        {
	            for (int x = 1; x <= cantbutacas; x++)
	            {
	                int columna = Integer.parseInt(request.getParameter("asientoc" + x));
	                int fila = Integer.parseInt(request.getParameter("asientof" + x));
	                ButacasEL b = new ButacasEL(fu, fila, columna);
	                ButacaDL.Instancia().ReservarButaca(b);
	            }
	        }
		//	ModelMap model=new ModelMap();
		//	model.put("ExitoReserva",pagorealizado);
			return new ModelAndView("redirect:ExitoReserva");
			//ModelAndView m = new ModelAndView("ExitoReserva");
			//return m;
		} catch (Exception e) {
			return new ModelAndView("Principal", "command",null);
		}
		
	}
}
