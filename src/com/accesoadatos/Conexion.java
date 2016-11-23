package com.accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	//Singleton
			public static Conexion _Instancia;
			private Conexion(){};
			public static Conexion Instancia(){
				if(_Instancia==null){
					_Instancia = new Conexion();
				}
				return _Instancia;
			}
	//endSingleton
			//arredlando 
			public Connection Conectar() throws Exception{
				Connection cn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					/*cn = DriverManager.getConnection("jdbc:sqlserver://.;"+
							"databaseName=BD_Cine", "sa", "123456");*/
					
					cn = DriverManager.getConnection("jdbc:sqlserver://sowad4471.cloudapp.net:1433;"+
					"databaseName=BD_Cine", "sa", "123456T2sowad");
					
				} catch (Exception e) {
					throw e;
				}
				return cn;
			}

}
