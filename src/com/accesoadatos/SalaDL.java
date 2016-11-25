package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

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
	
		public boolean InsertarSala(SalaEL d) throws Exception{
			Connection cn = Conexion.Instancia().Conectar();
			try {
				CallableStatement cst = cn.prepareCall(
						"{call sp_InsertarSala(?,?,?,?,?)}");			
				cst.setString(1, d.getNombre());
				cst.setInt(2, d.getFilas());
				cst.setInt(3, d.getButacasporfila());				
				cst.setBoolean(4,d.isEstado());
				cst.setInt(5,d.getCine().getIdCine());
				cst.executeUpdate();
				return true;
			} catch (Exception e) {
				throw e;
			}finally{cn.close();}		
		}
		
		public SalaEL BuscarSala(int IdSala) throws Exception{
			Connection cn = null;
			SalaEL s = null;
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call sp_BuscarSala(?)}");
				cst.setInt(1, IdSala);
				ResultSet rs = cst.executeQuery();
				while (rs.next())
		        {
		            s = new SalaEL();
		            s.setIdSala(rs.getInt("IdSala"));
		            s.setNombre(rs.getString("Nombre"));
		            s.setFilas(rs.getInt("Filas"));
		            s.setButacasporfila(rs.getInt("Butacasporfila"));
		        }
			} catch (Exception e) {
				throw e;
			}finally {
				cn.close();
			}
			return s;
		}
		
}
