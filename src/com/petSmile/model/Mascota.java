package com.petSmile.model;

import java.sql.Date;

public class Mascota {
	private int idMascota;
	private String rutDueno;
	private String nombreMascota;
	private Date creado;
	public Mascota(int idMascota, String rutDueno, String nombreMascota, Date creado) {
		super();
		this.idMascota = idMascota;
		this.rutDueno = rutDueno;
		this.nombreMascota = nombreMascota;
		this.creado = creado;
	}
	public Mascota() {
		super();
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getRutDueno() {
		return rutDueno;
	}
	public void setRutDueno(String rutDueno) {
		this.rutDueno = rutDueno;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Date creado) {
		this.creado = creado;
	}
	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", rutDueno=" + rutDueno + ", nombreMascota=" + nombreMascota
				+ ", creado=" + creado + "]";
	}
	
	

}
