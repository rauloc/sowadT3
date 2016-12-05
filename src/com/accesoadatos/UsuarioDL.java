package com.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entidades.PeliculaEL;
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
						u.setEstado(rs.getBoolean("Estado"));
					}
					return u;
				} catch (Exception e) {
					throw e;
				} finally {
					cn.close();
				}
			}
			//walter insertarUsuario
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
			
			public Boolean InsertarUsuarioEmp(UsuarioEL p) throws Exception {
				Connection cn = null;
				Boolean inserto = false;
				try {
					cn = Conexion.Instancia().Conectar();
					CallableStatement cst = cn.prepareCall("{call sp_InsertarUsuarioEmp(?,?,?,?,?)}");
					cst.setString(1, p.getUsuario());
					cst.setString(2, p.getPassword());
					cst.setString(3, p.getNombre());
					cst.setString(4, p.getApellido());
					cst.setInt(5, p.getDNI());
					int i = cst.executeUpdate();
					if(i<0){ inserto=true;}
				} catch (Exception e) {
					throw e;
				} finally {
					cn.close();
				}
				return inserto;
			}	
			
			public ArrayList<UsuarioEL> ListarUsuarios() throws Exception{
				Connection cn = null;
				ArrayList<UsuarioEL> lista = new ArrayList<UsuarioEL>();
				try {
					cn = Conexion.Instancia().Conectar();
					CallableStatement cst = cn.prepareCall("{call spListarUsuarios()}");			
					ResultSet rs = cst.executeQuery();
					while (rs.next()) {
						UsuarioEL p = new UsuarioEL();
						p.setIdUsuario(rs.getInt("IdUsuario"));
						p.setUsuario(rs.getString("Usuario"));
						p.setPassword(rs.getString("Password"));
						p.setNombre(rs.getString("Nombre"));
						p.setApellido(rs.getString("Apellido"));
						p.setDNI(rs.getInt("DNI"));
						lista.add(p);
					}			
				} catch (Exception e) {
					throw e;
				} finally {
					cn.close();
				}
				return lista;		
			}
}
