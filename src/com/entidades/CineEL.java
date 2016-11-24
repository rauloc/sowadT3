package com.entidades;

public class CineEL {
	private int idCine;
	private CiudadEL ciudad;
	private String nombreCine;
	private String direccionCine;
	
	public int getIdCine() {
		return idCine;
	}
	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}	
	public String getNombreCine() {
		return nombreCine;
	}
	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}
	public String getDireccionCine() {
		return direccionCine;
	}
	public void setDireccionCine(String direccionCine) {
		this.direccionCine = direccionCine;
	}
	public CiudadEL getCiudad() {
		return ciudad;
	}
	public void setCiudad(CiudadEL ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "CineEL [idCine=" + idCine + ", ciudad=" + ciudad + ", nombreCine=" + nombreCine + ", direccionCine="
				+ direccionCine + "]";
	}
	
	

}
