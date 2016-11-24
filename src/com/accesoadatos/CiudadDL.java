package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.CiudadEL;
import com.entidades.SalaEL;

public class CiudadDL {

	// Singleton
	public static CiudadDL _Instancia;
	private CiudadDL() {
	};
	public static CiudadDL Instancia() {
		if (_Instancia == null) {
			_Instancia = new CiudadDL();
		}
		return _Instancia;
	}
	// endSingleton

		public ArrayList<CiudadEL> ListarCiudad() throws Exception{
			Connection cn = null;
			ArrayList<CiudadEL> lista = new ArrayList<CiudadEL>();
			try {
				cn = Conexion.Instancia().Conectar();
				CallableStatement cst = cn.prepareCall("{call spListarCiudad()}");
				ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				CiudadEL u = new CiudadEL();
				u.setIdCiudad(rs.getInt("idCiudad"));
				u.setNombre(rs.getString("nombre"));
				lista.add(u);
			}			
			} catch (Exception e) {
				throw e;
			} finally {
				cn.close();
			}
			return lista;		
		}
		
		public boolean InsertarCiudad(CiudadEL d) throws Exception{
			Connection cn = Conexion.Instancia().Conectar();
			try {
				CallableStatement cst = cn.prepareCall(
						"{call sp_InsertarCiudad(?)}");			
				cst.setString(1, d.getNombre());
				cst.executeUpdate();
				return true;
			} catch (Exception e) {
				throw e;
			}finally{cn.close();}		
		}
	
	
}
