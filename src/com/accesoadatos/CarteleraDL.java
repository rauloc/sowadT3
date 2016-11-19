package com.accesoadatos;

public class CarteleraDL {

	// Singleton
				public static CarteleraDL _Instancia;
				private CarteleraDL() {
				};
				public static CarteleraDL Instancia() {
					if (_Instancia == null) {
						_Instancia = new CarteleraDL();
					}
					return _Instancia;
				}
		// endSingleton
	
}
