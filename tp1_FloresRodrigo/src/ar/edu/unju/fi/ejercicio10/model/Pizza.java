package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
	private int diametro;
	private int precio;
	private double area;
	private boolean ingredientesEspeciales;
	private static final int ingredientesEspeciales20 = 500;
	private static final int ingredientesEspeciales30 = 750;
	private static final int ingredientesEspeciales40 = 1000;
	
	public int getDiametro() {
		return diametro;
	}
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public boolean isIngredientesEspeciales() {
		return ingredientesEspeciales;
	}
	public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
		this.ingredientesEspeciales = ingredientesEspeciales;
	}
	public static int getIngredientesespeciales20() {
		return ingredientesEspeciales20;
	}
	public static int getIngredientesespeciales30() {
		return ingredientesEspeciales30;
	}
	public static int getIngredientesesoeciales40() {
		return ingredientesEspeciales40;
	}
	
	public Pizza() {
		super();
	}
	
	public void calcularPrecio() {
		if (diametro == 20) {
			if (ingredientesEspeciales) {
				precio = 4500 + ingredientesEspeciales20;
			} else {
				precio = 4500;
			}
		} else if (diametro == 30) {
			if (ingredientesEspeciales) {
				precio = 4800 + ingredientesEspeciales30;
			} else {
				precio = 4800;
			}
		} else if (diametro == 40) {
			if (ingredientesEspeciales) {
				precio = 5500 + ingredientesEspeciales40;
			} else {
				precio = 5500;
			}
		}
	}
	
	public void calcularArea() {
		int radio = diametro / 2;
		area = Math.PI * Math.pow(radio, 2);
	}
	
}
