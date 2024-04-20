package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num;
		do {
			System.out.print("Ingrese un valor entero del 5 al 10: ");
			num = scanner.nextInt();
		}while(num < 5 || num > 10);
		
		String[] arrayString = new String[num];
		
		for(int i=0; i < arrayString.length; i++) {
			System.out.print("Ingrese el nombre de una persona para la posicion "+i+": ");
			arrayString[i] = scanner.next();
		}
		
		System.out.println("");
		System.out.println("*Valores que contiene el array*");
		for(int i=0; i < arrayString.length; i++) {
			System.out.println("Indice del valor: "+i+", Valor: "+arrayString[i]);
		}
		
		System.out.println("");
		System.out.println("*Valores que contiene el array en orden inverso*");
		for(int i = arrayString.length - 1; i >= 0; i--) {
			System.out.println("Indice del valor: "+i+", Valor: "+arrayString[i]);
		}

		scanner.close();
	}

}
