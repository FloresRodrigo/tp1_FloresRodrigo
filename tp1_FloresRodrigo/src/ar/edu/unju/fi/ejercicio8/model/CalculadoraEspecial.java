package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
	private int n;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public CalculadoraEspecial() {
		super();
	}

	public double calcularSumatoria() {
		double sumatoria = 0.0;
        for (int k = 1; k <= n; k++) {
            sumatoria = sumatoria + (k * (k + 1) / 2.0) * (k * (k + 1) / 2.0);
        }
        return sumatoria;
    }
	 
	public double calcularProductoria() {
		double productoria = 1;
	    for (int k = 1; k <= n; k++) {
	    	productoria = productoria * (k * (k + 4));
	    }
	    return productoria;
	}
}
