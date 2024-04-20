package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] arrayString = new String[5];
		
		for(int i=0; i < arrayString.length; i++) {
			System.out.print("Ingrese el nombre de una persona para la posicion "+i+": ");
			arrayString[i] = scanner.nextLine();
		}
		
		System.out.println("");
		System.out.println("*Valores que contiene el array*");
		int i = 0;
		while(i < arrayString.length) {
			System.out.println("Indice del valor: "+i+", Valor: "+arrayString[i]);
			i++;
		}
		System.out.println("TAMANIO DEL ARRAY: "+arrayString.length);
		
		byte j;
		do {
			System.out.print("Ingrese el indice del elemento que desea borrar en el array: [0, 4]: ");
			j = scanner.nextByte();
		}while(j < 0 || j > 4);
		
		for(byte k = j; k < arrayString.length - 1; k++) {
			arrayString[k] = arrayString[k+1];
		}
		arrayString[4] = "";
		
		System.out.println("");
		System.out.println("*Valores que contiene el array*");
		i = 0;
		while(i < arrayString.length) {
			System.out.println("Indice del valor: "+i+", Valor: "+arrayString[i]);
			i++;
		}
		System.out.println("TAMANIO DEL ARRAY: "+arrayString.length);
		
		scanner.close();

	}

}
