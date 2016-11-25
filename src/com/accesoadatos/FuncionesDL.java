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
		public Hashtable ListarFuncionesPelicula(CineEL cine) throws Exception{
			Connection cn = null;
			Hashtable ListaRTA = new Hashtable();
	        FuncionesEL aux = null;
	        try {
	        	cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call sp_BuscarSala(?)}");
				cst.setInt(1, cine.getIdCine());
				ResultSet rs = cst.executeQuery();
				 while (rs.next())
			        {
					 SalaDL a=null;
			            SalaEL ss = SalaDL.Instancia().BuscarSala(rs.getInt("IdSala"));
			            PeliculaEL  p = PeliculaDL.Instancia().BuscarPelicula(rs.getInt("IdPelicula"));
			            HorarioEL h =(HorarioEL) HorarioDL.Instancia().BuscarHorario(rs.getTime("Horario")); 
			           
			           // aux = new FuncionesEL(rs.getInt("IdFuncion"), oSala, oPelicula, oHorario, Resultado.getDate("Fecha"));*/
			            ListaRTA.put(aux.getIdFuncion(), aux);
			        }
			} catch (Exception e) {
				// TODO: handle exception
			}
	        return ListaRTA;
		}
}
