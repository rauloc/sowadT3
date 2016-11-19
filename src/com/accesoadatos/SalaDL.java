package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.CineEL;
import com.entidades.SalaEL;

public class SalaDL {

	// Singleton
		public static SalaDL _Instancia;
		private SalaDL() {
		};
		public static SalaDL Instancia() {
			if (_Instancia == null) {
				_Instancia = new SalaDL();
			}
			return _Instancia;
		}
		// endSingleton
	
		
		public ArrayList<SalaEL> ListarSala(int idCine) throws Exception{
			Connection cn = null;
			ArrayList<SalaEL> lista = new ArrayList<SalaEL>();
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spListarSala(?)}");
				cst.setInt(1, idCine);
				ResultSet rs = cst.executeQuery();
				while (rs.next()) {
					SalaEL c = new SalaEL();
					c.setIdSala(rs.getInt("idSala"));
						CineEL u=new CineEL();
						u.setIdCine(rs.getInt("idCine"));
					c.setCine(u);	
					c.setNroSala(rs.getInt("nroSala"));
					lista.add(c);
				}			
			} catch (Exception e) {
				throw e;
			} finally {
				cn.close();
			}
			return lista;		
		}
}
