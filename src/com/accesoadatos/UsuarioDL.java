package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.entidades.PersonaEL;
import com.entidades.UsuarioEL;

public class UsuarioDL {
	// Singleton
			public static UsuarioDL _Instancia;
			private UsuarioDL() {
			};
			public static UsuarioDL Instancia() {
				if (_Instancia == null) {
					_Instancia = new UsuarioDL();
				}
				return _Instancia;
			}
	// endSingleton
			public UsuarioEL VerificarAcceso(String _Usuario, String _Pass) throws Exception {
				Connection cn = null;
				UsuarioEL u = null;
				try {
					cn = Conexion.Instancia().Conectar();
					CallableStatement cst = cn.prepareCall("{call sp_VerificarAcceso(?,?)}");
					cst.setString(1, _Usuario);
					cst.setString(2, _Pass);
					ResultSet rs = cst.executeQuery();
					if (rs.next()) {
						u = new UsuarioEL();
						u.setIdUsuario(rs.getInt("idUsuario"));
						u.setLogin(rs.getString("login"));
						u.setEstado(rs.getBoolean("estado"));
						PersonaEL p=new PersonaEL();
						p.setNombres(rs.getString("nombres"));
						p.setApellidos(rs.getString("apellidos"));
						p.setDniPersona(rs.getString("dniPersona"));
						p.setSexo(rs.getString("Sexo"));
						u.setPersona(p);
					}
					return u;
				} catch (Exception e) {
					throw e;
				} finally {
					cn.close();
				}
			}
}
