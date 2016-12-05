package com.negocio;

import com.accesoadatos.ButacaDL;
import com.accesoadatos.CiudadDL;
import com.entidades.CiudadEL;
import com.entidades.FuncionesEL;

public class ButacaBL {
	///Singleton
		public static ButacaBL _Instancia;
		public ButacaBL(){};
		public static ButacaBL Instancia(){
			if(_Instancia==null){
				_Instancia = new ButacaBL();
			}
			return _Instancia;
		}
		//endSingleton
		public boolean ButacaOcupada(FuncionesEL f, int Fila, int Columna) throws Exception{			
			try{								
				return ButacaDL.Instancia().ButacaOcupada(f, Fila, Columna);
			}catch(Exception e){
				throw e;
			}			
		}
}
