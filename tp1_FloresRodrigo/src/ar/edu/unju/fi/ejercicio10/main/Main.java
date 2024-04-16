package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int diametro;
		boolean diametroValido = false;
		boolean ingredientesEspeciales;
		
		for(int i = 1; i<=3; i++) {
			System.out.println("Pizza n°"+i+": ");
			
			do {
				System.out.print("Ingrese el diametro de la pizza (Solamente 20, 30 o 40): ");
				diametro = scanner.nextInt();
				
				if(diametro != 20 && diametro != 30 && diametro != 40) {
					System.out.println("El diametro ingresado no es correcto.");
					diametroValido = false;
				} else {
					diametroValido = true;
				}
			}while(!diametroValido);
			
			System.out.print("La pizza tiene ingredientes especiales? (true para si/false para no): ");
			ingredientesEspeciales = scanner.nextBoolean();
			
			Pizza pizza = new Pizza();
			pizza.setDiametro(diametro);
			pizza.setIngredientesEspeciales(ingredientesEspeciales);
			pizza.calcularPrecio();
			pizza.calcularArea();
			
			System.out.println("");
			System.out.println("-------------------------------");
			System.out.println("** Pizza "+i+" **");
			System.out.println("Diametro = "+pizza.getDiametro());
			System.out.println("Ingredientes especiales = "+pizza.isIngredientesEspeciales());
			System.out.println("Precio Pizza = "+pizza.getPrecio()+"$");
			System.out.println("Area de la pizza = "+pizza.getArea());
			System.out.println("-------------------------------");
			System.out.println("");
			
		}
		scanner.close();
	}

}
