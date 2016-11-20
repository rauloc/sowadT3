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
		public UsuarioEL VerificarAcceso(String _Usuario, String _Pass) 
				throws Exception{
			try {
				UsuarioEL u = UsuarioDL.Instancia().VerificarAcceso(_Usuario, _Pass);
				if(u==null){
					throw new ArithmeticException("Usuario o Password no valido!");
				}
				if(u.getTipo().getIdTipo()!=1){
						throw new ArithmeticException("Usuario no valido para esta accion");
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

	