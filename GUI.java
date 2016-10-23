import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton  btnDesplegar,btnNewButton ;
	private Asignar manejadora;
	private JLabel lblNewLabel,lblNewLabel_1,lblPacientesEnOrden;
	private JTextArea textArea;
	private GroupLayout gl_contentPane;
	private JScrollPane scrollPane;
	  public static final String[] opciones = { "VectorHeap", "JFC" };
	/**
	 * Launch the application.
	 * @param args argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		manejadora = new Asignar();
		initialize();
	}

	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNewLabel = new JLabel("Pacientes por prioridad");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_1 = new JLabel("Ingrese archivo de datos del paciente:");
		lblPacientesEnOrden = new JLabel("Pacientes registrados / Pacientes por prioridad");

		textField = new JTextField();
		textField.setColumns(10);

		textArea = new JTextArea();

		btnDesplegar = new JButton("Mostrar");
		btnNewButton = new JButton("Reset");

		scrollPane = new JScrollPane();

		 btnDesplegar.addActionListener(new Eventos());
		 btnNewButton.addActionListener(new Eventos());

		 gl_contentPane = new GroupLayout(contentPane);
		 gl_contentPane.setHorizontalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(205)
		 					.addComponent(lblNewLabel))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(73)
		 					.addComponent(lblNewLabel_1)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(45)
		 					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
		 						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 						.addComponent(btnDesplegar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(36)
		 					.addComponent(lblPacientesEnOrden)))
		 			.addContainerGap())
		 );
		 gl_contentPane.setVerticalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addGap(23)
		 			.addComponent(lblNewLabel)
		 			.addGap(43)
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1)
		 				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addGap(18)
		 			.addComponent(lblPacientesEnOrden)
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		 				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(btnDesplegar))
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addComponent(btnNewButton)
		 			.addContainerGap(34, Short.MAX_VALUE))
		 );

		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}

		private class Eventos implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnNewButton) {
					textField.setEditable(true);
					textArea.setText("");
					textField.setText("");
				}
				
				if (e.getSource() == btnDesplegar) {
					String contenido=manejadora.leerContenido(textField.getText());
					if (contenido!=null){
						JFrame frame = new JFrame("Input ");
						 String imp = (String) JOptionPane.showInputDialog(frame,
							        "Escoga la implementacion que desea utilizar",
							        "Implementacion",
							        JOptionPane.QUESTION_MESSAGE,
							        null,
							        opciones,
							        opciones[0]);
							    
							    if (imp!=null){
							    	if (imp.equals("VectorHeap")){
								    	textArea.append("--Pacientes, por registro-- \n");
										textArea.append(contenido);
										manejadora.asignacion(textField.getText());
										textArea.append("--Pacientes, por prioridad-- \n");
										
										textArea.append(manejadora.desplegar());
										textField.setEditable(false);
								    }
								    else if (imp.equals("JFC")){
								    	textArea.append("--Pacientes en orden de registro-- \n");
								    	textArea.append(contenido);
								    	manejadora.asignacion2(textField.getText());
								    	textArea.append("--Pacientes en orden de prioridad que deben ser atendidos-- \n");
										
										textArea.append(manejadora.desplegar2());
										textField.setEditable(false);
								    }
							    }
							    else{

							    }
					}

				}
			}
		}
}

