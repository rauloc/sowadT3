package com.negocio;

import com.accesoadatos.UsuarioDL;
import com.entidades.UsuarioEL;

public class UsuarioBL {
	//Singleton
		public static UsuarioBL _Instancia;
		private UsuarioBL(){};
		public static UsuarioBL Instancia(){
			if(_Instancia==null){
				_Instancia = new UsuarioBL();
			}
			return _Instancia;
		}
	//endSingleton
		public UsuarioEL VerificarAcceso(String _Usuario, String _Pass, int idTipo) 
				throws Exception{
			try {
				UsuarioEL u = UsuarioDL.Instancia().VerificarAcceso(_Usuario, _Pass,idTipo);
				if(u==null){
					throw new ArithmeticException("Usuario o Password no valido!");

			}else if(!u.isEstado()){
				throw new ArithmeticException("Su usuario ha sido dado de baja!");
			}				return u;
			} catch (Exception e) {
				throw e;
			}
		}

		//CORREGIDO
		public Boolean InsertarUsuario(UsuarioEL p) throws Exception {
			try {
				return UsuarioDL.Instancia().InsertarUsuario(p);
			} catch (Exception e) {
				throw e;
			}
		}

}

	