package ar.edu.unju.fi.ejercicio9.model;

public class Producto {
	private String nombre;
	private String codigo;
	private float precio;
	private int descuento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public Producto() {
		super();
	}
	
	public float calcularDescuento() {
		if (descuento > 0) {
			float valorDescuento = precio * ((float)descuento / 100);
				return precio - valorDescuento;
			} else {
				return precio;
			}
	}
}
