package com.entidades;

public class CiudadEL {

	private int idCiudad;
	private String nombre;
	
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "CiudadEL [idCiudad=" + idCiudad + ", nombre=" + nombre + "]";
	}
	
	
}
