package ar.edu.unju.fi.ejercicio17.model;

import java.time.LocalDate;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private static final String[] posiciones = { "Delantero", "Medio", "Defensa", "Arquero" };
	private String posicion;

	public Jugador() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public static String[] getPosiciones() {
		return posiciones;
	}

	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();

		int edad = fechaActual.getYear() - fechaNac.getYear();
		
		if (fechaNac.getMonthValue() > fechaActual.getMonthValue() || 
				(fechaNac.getMonthValue() == fechaActual.getMonthValue() && 
				fechaNac.getDayOfMonth() > fechaActual.getDayOfMonth())) {
		edad--;
		}

		return edad;
	}
	
}
