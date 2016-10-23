
//Interfaz de la cola que se encuentra en prioridad.

public interface PriorityQueue<T extends Comparable<T>>
{
	//Valor minimo de la cola
	public T getFirst();
	
        
	// Valor removido de la cola
	public T remove();
        
        
	// Agregar un valor a la cola
	public void add(T value);

        
	// Determinar si la cola está vacía
	public boolean isEmpty();
        
        
	// Devuelve el numero de elementos en la cola
	public int size();

        
        // Remover los elementos de la cola
        public void clear();
        
        
}