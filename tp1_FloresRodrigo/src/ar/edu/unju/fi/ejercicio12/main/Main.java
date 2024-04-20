package ar.edu.unju.fi.ejercicio12.main;

import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese el nombre de una persona: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese la fecha de nacimiento de la persona (en formato de dd/mm/yyyy o dd-mm-yyyy): ");
		String fechaNacString = scanner.next();
		
		int dia = Integer.parseInt(fechaNacString.substring(0, 2));
		int mes = Integer.parseInt(fechaNacString.substring(3, 5)) - 1;
		int anio = Integer.parseInt(fechaNacString.substring(6));
		
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.set(anio, mes, dia);
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setFechaNac(fechaNac);
		
		System.out.println("");
		System.out.println("Nombre: "+persona.getNombre());
		System.out.println("Fecha de nacimiento: "+fechaNacString);
		System.out.println("Edad: "+persona.obtenerEdad());
		System.out.println("Signo del zodiaco: "+persona.obtenerSigno());
		System.out.println("Estacion: "+persona.obtenerEstacion());
		
		scanner.close();
	}

}
