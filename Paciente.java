// Algoritmos y Estructuras de Datos, Seccion 20
// Hoja de Trabajo 8

// Julio Mérida  15242
// Axel Mazariegos  131212
// Gustavo Orellana 15073

public class Paciente  implements Comparable<Paciente>{
	
	private String nombre;
	private String estado;
	private String prioridad;
	
	// Constructor para objetos tipo paciente
	
	public Paciente(String nombre, String estado, String prioridad) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.prioridad = prioridad;
	}


	// Setters y Getters para atributos del paciente
        
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	// Metodo para realizar comparacion
	
	@Override
	public int compareTo(Paciente arg0) {
		return this.prioridad.compareTo(arg0.prioridad);
	}

        // To String para datos del paciente
	
	@Override
	public String toString() {
		return nombre + "," + estado + "," + prioridad;
	}
}

