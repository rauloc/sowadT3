package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Time;

import com.entidades.HorarioEL;
import com.entidades.SalaEL;

public class HorarioDL {
	// Singleton
	public static HorarioDL _Instancia;
	private HorarioDL() {
	};
	public static HorarioDL Instancia() {
		if (_Instancia == null) {
			_Instancia = new HorarioDL();
		}
		return _Instancia;
	}
// endSingleton
	public HorarioEL BuscarHorario(Time Horario) throws Exception{
		Connection cn = null;
		HorarioEL h = null;
		try {
			cn = Conexion.Instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_sp_BuscarHorario(?)}");
			cst.setTime(1, Horario);
			ResultSet rs = cst.executeQuery();
			while (rs.next())
	        {
	            h = new HorarioEL();
	            h.setHorario(rs.getTime("Horario"));
	            h.setPrecio(rs.getDouble("Precio"));
	        }
		} catch (Exception e) {
			throw e;
		}finally {
			cn.close();
		}
		return h;
	}
}
