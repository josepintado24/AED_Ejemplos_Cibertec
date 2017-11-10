package arreglos;

import clases.Persona;

import java.util.ArrayList;

public class ArregloPersonas {
	//  Atributo privado
	private ArrayList <Persona> per;
	//  Constructor
    public ArregloPersonas() {
    	per = new ArrayList <Persona> ();
		adicionar(new Persona("1001", "Juan Prado Salazar", 82.3, 1.75, 3));
		adicionar(new Persona("1002", "Pedro Romero Soto", 79.5, 1.58, 1));
		adicionar(new Persona("1003", "Luis Pinto Garza", 82.7, 1.83, 0));
		adicionar(new Persona("1004", "Daniel Rojas Saenz", 80.2, 1.72, 2));
		adicionar(new Persona("1005", "Jorge Espinal Vega", 75.9, 1.88, 1));
    }
	//  Operaciones públicas básicas
	public int tamaño() {
		return per.size();
	}
	public Persona obtener(int pos) {
		return per.get(pos);
	}
	public void adicionar(Persona p) {
		per.add(p);
	}
	public void eliminar(Persona x) {
		per.remove(x);
	}
	//  Operaciones públicas complementarias
	public Persona buscar(String codigo) {
		Persona x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo().equals(codigo))
				return x;
		}
		return null;
	}
	public String codigoCorrelativo() {
		if (tamaño() == 0)
			return "1001";
		else {
			String ultimoCodigo = obtener(tamaño()-1).getCodigo();
			return "" + (Integer.parseInt(ultimoCodigo) + 1);
		}
	}
	
}
