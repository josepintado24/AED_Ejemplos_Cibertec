//Dise�e la clase ArregloEdades en el paquete semana_05
package clases;

public class ArregloEdades {
	/*atributo privado edad (int) de tipo arreglo lineal 
	 y con los valores de inicializaci�n:
	 27, 22, 13, 12, 25, 11, 29, 70, 15, 20*/
	private int edad[]={27, 22, 13, 12, 25, 11, 29, 70, 15, 20};

	/*Un Constructor que no haga nada.*/
	public ArregloEdades() {
	}
	
	/*Un m�todo tama�o que retorne la cantidad de 
	 * elementos del arreglo edad.*/
	
	public int tamano(){
		return edad.length;
	}
	
	/*Un m�todo obtener que reciba una posici�n y retorne 
	 * la edad registrada en dicha posici�n.*/
	
	public int obtener(int posi){
		return edad[posi];
		
	}
	/*Un m�todo edadPromedio que retorne el promedio de
	  todas las edades.*/
	public int edadPromedio(){
		int suma=0;
		for (int a=0;a<tamano();a++){
			suma=suma+edad[a];
		}
			
	return suma/tamano();	
		
	}
	
	/*Un m�todo edadMayor que retorne la mayor de todas las edades.*/
	public int edadMayor(){
		int mayor=edad[0];
		for(int i=1;i<this.tamano();i++){
			if(edad[i]>mayor){
				mayor=edad[i];
			}
		}
		return mayor; 
	}
	
	//Un m�todo edadMenor que retorne la menor de todas las edades.
	public int edadMenor(){
		int menor=edad[0];
		for(int i=1;i<this.tamano();i++){
			if(edad[i]<menor){
			menor=edad[i];
			}
		}
		return menor;
	}
	/*Un m�todo cantMayoresEdad que retorne la cantidad de personas mayores de edad.*/
	public int cantMayoresEdad(){
		
		int cantPersonasMayor=0;
		for(int i=0;i<this.tamano();i++){
			if(edad[i]>18){
				cantPersonasMayor++;
			}
		}
			return cantPersonasMayor;
		}
	
	/*Un m�todo cantMenoresEdad que retorne la cantidad de personas menores de edad.*/
	public int cantMenoresEdad(){
		
		int cantPersonasMenor=0;
		for(int i=0;i<this.tamano();i++){
			if(edad[i]<18){
				cantPersonasMenor++;
			}
		}
			return cantPersonasMenor;
		}
	
	
	
	/*Un m�todo buscarPrimeraEdadAdolescente que retorne la posici�n 
	 * de la primera edad encontrada en el rango de 12 a 20 a�os.
	 *  En caso no exista retorne -1.*/
	public int buscarPrimeraEdadAdolescente(){
		for(int i=0;i<this.tamano();i++){
			if((edad[i]<20)&& (edad[i]>12)){
			return i;
			}
		}
		return -1;
	}
	
	/*Un m�todo buscarUltimaEdadAdolescente que retorne la posici�n
	 * de la �ltima edad encontrada en el rango de 12 a 20 a�os.
	 * En caso no exista retorne -1.*/
	public int buscarUltimaEdadAdolescente(){
		for(int i=tamano()-1;i>=0;i--){
			if((edad[i]<20)&& (edad[i]>12)){
			return i;
			}
		}
		return -1;
	}
	
	private int aleatorio(int min, int max) {
		return (int)((max - min + 1) * Math.random()) + min;
		}
	
	/*Un m�todo generarEdades que remplace las edades actuales por otras 
	 * aleatorias comprendidas en el rango de 10 a 90 a�os. Haga uso del m�todo:*/
	
	public void generarEdades(){
		for(int i=0;i<tamano();i++){
			edad[i]=aleatorio(100,999);
		}
		
	}
}
