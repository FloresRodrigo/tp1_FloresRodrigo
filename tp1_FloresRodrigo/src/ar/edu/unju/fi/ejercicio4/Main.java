package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		int num;
		
		do{
			System.out.println("Ingrese un numero entero del 0 al 10: ");
			num = scanner.nextInt();
		}while(num <0 || num>10);
		
		int contador = 1;
		int resultado = 1;
		
		if(num == 0) {
			resultado = 0;
		} else {
			while(contador <= num) {
				resultado = resultado * contador;
				contador++;
			}
		}
		
		System.out.println("El factorial de "+num+" es: "+resultado);
		
		scanner.close();
	}

}
