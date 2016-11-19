package com.negocio;

import java.util.ArrayList;

import com.accesoadatos.CiudadDL;
import com.entidades.CiudadEL;

public class CiudadBL {

	///Singleton
	public static CiudadBL _Instancia;
	public CiudadBL(){};
	public static CiudadBL Instancia(){
		if(_Instancia==null){
			_Instancia = new CiudadBL();
		}
		return _Instancia;
	}
	//endSingleton
	
	public ArrayList<CiudadEL> ListarCiudad() throws Exception{
		try{				
			return CiudadDL.Instancia().ListarCiudad();
		}catch(Exception e){
			throw e;
		}
	}
	
	
}
