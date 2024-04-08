package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private String dni;
	private String nombre;
	private LocalDate fechaNac;
	private String provincia;
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int calcularEdad() {
		LocalDate añoActual = LocalDate.now();
		Period tiempoTranscurrido = Period.between(fechaNac, añoActual);
		return tiempoTranscurrido.getYears();
	}
	
	public boolean verificarEdad() {
		if(this.calcularEdad() > 18) {
			return true;
		} else {
			return false;
		}
	}
	
	public void mostrarDatos() {
		System.out.println("DNI: "+this.dni);
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Fecha de Nacimiento: "+this.fechaNac);
		System.out.println("Provincia: "+this.provincia);
		
		int edad = calcularEdad();
		System.out.println("Edad: "+edad+" años");
		
		if(verificarEdad()) {
			System.out.println("La persona es mayor de edad");
		} else {
			System.out.println("La persona no es mayor de edad");
		}
	}
	
	public Persona() {
		
	}
	
	public Persona(String dni, String nombre, LocalDate fechaNac, String provincia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.provincia = provincia;
	}

	public Persona(String dni, String nombre, LocalDate fechaNac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.provincia = "Jujuy";
	}
	
	
}
