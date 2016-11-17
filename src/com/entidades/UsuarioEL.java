package com.entidades;

public class UsuarioEL {
	private int idUsuario;
	private TipoEL Tipo;
	private PersonaEL Persona;
	private String login;
	private String password;
	private boolean estado;
	private String fechaRegistro;
	//PRUEBA GITHUB OCOLA
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public TipoEL getTipo() {
		return Tipo;
	}
	public void setTipo(TipoEL tipo) {
		Tipo = tipo;
	}
	public PersonaEL getPersona() {
		return Persona;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setPersona(PersonaEL persona) {
		Persona = persona;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
