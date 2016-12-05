package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.entidades.CineEL;
import com.entidades.ReservasEL;

public class ReservaDL {
	// Singleton
			public static ReservaDL _Instancia;
			private ReservaDL() {
			};
			public static ReservaDL Instancia() {
				if (_Instancia == null) {
					_Instancia = new ReservaDL();
				}
				return _Instancia;
			}
			// endSingleton
			
			public boolean InsertarReserva(ReservasEL d) throws Exception{
				Connection cn = Conexion.Instancia().Conectar();
				try {
					CallableStatement cst = cn.prepareCall("{call sp_GuardarReserva(?,?,?,?,?,?,?,?)}");			
					cst.setTime(1, d.getHorario().getHorario());
					cst.setInt(2, d.getFuncion().getIdFuncion());
					cst.setInt(3,d.getSala().getIdSala());
					cst.setInt(4, d.getPelicula().getIdPelicula());
					cst.setInt(5, d.getUsuario().getIdUsuario());
					cst.setString(6, d.getNombre());
					cst.setDate(7, d.getFuncion().getFecha());
					cst.setInt(8, d.getPrecio());			
					cst.executeUpdate();
					return true;
				} catch (Exception e) {
					throw e;
				}finally{cn.close();}		
			}
}
