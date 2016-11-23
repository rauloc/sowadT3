package com.negocio;

import java.util.ArrayList;

import com.accesoadatos.CineDL;
import com.accesoadatos.CiudadDL;
import com.entidades.CineEL;
import com.entidades.CiudadEL;

public class CineBL {

	///Singleton
		public static CineBL _Instancia;
		public CineBL(){};
		public static CineBL Instancia(){
			if(_Instancia==null){
				_Instancia = new CineBL();
			}
			return _Instancia;
		}
		//endSingleton
		
		public ArrayList<CineEL> ListarCiudad(int idCiudad) throws Exception{
			try{				
				return CineDL.Instancia().ListarCine(idCiudad);
			}catch(Exception e){
				throw e;
			}
		}
		
		public boolean InsertarCine(CineEL d) throws Exception{			
			try{								
				return CineDL.Instancia().InsertarCine(d);
			}catch(Exception e){
				throw e;
			}			
		}
	
}
