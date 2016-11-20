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
			public UsuarioEL VerificarAcceso(String _Usuario, String _Pass, int idTipo) throws Exception {
				Connection cn = null;
				UsuarioEL u = null;
				try {
					cn = Conexion.Instancia().Conectar();
					CallableStatement cst = cn.prepareCall("{call sp_VerificarAcceso(?,?,?)}");
					cst.setString(1, _Usuario);
					cst.setString(2, _Pass);
					cst.setInt(3, idTipo);
					ResultSet rs = cst.executeQuery();
					if (rs.next()) {
						u = new UsuarioEL();
						u.setIdUsuario(rs.getInt("idUsuario"));
						u.setLogin(rs.getString("login"));
						u.setEstado(rs.getBoolean("estado"));
						TipoEL t=new TipoEL();
						t.setIdTipo(rs.getInt("idTipo"));
						u.setTipo(t);
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
			public Boolean InsertarUsuario(UsuarioEL p) throws Exception {
				Connection cn = null;
				Boolean inserto = false;
				try {
					cn = Conexion.Instancia().Conectar();
					CallableStatement cst = cn.prepareCall("{call sp_InsertarPersona(?,?,?,?,?,?,?,?)}");
					cst.setString(1, p.getPersona().getNombres());
					cst.setString(2, p.getPersona().getApellidos());
					cst.setString(3, p.getPersona().getDniPersona());
					cst.setString(4, p.getPersona().getDireccion());
					cst.setString(5, p.getPersona().getFechaNacimiento());
					cst.setString(6, p.getPersona().getSexo());
					cst.setString(7, p.getLogin());
					cst.setString(8, p.getPassword());
					int i = cst.executeUpdate();
					if(i>0){ inserto=true;}
				} catch (Exception e) {
					throw e;
				} finally {
					cn.close();
				}
				return inserto;
			}

	//a esto decía men solo es
	//en la chamba no lo hacemos eso, por que eso genera conflicto, osea solo comiteamos al avance que hiciste
	//por ejemplo si hiciste en UsuarioDL, comiteas UsuarioDL,
	//ahora solo queda hacer d nuevo commitd manera q quede todo como antes...
	//ahora para solucionar, se podria hacer crear el index aquí y luego comitear solo esto
	//pera
						
}
