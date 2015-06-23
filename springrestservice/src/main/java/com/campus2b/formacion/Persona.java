package com.campus2b.formacion;

public class Persona {
	private int id;
	private String direccion;
	private String nombre;
	
	
	public Persona() {
		super();
		this.setId(0);
		this.setNombre("");
		this.setDireccion("");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
