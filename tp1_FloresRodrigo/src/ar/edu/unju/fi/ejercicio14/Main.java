package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num;
		do {
			System.out.print("Ingrese un valor entero del 3 al 10: ");
			num = scanner.nextInt();
		}while(num < 3 || num > 10);
		
		int[] arrayNumeros = new int[num];
		
		int total = 0;
		for(int i=0; i < arrayNumeros.length; i++) {
			System.out.print("Ingrese el numero para la posicion "+i+": ");
			arrayNumeros[i] = scanner.nextInt();
			total = total + arrayNumeros[i];
		}
		
		System.out.println("");
		System.out.println("*Valores que contiene el array*");
		for(int i=0; i < arrayNumeros.length; i++) {
			System.out.println("Indice del numero: "+i+", Valor: "+arrayNumeros[i]);
		}
		System.out.println("Suma de todos los valores en el array: "+total);
		
		scanner.close();
	}

}
