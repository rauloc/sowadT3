package com.entidades;

import java.sql.Date;
import java.sql.Time;

public class ReservasEL {
	private int IdReserva;
	private HorarioEL Horario;
	private FuncionesEL Funcion;
	private SalaEL Sala;
	private PeliculaEL Pelicula;
	private UsuarioEL Usuario;
	private String Nombre;
	private Date FechaReserva;
	private Date Fecha;
	private int Precio;
	private int Estado;
	
	
	
	public int getIdReserva() {
		return IdReserva;
	}
	public void setIdReserva(int idReserva) {
		IdReserva = idReserva;
	}
	public HorarioEL getHorario() {
		return Horario;
	}
	public void setHorario(HorarioEL horario) {
		Horario = horario;
	}
	public FuncionesEL getFuncion() {
		return Funcion;
	}
	public void setFuncion(FuncionesEL funcion) {
		Funcion = funcion;
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
	public UsuarioEL getUsuario() {
		return Usuario;
	}
	public void setUsuario(UsuarioEL usuario) {
		Usuario = usuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Date getFechaReserva() {
		return FechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		FechaReserva = fechaReserva;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	private Time Horarios;
	private int Funcionid;
	private int Salaid;
	private int Pelucilaid;
	private int Usuarioid;
	public int getUsuarioid() {
		return Usuarioid;
	}
	public void setUsuarioid(int usuarioid) {
		Usuarioid = usuarioid;
	}
	public Time getHorarios() {
		return Horarios;
	}
	public void setHorarios(Time horarios) {
		Horarios = horarios;
	}
	public int getFuncionid() {
		return Funcionid;
	}
	public void setFuncionid(int funcionid) {
		Funcionid = funcionid;
	}
	public int getSalaid() {
		return Salaid;
	}
	public void setSalaid(int salaid) {
		Salaid = salaid;
	}
	public int getPelucilaid() {
		return Pelucilaid;
	}
	public void setPelucilaid(int pelucilaid) {
		Pelucilaid = pelucilaid;
	}
	
}
