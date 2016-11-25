package com.entidades;

import java.sql.Date;

public class FuncionesEL {
	private int IdFuncion;
	private SalaEL Sala;
	private PeliculaEL Pelicula;
	private HorarioEL Horario;
	private Date Fecha;
	private boolean Estado;
	private CineEL cine;
	
	public CineEL getCine() {
		return cine;
	}
	public void setCine(CineEL cine) {
		this.cine = cine;
	}
	public int getIdFuncion() {
		return IdFuncion;
	}
	public void setIdFuncion(int idFuncion) {
		IdFuncion = idFuncion;
	}
	public SalaEL getSala() {
		return Sala;
	}
	public void setSala(SalaEL sala) {
		Sala = sala;
	}
	public PeliculaEL getPelicula() {
		return Pelicula;
	}
	public void setPelicula(PeliculaEL pelicula) {
		Pelicula = pelicula;
	}
	public HorarioEL getHorario() {
		return Horario;
	}
	public void setHorario(HorarioEL horario) {
		Horario = horario;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}


}
