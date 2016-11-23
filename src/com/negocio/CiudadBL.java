package com.negocio;

import java.util.ArrayList;

import com.accesoadatos.CiudadDL;
import com.accesoadatos.SalaDL;
import com.entidades.CiudadEL;
import com.entidades.SalaEL;

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
	
	public boolean InsertarCiudad(CiudadEL d) throws Exception{			
		try{								
			return CiudadDL.Instancia().InsertarCiudad(d);
		}catch(Exception e){
			throw e;
		}			
	}
	
}
