package arreglos;

public class ArregloNotas {
	private int nota[];
	private int indice;
	/*Un Constructor sin par�metros que reserve 10 espacios en nota e inicialice con 0 al indice.*/
	public ArregloNotas(){
		nota =new int [10];
		indice=0;
	}	
	/*Un m�todo tama�o que retorne la cantidad de datos ingresados hasta ese momento.*/
	public int tamano(){
		return indice;
	}
	/*Un m�todo obtener que reciba una posici�n y retorne la nota registrada en dicha posici�n.*/
	public int obtener(int pos){
		return nota[pos];
	}
	/*Un m�todo privado ampliarArreglo que extienda el arreglo en diez espacios m�s.*/
	private  void ampliarArreglo(){
		int auxi[]=nota;
		nota=new int [indice+10];
		for (int i=0;i<tamano();i++){
			nota[i]=auxi[i];
		}
	}
	/*Un m�todo adicionar que reciba una edad y la registre en la posici�n que corresponda.
	 *  Verifique primero si el arreglo est� lleno para invocar al m�todo ampliarArreglo..*/
	public void adicionar(int edad){
		if (tamano()==nota.length){
			ampliarArreglo();
		}
		nota[indice]=edad;
		indice++;
	}
	
	/*Un m�todo eliminarAlFinal que elimina l�gicamente la �ltima edad del arreglo.*/
	public void eliminarAlFinal(){
		indice--;
	}
	
	/*Un m�todo eliminarTodo que elimina l�gicamente todas las edades.*/
	public void eliminarTodo(){
		indice=0;
	}
	
	/*Un m�todo buscarUltimaNotaDesaprobatoria que retorne la posici�n de la �ltima nota menor que 13.
	 *  En caso no exista retorne -1.*/
	public int  buscarUltimaNotaDesaprobatoria(){
		for (int i=tamano()-1;i>=0;i--){
			if (nota[i]<13){
				return i;				
			}
		}
		return -1;
	}
	/*Un m�todo decrementarUltimaNotaDesaprobatoria que disminuya la �ltima nota menor que 13 en dos puntos.
	 *En caso que al disminuir resulte una nota negativa, fije la nota en cero.*/
	public int decrementarUltimaNotaDesaprobatoria(){
		if (nota[buscarUltimaNotaDesaprobatoria()]<2){
			return 0;
		}
		return nota[buscarUltimaNotaDesaprobatoria()]-2;
	}
	
	/*Un m�todo remplazarUltimaNotaDesaprobatoria que cambie la �ltima nota desaprobatoria por la �ltima nota del arreglo.*/
	public int remplazarUltimaNotaDesaprobatoria(){
		return nota[buscarUltimaNotaDesaprobatoria()]=nota[tamano()-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
