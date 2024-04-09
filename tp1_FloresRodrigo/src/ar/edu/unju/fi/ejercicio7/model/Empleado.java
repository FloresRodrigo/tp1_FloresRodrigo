package ar.edu.unju.fi.ejercicio7.model;

public class Empleado {
	private String nombre;
	private int legajo;
	private float salario;
	
	private static final float salarioMinimo = 210000.00f;
	private static final float aumentoMeritos = 20000.00f;
	
	public Empleado(String nombre, int legajo, float salario) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		
		if (salario >= salarioMinimo) {
            this.salario = salario;
        } else {
            this.salario = salarioMinimo;
        }
		
	}
	
	public void mostrarDatos() {
        System.out.println("Nombre del empleado: " + this.nombre);
        System.out.println("Legajo: " + this.legajo);
        System.out.println("Salario $: " + this.salario);
    }
	
	public void aumentoSalario() {
        salario = salario + aumentoMeritos;
        System.out.println("Se ha asignado un aumento por meritos al empleado: " + this.nombre);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
}
