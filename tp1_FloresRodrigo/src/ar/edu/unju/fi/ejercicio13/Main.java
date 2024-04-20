package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arrayNumeros = new int[8];
		
		for(int i=0; i < arrayNumeros.length; i++) {
			System.out.print("Ingrese el numero para la posicion "+i+": ");
			arrayNumeros[i] = scanner.nextInt();
		}
		
		System.out.println("");
		System.out.println("*Valores que contiene el array*");
		for(int i=0; i < arrayNumeros.length; i++) {
			System.out.println("Indice del numero: "+i+", Valor: "+arrayNumeros[i]);
		}
		
		scanner.close();
	
	}
}
