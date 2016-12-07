package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.entidades.PeliculaEL;
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
			public boolean InsertarReserva(ReservasEL r) throws Exception{
				Connection cn = Conexion.Instancia().Conectar();
				try {
					CallableStatement cst = cn.prepareCall("{call sp_GuardarReserva(?,?,?,?,?,?)}");			
					cst.setTime(1, r.getHorarios());
					cst.setInt(2, r.getFuncionid());
					cst.setInt(3, r.getSalaid());
					cst.setInt(4, r.getPelucilaid());
					cst.setInt(5, r.getUsuarioid());
					cst.setInt(6,r.getPrecio());
					cst.executeUpdate();
					return true;
				} catch (Exception e) {
					throw e;
				}finally{cn.close();}		
			}
}
