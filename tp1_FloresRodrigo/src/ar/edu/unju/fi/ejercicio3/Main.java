package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un numero entero: ");
		
		int  num;
		
		num = scanner.nextInt();
		scanner.close();
		
		if((num % 2) == 0) {
			num = num * 2;
		} else {
			num = num *3;
		}
		
		System.out.println("Resultado: "+num);
	}

}
