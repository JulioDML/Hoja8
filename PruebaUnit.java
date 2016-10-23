
import java.util.PriorityQueue;

// Pruebas unitarias para metodos utilizados en el programa

public class PruebaUnit {
	
	 private VectorHeap<Paciente> vec ;
	 private PriorityQueue<Paciente> vec2;
	 private Paciente paciente;
	
            
	public void testAdd() {
		vec= new VectorHeap<Paciente>();
		vec2= new PriorityQueue<Paciente>();
		paciente = new Paciente("Axel","Parto","B");
		vec.add(paciente);
		
		vec2.add(paciente);
		}
	
	public void TestRemove() throws Exception{
		vec= new VectorHeap<Paciente>();
		vec2= new PriorityQueue<Paciente>();
		paciente = new Paciente("Axel","Parto","B");
		vec.add(paciente);
		vec2.add(paciente);	
	}
}