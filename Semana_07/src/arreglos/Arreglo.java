package arreglos;

public class Arreglo {
	/*atributos privados int  n 
	 * (arreglo lineal) y contador indice.
	 */
	private int []n;
	private int indice;
	
	/*constructor que reserva en n diez espacios 
	 * e inicializa el indice en cero.
	 */
	public Arreglo(){
		n=new int [10];
		indice=0;
	}

	/*m�todo tama�o que retorna la cantidad de
	 * n�meros ingresados hasta ese momento.
	 */
	public int tamano(){
		return indice;
	}
	
	/*m�todo obtener que recibe la posici�n y 
	 * retorna el n�mero registrado en dicha posici�n.
	 */
	public int obtner(int posicion){
		return n[posicion];
	}
	
	/*m�todo privado ampliarArreglo que 
	 * extiende el arreglo en diez espacios m�s.
	 */
	private void ampliarArreglo(){
		int auxiliar[]=n;//guardar en auxiliar
		n=new int[indice +10];//ampliar el arreglo
		for(int i=0;i<this.tamano();i++){//devolver los valores a n
			n[i]=auxiliar[i];
		}
	}	
	/*m�todo privado adicionar que recibe un n�mero 
	 * y lo registra en la posici�n que corresponde.
	 */
	private void adicionar(int numero){
		if(indice==n.length){
			ampliarArreglo();
		}
		n[indice]=numero;
		indice++;
	}
	
	/*m�todo privado buscar que recibe un n�mero 
	 * y retorna la posici�n. Si no lo encuentra retorna -1.
	 */
	private int buscar(int numero){
		for(int i=0;i<this.tamano();i++){
			if(n[i]==numero){
				return i;
			}
		}
		return -1;
	}
		
	/*- m�todo privado intercambiar que recibe 
	 * dos posiciones e intercambia sus contenidos.
	 */
	private void intercambiar(int posicion1,int posicion2){
		int aux=n[posicion1];//sacarlo a una auxiliar
		n[posicion1]=n[posicion2];
		n[posicion2]=aux;
	}

	/*m�todo buscarAdicionar que recibe un n�mero, 
	 * lo busca y si no est� registrado lo adiciona.
	 */
	public void buscarAdicionar(int numero){
		 int posicion=buscar(numero);
		 if(posicion==-1){
			 adicionar(numero);
		 }
	}
	
	/* m�todo primeroAlFinal que 
	 * traslada el primer n�mero al final.
	 */
	public void primeroAlFinal(){
		for(int i=0;i<tamano()-1;i++){
			intercambiar(i,i+1);
		}
	}
	
	/*m�todo buscarRezagar que busca
	 *  un n�mero y si est� registrado lo traslada al final.
	 */
	public void buscarRezagar(int numero){
		int posicion=buscar(numero);
		if(posicion !=-1){
			for(int i=posicion;i<this.tamano()-1;i++){
				intercambiar(i,i+1);
			}
		}
	}
	
	/*m�todo ultimoAlInicio que traslada el
	 * �ltimo n�mero al inicio.
	 */
	public void ultimoAlInicio(){
		for(int i=tamano()-1;i>0;i--){
			intercambiar(i,i-1);
		}
	}
	
	/*m�todo buscarPriorizar que busca un
	 * n�mero y si est� registrado lo traslada al inicio.
	 */
	public void buscarPriorizar(int numero){
		int posicion=buscar(numero);
		if(posicion!=-1){//valido si esta registrado
			for(int i=posicion;i>0;i--){//recorro desde la posicion al inicio
				intercambiar(i,i-1);//intercambio
			}
		}
	}
	
	/*m�todo invertirArreglo que
	 * invierte el contenido del arreglo
	 */
	
	public void invertirArreglo(){
		int i=0,j=tamano()-1;
		while(i<j){
			intercambiar(i,j);
			i++;
			j--;
		}
	}
	
	public void ordenarArreglo() {
	    for (int i=0; i<indice-1; i++)
	        for (int j=i+1; j<indice; j++)
	            if (n[i] > n[j])
	                intercambiar(i, j);
	}

}

