package com.negocio;

import java.sql.Time;

import com.accesoadatos.HorarioDL;
import com.accesoadatos.SalaDL;
import com.entidades.HorarioEL;
import com.entidades.SalaEL;

public class HorarioBL {
	//Singleton
	public static HorarioBL _Instancia;
	private HorarioBL(){};
	public static HorarioBL Instancia(){
		if(_Instancia==null){
			_Instancia = new HorarioBL();
		}
		return _Instancia;
	}
	//endSingleton
	public HorarioEL BuscarHorario(Time Horario) 
			throws Exception{
		try {
			HorarioEL u = HorarioDL.Instancia().BuscarHorario(Horario);
			return u;
		} catch (Exception e) {
			throw e;
		}
	}
}
