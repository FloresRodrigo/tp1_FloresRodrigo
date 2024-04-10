package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 1; i <= 3; i++) {
			System.out.println("Ingrese los datos del producto " + i + ":");
			Producto producto = new Producto();
			
			System.out.println("Nombre: ");
			producto.setNombre(scanner.next());

            System.out.println("Codigo: ");
            producto.setCodigo(scanner.next());

            System.out.println("Precio: ");
            producto.setPrecio(scanner.nextFloat());
            
			int descuento;
			do {
				System.out.println("Descuento (%) entre el 0 y el 50: ");
				descuento = scanner.nextInt();
			} while (descuento < 0 || descuento > 50);
			producto.setDescuento(descuento);
			
			System.out.println("*----------------------*");
			System.out.println("Datos del producto "+i+": ");
			System.out.println("Nombre: "+producto.getNombre());
			System.out.println("Codigo: "+producto.getCodigo());
			System.out.println("Precio: "+producto.getPrecio());
			System.out.println("Descuento: "+producto.getDescuento()+"%");
			System.out.println("Precio con descuento del producto: "+producto.calcularDescuento());
			System.out.println("*----------------------*");
		}
		scanner.close();
	}
}
