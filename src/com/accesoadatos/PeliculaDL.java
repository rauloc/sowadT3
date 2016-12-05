package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.entidades.CineEL;
import com.entidades.FuncionesEL;
import com.entidades.HorarioEL;
import com.entidades.PeliculaEL;
import com.entidades.SalaEL;

public class PeliculaDL {
	// Singleton
		public static PeliculaDL _Instancia;
		private PeliculaDL() {
		};
		public static PeliculaDL Instancia() {
			if (_Instancia == null) {
				_Instancia = new PeliculaDL();
			}
			return _Instancia;
		}
		// endSingleton
		
		public ArrayList<PeliculaEL> ListarPeliculas() throws Exception{
			Connection cn = null;
			ArrayList<PeliculaEL> lista = new ArrayList<PeliculaEL>();
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spListarPeliculas()}");			
				ResultSet rs = cst.executeQuery();
				while (rs.next()) {
					PeliculaEL p = new PeliculaEL();
					p.setTitulo(rs.getString("Titulo"));
					p.setDescripcion(rs.getString("Descripcion"));
					p.setGenero(rs.getString("Genero"));
					p.setImagen(rs.getString("Imagen"));
					p.setEstado(rs.getBoolean("Estado"));
					lista.add(p);
				}			
			} catch (Exception e) {
				throw e;
			} finally {
				cn.close();
			}
			return lista;		
		}
		
		public boolean InsertarPelicula(PeliculaEL p) throws Exception{
			Connection cn = Conexion.Instancia().Conectar();
			try {
				CallableStatement cst = cn.prepareCall(
						"{call sp_InsertarPelicula(?,?,?,?,?)}");			
				cst.setString(1, p.getTitulo());
				cst.setString(2, p.getDescripcion());
				cst.setString(3, p.getGenero());
				cst.setString(4, p.getImagen());
				cst.setBoolean(5,p.isEstado());
				cst.executeUpdate();
				return true;
			} catch (Exception e) {
				throw e;
			}finally{cn.close();}		
		}
		
		public PeliculaEL BuscarPelicula(int IdPelicula) throws Exception{
			Connection cn = null;
			PeliculaEL p = null;
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call sp_BuscarPelicula(?)}");
				cst.setInt(1, IdPelicula);
				ResultSet rs = cst.executeQuery();
				while (rs.next())
		        {
		            p = new PeliculaEL();
		            p.setIdPelicula(rs.getInt("IdPelicula"));
		            p.setTitulo(rs.getString("Titulo"));
		            p.setDescripcion(rs.getString("Descripcion"));
		            p.setGenero(rs.getString("Genero"));
		            p.setImagen(rs.getString("Imagen"));
		            p.setIdVideo(rs.getString("IdVideo"));
		        }
			} catch (Exception e) {
				throw e;
			}finally {
				cn.close();
			}
			return p;
		}
		//Listado de peliculas Ramos
		
		public Hashtable ListadoPelicula() throws  Exception{
			Connection cn = null;
			Hashtable ListaRTA = new Hashtable();
	        PeliculaEL aux = null;
	        try {
	        	cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spListadoPeliculas()}");
				ResultSet rs = cst.executeQuery();
				 while (rs.next())
			        {
			            aux = new PeliculaEL();
			            aux.setIdPelicula(rs.getInt("IdPelicula"));
			            aux.setTitulo(rs.getString("Titulo"));
			            //aux.setDescripcion(rs.getString("Descripcion"));
			            aux.setGenero(rs.getString("Genero"));
			            ListaRTA.put(aux.getIdPelicula(), aux);
			        }
			} catch (Exception e) {
				// TODO: handle exception
			}
	        return ListaRTA;
		}
}
