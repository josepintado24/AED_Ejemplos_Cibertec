package arreglos;

public class ArregloTemperaturas {
	//Propuesto_6_1
	private double temperatura[];
	private int indice;
	/*Un Constructor sin par�metros que reserve 10 espacios en temperatura e inicialice con 0 al indice.*/
	
	public ArregloTemperaturas(){
		temperatura=new double[10] ;
		indice=0;
	}
	
	/*Un m�todo tama�o que retorne la cantidad de datos ingresados hasta ese momento.*/
	public int tamano(){
		return indice;
	}
	
	/*Un m�todo obtener que reciba una posici�n y retorne la temperatura registrada en*/
	public double obtener (int pos){
		return temperatura[pos];
	}
	
	/*Un m�todo privado ampliarArreglo que extienda el arreglo en diez espacios m�s.*/
	private void ampliarArreglo(){
		double auxi[]=temperatura;
		temperatura=new double [indice+10];
		for(int i=0;i<tamano();i++){
			temperatura[i]=auxi[i];
		}
		
	}
	/*Un m�todo adicionar que reciba una temperatura y la registre en la posici�n que corresponda.
	 *  Verifique primero si el arreglo est� lleno para invocar al m�todo ampliarArreglo.*/
	public void adicionar(double tempe){
		if (tamano()==temperatura.length){
			ampliarArreglo();
		}
		temperatura[indice]=tempe;
		indice++;
	}
	
	/*Un m�todo eliminarAlFinal que elimina l�gicamente la �ltima temperatura del arreglo.*/
	public void eliminarAlFinal(){
		indice--;
	}
	/*Un m�todo eliminarTodo que elimina l�gicamente todas las temperaturas.*/
	public void eliminarTodo(){
		indice=0;
	}
	
	/*Un m�todo temperaturaMenor que tetorne la emperatura m�s baja.*/
	public double temperaturaMenor(){
		double temMenor=temperatura[0];
		for (int i=0;i<tamano()-1;i++){
			if (temMenor>temperatura[i]){
				temMenor=temperatura[i];
			}
		}	
		
		
		return temMenor;
	}
	/*Un m�todo buscarPrimeraTemperaturaNormal que retorne la posici�n de la primera temperatura
	 *  encontrada en el rango de 36.1�C a 37.2�C.*/
	public int buscarPrimeraTemperaturaNormal(){
		for (int i=0;i<tamano()-1;i++){
			if ((temperatura[i]>=36.1) && (temperatura[i]<=37.2)){
				return i;
			}
		}
		return 0;
	}
	
	/*Un m�todo remplazarPrimeraTemperaturaNormal que cambie la primera temperatura normal por la 
	 *menor temperatura del arreglo. Para el efecto, invoque a los m�todos buscarPrimeraTemperaturaNormal y temperaturaMenor.*/
	
	public void remplazarPrimeraTemperaturaNormal(){
		temperatura[buscarPrimeraTemperaturaNormal()]=temperaturaMenor();
	}
	
	/*Un m�todo incrementarTemperaturas que aumente todas las temperaturas en 0.2�C.*/
	
	public void incrementarTemperaturas(){
		for (int i=0;i<tamano()-1;i++){
				double valor=temperatura[i];
				temperatura[i]=valor+0.2;
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
