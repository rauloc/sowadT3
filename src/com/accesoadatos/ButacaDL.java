package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.entidades.ButacasEL;
import com.entidades.FuncionesEL;

public class ButacaDL {
	// Singleton
			public static ButacaDL _Instancia;
			private ButacaDL() {
			};
			public static ButacaDL Instancia() {
				if (_Instancia == null) {
					_Instancia = new ButacaDL();
				}
				return _Instancia;
			}
		// endSingleton
			public void ReservarButaca(ButacasEL b) throws Exception
		    {
				Connection cn = Conexion.Instancia().Conectar();
				try {
					CallableStatement cst = cn.prepareCall("{call sp_ReservarAsiento(?,?,?)}");
					cst.setInt(1, b.getFuncion().getIdFuncion());
					cst.setInt(2, b.getFila());
					cst.setInt(3, b.getColumna());
					cst.executeUpdate();
				} catch (Exception e) {
					throw e;
				}finally{cn.close();}
				
		    }
			public Boolean ButacaReservada(FuncionesEL f, int Fila, int Columna) throws Exception
		    {
				Boolean rta = false;
				Connection cn = null;
				try {
					cn = Conexion.Instancia().Conectar();
					CallableStatement cst = cn.prepareCall("{call sp_Reservado(?,?,?)}");
					cst.setInt(1, f.getIdFuncion());
					cst.setInt(2, Fila);
					cst.setInt(3, Columna);
					ResultSet rs = cst.executeQuery();
					while (rs.next()) {
						rta = true;
					}
					return rta;
				} catch (Exception e) {
					throw e;
				}finally{cn.close();}
		    }
			
}
