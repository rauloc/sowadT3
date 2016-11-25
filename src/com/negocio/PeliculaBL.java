package com.negocio;

import com.accesoadatos.PeliculaDL;
import com.accesoadatos.UsuarioDL;
import com.entidades.PeliculaEL;
import com.entidades.UsuarioEL;

public class PeliculaBL {
	///Singleton
	public static PeliculaBL _Instancia;
	public PeliculaBL(){};
	public static PeliculaBL Instancia(){
		if(_Instancia==null){
			_Instancia = new PeliculaBL();
		}
		return _Instancia;
	}
	//endSingleton
	public PeliculaEL BuscarPelicula(int IdPelicula) 
			throws Exception{
		try {
			PeliculaEL u = PeliculaDL.Instancia().BuscarPelicula(IdPelicula);
			return u;
		} catch (Exception e) {
			throw e;
		}
	}
}
