package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
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
				cst.setInt(4,d.getCine().getIdCine());
				cst.setBoolean(5,d.isEstado());
				cst.executeUpdate();
				return true;
			} catch (Exception e) {
				throw e;
			}finally{cn.close();}		
		}
		
}
