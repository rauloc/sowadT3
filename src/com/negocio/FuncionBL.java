package com.negocio;

import java.util.Hashtable;

import com.accesoadatos.FuncionesDL;
import com.accesoadatos.PeliculaDL;
import com.entidades.FuncionesEL;

public class FuncionBL {
	///Singleton
		public static FuncionBL _Instancia;
		public FuncionBL(){};
		public static FuncionBL Instancia(){
			if(_Instancia==null){
				_Instancia = new FuncionBL();
			}
			return _Instancia;
		}
		//endSingleton
		public Hashtable ListadoFuncion(int id) throws Exception{
			try {
				Hashtable u=FuncionesDL.Instancia().ListarFuncionesPelicula(id);
				return u;
			} catch (Exception e) {
				throw e;
			}
		}
		public FuncionesEL BuscarFuncion(int IdFuncion) throws Exception
	    {
			try {
				FuncionesEL u=FuncionesDL.Instancia().BuscarFuncion(IdFuncion);
				return u;
			} catch (Exception e) {
				throw e;
			}
	    }
}
