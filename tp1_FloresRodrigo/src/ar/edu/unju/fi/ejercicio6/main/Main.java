package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;



public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/* Con constructor por defecto */
		System.out.println("!**************************!");
		
		Persona personaDefect = new Persona();
		
		System.out.println("Ingrese su DNI: ");
		String dni = scanner.next();
		personaDefect.setDni(dni);
		
		System.out.println("Ingrese su Nombre: ");
		String nombre = scanner.next();
		personaDefect.setNombre(nombre);
		
		System.out.println("Ingrese su Fecha de Nacimiento (SOLAMENTE EN FORMATO DE YYYY-MM-DD): ");
		String fechaNaciminetoStr = scanner.next();
		LocalDate fechaNacimiento = LocalDate.parse(fechaNaciminetoStr);
		personaDefect.setFechaNac(fechaNacimiento);
		
		System.out.println("Ingrese su Provincia: ");
		String provincia = scanner.next();
		personaDefect.setProvincia(provincia);
		
		personaDefect.mostrarDatos();
		
		System.out.println("!**************************!");
		
		/* Con constructor parametrizado */
		System.out.println("!**************************!");
		
		Persona personaParam = new Persona(dni, nombre, fechaNacimiento, provincia);
		
		System.out.println("Ingrese su DNI: ");
		dni = scanner.next();
		personaParam.setDni(dni);
		
		System.out.println("Ingrese su Nombre: ");
		nombre = scanner.next();
		personaParam.setNombre(nombre);
		
		System.out.println("Ingrese su Fecha de Nacimiento (SOLAMENTE EN FORMATO DE YYYY-MM-DD): ");
		fechaNaciminetoStr = scanner.next();
		fechaNacimiento = LocalDate.parse(fechaNaciminetoStr);
		personaParam.setFechaNac(fechaNacimiento);
		
		System.out.println("Ingrese su Provincia: ");
		provincia = scanner.next();
		personaParam.setProvincia(provincia);
		
		personaParam.mostrarDatos();
		
		System.out.println("!**************************!");
		
		/* Con constructor solo con los 3 primeros atributos */
		
		Persona personaTresAtributos = new Persona(dni, nombre, fechaNacimiento);
		
		System.out.println("Ingrese su DNI: ");
		dni = scanner.next();
		personaTresAtributos.setDni(dni);
		
		System.out.println("Ingrese su Nombre: ");
		nombre = scanner.next();
		personaTresAtributos.setNombre(nombre);
		
		System.out.println("Ingrese su Fecha de Nacimiento (SOLAMENTE EN FORMATO DE YYYY-MM-DD): ");
		fechaNaciminetoStr = scanner.next();
		fechaNacimiento = LocalDate.parse(fechaNaciminetoStr);
		personaTresAtributos.setFechaNac(fechaNacimiento);
		
		personaTresAtributos.mostrarDatos();
		
		System.out.println("!**************************!");
		
		scanner.close();
	}
	
}
