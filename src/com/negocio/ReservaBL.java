package com.negocio;

import com.accesoadatos.CineDL;
import com.accesoadatos.ReservaDL;
import com.entidades.CineEL;
import com.entidades.ReservasEL;

public class ReservaBL {
	///Singleton
		public static ReservaBL _Instancia;
		public ReservaBL(){};
		public static ReservaBL Instancia(){
			if(_Instancia==null){
				_Instancia = new ReservaBL();
			}
			return _Instancia;
		}
		//endSingleton
	
	public boolean InsertarReserva(ReservasEL d) throws Exception{			
		try{								
			return ReservaDL.Instancia().InsertarReserva(d);
		}catch(Exception e){
			throw e;
		}			
	}
}
