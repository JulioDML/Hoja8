import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{
	
	protected Vector<E> data;

	
	// Constructor para la cola prioritaria
        public VectorHeap(){
		data = new Vector<E>();
	}
	
	// Constructor para una cola que se encuentra en desorden
	public VectorHeap(Vector<E> v)
	{
		int i;
		data = new Vector<E>(v.size());
		for (i = 0; i < v.size(); i++){ 
			add(v.get(i));
		}
	}
	
	// Usando posicion i se obtiene el padre del nodo
	protected static int parent(int i){
		return (i-1)/2;
	}

	// Usando posicion i se obtiene el hijo izquierdo del nodo
	protected static int left(int i){
		return 2*i+1;
	}
	// Usando posicion i se obtiene el hijo derecho del nodo
	protected static int right(int i){
		return (2*i+1) + 1;
	}

	
	 // Este metodo empuja el valor ingresado hacia la raiz hasta que encuentre su posicion
	 // apropiada.
	 
	protected void percolateUp(int leaf){
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
				(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

	 // Manda la posicion del valor agregado al metodo percolateUp
	 
	public void add(E value){
		data.add(value);
		percolateUp(data.size()-1);
	}
        
        // Mueve el nodo hacia la raiz para luego poner para luego
	// vaya a su posicion correcta en el heap.
	protected void pushDownRoot(int root){
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
						((data.get(childpos+1)).compareTo
								(data.get(childpos)) < 0))
				{
					childpos++;
				}
				// Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo
						(value) < 0)
				{
					data.set(root,data.get(childpos));
					root = childpos; // Sigue abajo
				} else { // Encuentra posicion a la derecha
					data.set(root,value);
					return;
				}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

	public E remove(){
            
		//Para una cola no vacía
            
		if (isEmpty()==false){
			E minVal = getFirst();
			data.set(0,data.get(data.size()-1));
			data.setSize(data.size()-1);
			if (data.size() > 1) pushDownRoot(0);
			return minVal;
		}
		else{
			return null;
		}
	
	}

	@Override
	public E getFirst() {
		return data.get(0);
	}


	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}


	@Override
	public int size() {
		return 0;
	}


	@Override
	public void clear() {
		int i=0;
		while(data.isEmpty()==false){
			data.remove(i);
			i++;
		}
	}
}