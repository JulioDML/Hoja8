
// Algoritmos y Estructuras de Datos, Seccion 20
// Hoja de Trabajo 8

// Julio Mérida  15242
// Axel Mazariegos  
// Gustavo Orellana 15073


import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Asignar {
	
	private VectorHeap<Paciente> cola;
	private Paciente paciente;
	private ArrayList<String> array;
	private PriorityQueue<Paciente> cola2;
	
        // Lector de archivo, incorporado a los paneles de la GUI
        
	String leerContenido(String archivo) {
		String texto = "", temp = "", bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				temp += bfRead+"\n";
			}
			texto = temp;
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Archivo no encontrado");
			int con = JOptionPane.showConfirmDialog(null,
					"Tratar de nuevo?", null, JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Presione el boton reset");
				return null;
			} else if (con == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Saliendo del Programa");
				System.exit(0);
			}
		}
		return texto;
	}
	
	

	ArrayList<String> leerContenido2(String archivo) {
		String bfRead;
		this.array = new ArrayList<String>();
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				this.array.add(bfRead);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Archivo no encontrado");
			int con = JOptionPane.showConfirmDialog(null,
					"Tratar de nuevo?", null, JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Presione el boton reset");
			} else if (con ==JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Saliendo del Programa");
				System.exit(0);
			}
		}
		return this.array;
	}
	
	
	 // Asigna a cada paciente un objeto de tipo paciente y se almacena usando VectorHeap

	 
	void asignacion(String archivo){
		int largo,conta=0;
		String[] parts;
		largo= leerContenido2(archivo).size();
		cola = new VectorHeap<Paciente>();
		while(largo>0){
			parts = array.get(conta).split(",");
			paciente = new Paciente(parts[0],parts[1],parts[2]);
			cola.add(paciente);
			largo--;
			conta++;
		}
	}
	 // Asigna a cada paciente un objeto de tipo paciente y se almacena usando Java Collection Framework

        
	void asignacion2(String archivo){
		int largo,conta=0;
		String[] parts;
		largo= leerContenido2(archivo).size();
		cola2 = new PriorityQueue<Paciente>();
		while(largo>0){
			parts = array.get(conta).split(",");
			paciente = new Paciente(parts[0],parts[1],parts[2]);
			cola2.add(paciente);
			largo--;
			conta++;
		}
	}
	// Devuelve todos los pacientes registrados en la cola de prioridad usando VectorHeap

	String desplegar(){
		String pacientes = "";
		while(cola.isEmpty()==false){
			paciente=cola.remove();
			pacientes+=paciente.toString()+"\n";
		}
		return pacientes;
	}
	// Devuelve todos los pacientes registrados en la cola de prioridad usando Java Collection Framework
	String desplegar2(){
		String pacientes = "";
		while(cola2.isEmpty()==false){
			paciente=cola2.poll();
			pacientes+=paciente.toString()+"\n";
		}
		return pacientes;
	}
	
}
