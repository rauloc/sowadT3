package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.entidades.PersonaEL;
import com.entidades.TipoEL;
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
						u.setIdUsuario(rs.getInt("IdUsuario"));
						u.setUsuario(rs.getString("Usuario"));
						u.setNombre(rs.getString("Nombre"));
						u.setApellido(rs.getString("Apellido"));
						u.setDNI(rs.getInt("DNI"));
						u.setTipoUsuario(rs.getString("TipoUsuario"));
					}
					return u;
				} catch (Exception e) {
					throw e;
				} finally {
					cn.close();
				}
			}
			
			public Boolean InsertarUsuario(UsuarioEL p) throws Exception {
				Connection cn = null;
				Boolean inserto = false;
				try {
					cn = Conexion.Instancia().Conectar();
					CallableStatement cst = cn.prepareCall("{call sp_InsertarUsuario(?,?,?,?,?)}");
					cst.setString(1, p.getUsuario());
					cst.setString(2, p.getPassword());
					cst.setString(3, p.getNombre());
					cst.setString(4, p.getApellido());
					cst.setInt(5, p.getDNI());
					int i = cst.executeUpdate();
					if(i>0){ inserto=true;}
				} catch (Exception e) {
					throw e;
				} finally {
					cn.close();
				}
				return inserto;
			}			
}
