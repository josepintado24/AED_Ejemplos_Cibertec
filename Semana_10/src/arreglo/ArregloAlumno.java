package arreglo;
import java.util.ArrayList;
import clase.Alumno;
public class ArregloAlumno {
	
	/*Implementa la clase ArregloAlumnos
	 * en el paquete arreglo con el
	 *  atributo privado ArrayList 
	 *   alu  de tipo Alumno.
	 */
     private ArrayList<Alumno> alu;
     
     /*Un constructor que crea el ArrayList
      *  alu  de tipo Alumno y autogenera ocho objetos.
      */
     public ArregloAlumno(){
    	 alu=new ArrayList<Alumno>();
    	 alu.add(new Alumno(123,"Juan",15,18));
    	 alu.add(new Alumno(456,"Pedro",16,18));
    	 
     }
/*Un m�todo tama�o que retorna la cantidad
 * de alumnos registrados hasta ese momento.
 */
     public int tamano(){
    	 return alu.size();
     }
  /*Un m�todo obtener que recibe una posici�n
   * y retorna la direcci�n de memoria del alumno respectivo. 
   */
   
    public Alumno obtener(int posicion){
    	return alu.get(posicion);
    }
     
    /* Un m�todo adicionar que recibe la
     * direcci�n de memoria de un nuevo alumno
     * y lo adiciona al ArrayList.
     */

    public void adicionar(Alumno nuevo){
    	alu.add(nuevo);
    }
    
    /*m�todo eliminarAlFinal que retira
     * del ArrayList la �ltima direcci�n de memoria.
     */
    public void eliminarAlFinal(){
    	alu.remove(this.tamano()-1);
    }
    
    /*  Un m�todo eliminarTodo que
     * retira del ArrayList todas las direcciones de memoria.
     */
    public void eliminarTodo(){
    	alu.clear();
    }
    
    /* Un m�todo buscar que busca un c�digo y
     *  retorna la direcci�n de memoria del objeto 
     *  que lo contiene.           
     *  En caso no existe retorna null.
     */
    
    public Alumno buscar(int codigo){
    	for(int i=0;i<this.tamano();i++){
    		if(this.obtener(i).getCodigo()==codigo){
    			return this.obtener(i);
    		}
    	}
    	return null;
    }
    /*Un m�todo eliminar que recibe la
     * direcci�n de memoria de un objeto Alumno y lo retira del ArrayList.
     */
    public void eliminar(Alumno eliminado){
    	alu.remove(eliminado);
    }

}
