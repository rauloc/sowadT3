package com.negocio;

import java.util.ArrayList;

import com.accesoadatos.SalaDL;
import com.entidades.SalaEL;

public class SalaBL {

	///Singleton
	public static SalaBL _Instancia;
	public SalaBL(){};
	public static SalaBL Instancia(){
		if(_Instancia==null){
			_Instancia = new SalaBL();
		}
		return _Instancia;
	}
	//endSingleton
	
	public ArrayList<SalaEL> ListarCiudad(int idCine) throws Exception{
		try{				
			return SalaDL.Instancia().ListarSala(idCine);
		}catch(Exception e){
			throw e;
		}
	}
	
	
}