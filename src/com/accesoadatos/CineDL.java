package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.CineEL;
import com.entidades.CiudadEL;
import com.entidades.SalaEL;

public class CineDL {

	// Singleton
	public static CineDL _Instancia;
	private CineDL() {
	};
	public static CineDL Instancia() {
		if (_Instancia == null) {
			_Instancia = new CineDL();
		}
		return _Instancia;
	}
	// endSingleton
	
	
	public ArrayList<CineEL> ListarCine(int idCiudad) throws Exception{
		Connection cn = null;
		ArrayList<CineEL> lista = new ArrayList<CineEL>();
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call spListarCine(?)}");
			cst.setInt(1, idCiudad);
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				CineEL c = new CineEL();
				c.setIdCine(rs.getInt("idCine"));
					CiudadEL u=new CiudadEL();
					u.setIdCiudad(rs.getInt("idCiudad"));
				c.setCiudad(u);	
				c.setNombreCine(rs.getString("nombreCine"));
				c.setDireccionCine(rs.getString("direccionCine"));
				lista.add(c);
			}			
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
		}
		return lista;		
	}
	
	public boolean InsertarCine(CineEL d) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		try {
			CallableStatement cst = cn.prepareCall(
					"{call sp_InsertarCine(?,?,?)}");			
			cst.setInt(1, d.getCiudad().getIdCiudad());
			cst.setString(2, d.getNombreCine());
			cst.setString(3, d.getDireccionCine());			
			cst.executeUpdate();
			return true;
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}		
	}
	
}
