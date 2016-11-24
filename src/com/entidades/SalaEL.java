package com.entidades;

public class SalaEL {
	private int idSala;
	private String Nombre;
	private int Filas;
	private int Butacasporfila;
	private CineEL cine;
	private boolean Estado;
	
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getFilas() {
		return Filas;
	}
	public void setFilas(int filas) {
		Filas = filas;
	}
	public int getButacasporfila() {
		return Butacasporfila;
	}
	public void setButacasporfila(int butacasporfila) {
		Butacasporfila = butacasporfila;
	}
	public CineEL getCine() {
		return cine;
	}
	public void setCine(CineEL cine) {
		this.cine = cine;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	@Override
	public String toString() {
		return "SalaEL [idSala=" + idSala + ", Nombre=" + Nombre + ", Filas=" + Filas + ", Butacasporfila="
				+ Butacasporfila + ", cine=" + cine + ", Estado=" + Estado + "]";
	}
	
	
	

}
