package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import com.entidades.CineEL;
import com.entidades.FuncionesEL;
import com.entidades.HorarioEL;
import com.entidades.PeliculaEL;
import com.entidades.SalaEL;

public class FuncionesDL {
	// Singleton
		public static FuncionesDL _Instancia;
		private FuncionesDL() {
		};
		public static FuncionesDL Instancia() {
			if (_Instancia == null) {
				_Instancia = new FuncionesDL();
			}
			return _Instancia;
		}
	// endSingleton
		public Hashtable ListarFuncionesPelicula(int idpe) throws Exception{
			Connection cn = null;
			Hashtable ListaRTA = new Hashtable();
	        FuncionesEL aux = null;
	        try {
	        	cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call sp_ListarFuncion(?)}");
				cst.setInt(1, idpe);
				ResultSet rs = cst.executeQuery();
				 while (rs.next())
			        {
					// SalaDL a=null;
					 	aux = new FuncionesEL();
					 	aux.setIdFuncion(rs.getInt("idFuncion"));
					 	SalaEL s=new SalaEL();
					 	s.setIdSala(rs.getInt("IdSala"));
					 	s.setNombre(rs.getString("Nombre"));
					 	s.setFilas(rs.getInt("Filas"));
					 	s.setButacasporfila(rs.getInt("Butacasporfila"));
					 	aux.setSala(s);
					 	PeliculaEL p=new PeliculaEL();
					 	p.setTitulo(rs.getString("Titulo"));
					 	p.setDescripcion(rs.getString("Descripcion"));
					 	p.setGenero(rs.getString("Genero"));
					 	aux.setPelicula(p);
					 	aux.setFecha(rs.getDate("Fecha"));
					 	HorarioEL h=new HorarioEL();
					 	h.setHorario(rs.getTime("Horario"));
					 	h.setPrecio(rs.getDouble("Precio"));
					 	aux.setHorario(h);      
			            ListaRTA.put(aux.getIdFuncion(), aux);
			        }
			} catch (Exception e) {
				throw e;
			}finally {
				cn.close();
			}
	        return ListaRTA;
		}
		public FuncionesEL BuscarFuncion(int IdFuncion) throws Exception
	    {
			Connection cn = null;
	        FuncionesEL aux = null;
	        try {
	        	cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call sp_BuscarFuncion(?)}");
				cst.setInt(1, IdFuncion);
				ResultSet rs = cst.executeQuery();
				 while (rs.next())
			        {
					 aux = new FuncionesEL();
					 	aux.setIdFuncion(rs.getInt("idFuncion"));
					 	SalaEL s=new SalaEL();
					 	s.setIdSala(rs.getInt("IdSala"));
					 	s.setNombre(rs.getString("Nombre"));
					 	s.setFilas(rs.getInt("Filas"));
					 	s.setButacasporfila(rs.getInt("Butacasporfila"));
					 	aux.setSala(s);
					 	PeliculaEL p=new PeliculaEL();
					 	p.setTitulo(rs.getString("Titulo"));
					 	p.setDescripcion(rs.getString("Descripcion"));
					 	p.setGenero(rs.getString("Genero"));
					 	aux.setPelicula(p);
					 	aux.setFecha(rs.getDate("Fecha"));
					 	HorarioEL h=new HorarioEL();
					 	h.setHorario(rs.getTime("Horario"));
					 	h.setPrecio(rs.getDouble("Precio"));
					 	aux.setHorario(h);	   
			        }
			} catch (Exception e) {
				throw e;
			}finally {
				cn.close();
			}
	        return aux;
	    }
}
