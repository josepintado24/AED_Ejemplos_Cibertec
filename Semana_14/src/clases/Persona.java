package clases;

public class Persona {
	
	//  Atributos privados
	private String codigo;
	private String nombre;
	private double peso, estatura;
	private int estado;
	//  Constructor
	public Persona(String codigo, String nombre, double peso, double estatura, int estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.peso = peso;
		this.estatura = estatura;
		this.estado = estado;
	}
	//  Métodos de acceso público: set/get
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPeso() {
		return peso;
	}
	public double getEstatura() {
		return estatura;
	}
	public int getEstado() {
		return estado;
	}
	public String detalleEstado() {
		switch (estado) {
			case 0: return "Soltero";
			case 1: return "Casado";
			case 2: return "Viudo";
			default: return "Divorciado";
		}
	}
	//  Operaciones públicas complementarias
	public double imc() {
		return peso / (estatura * estatura);
	}
	
}
