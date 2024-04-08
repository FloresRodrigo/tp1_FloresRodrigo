package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		int num;
		
		do{
			System.out.println("Ingrese un numero entero del 1 al 9: ");
			num = scanner.nextInt();
		}while(num <1 || num>9);
		
		scanner.close();
		
		int i;
		
		for(i=1;i<=10;i++) {
			System.out.println("El resultado de "+num+"*"+i+" es: "+num*i);
		}
		
	}
	
}