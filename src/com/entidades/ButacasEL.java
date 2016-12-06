package com.entidades;

public class ButacasEL {
	private int IdButaca;
	private FuncionesEL Funcion;
	private int Fila;
	private int Columna;
	private int Estado;
	public int getIdButaca() {
		return IdButaca;
	}
	public void setIdButaca(int idButaca) {
		IdButaca = idButaca;
	}
	public FuncionesEL getFuncion() {
		return Funcion;
	}
	public void setFuncion(FuncionesEL funcion) {
		Funcion = funcion;
	}
	public int getFila() {
		return Fila;
	}
	public void setFila(int fila) {
		Fila = fila;
	}
	public int getColumna() {
		return Columna;
	}
	public void setColumna(int columna) {
		Columna = columna;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	
	 public ButacasEL(FuncionesEL oFuncion, int Fila, int Columna)
	    {        
	        setFuncion(oFuncion);
	        setFila(Fila);
	        setColumna(Columna);
	    }
}
