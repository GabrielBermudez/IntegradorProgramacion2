package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Component;

public class VistaMateria extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JTable tableProfesor;
	private JScrollPane scrollProfesor;
	private JButton btnVolver;
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField tfDniProfesor;
	private JLabel lbTituloProfesor;
	private JLabel lblNewLabel;
	
	
	public VistaMateria() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(true);
		table.setBounds(10, 39, 399, 118);
		
		scroll= new JScrollPane(table);
		scroll.setBounds(217, 44, 387, 118);
		
		contentPane.add(scroll);
		

		tableProfesor = new JTable();
		tableProfesor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProfesor.setEnabled(true);
		tableProfesor.setBounds(60, 39, 399, 118);
		
		scrollProfesor= new JScrollPane(tableProfesor);
		scrollProfesor.setBounds(42, 237, 432, 94);
		
		contentPane.add(scrollProfesor);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(476, 338, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lbTituloMateria = new JLabel("Materia");
		lbTituloMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloMateria.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lbTituloMateria.setBounds(-56, 11, 275, 32);
		contentPane.add(lbTituloMateria);
		
		JLabel lbCodigo = new JLabel("Codigo:");
		lbCodigo.setBounds(42, 75, 65, 14);
		contentPane.add(lbCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(42, 100, 65, 14);
		contentPane.add(lblNombre);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(121, 75, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(121, 100, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(48, 173, 89, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(146, 173, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(251, 173, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lbDniProfesor = new JLabel("DNI Profesor:");
		lbDniProfesor.setHorizontalAlignment(SwingConstants.LEFT);
		lbDniProfesor.setBounds(42, 125, 89, 14);
		contentPane.add(lbDniProfesor);
		
		tfDniProfesor = new JTextField();
		tfDniProfesor.setBounds(121, 125, 86, 20);
		contentPane.add(tfDniProfesor);
		tfDniProfesor.setColumns(10);
		
		lbTituloProfesor = new JLabel("Profesor");
		lbTituloProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloProfesor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbTituloProfesor.setBounds(184, 207, 106, 19);
		contentPane.add(lbTituloProfesor);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gabri\\Desktop\\HANAMI\\ProyectoFinalHanami\\src\\Image\\FondoVistaMateria.png"));
		lblNewLabel.setBounds(0, 1, 614, 371);
		contentPane.add(lblNewLabel);
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public JTable getTable() {
		return table;
	}


	public JScrollPane getScroll() {
		return scroll;
	}


	public JTable getTableProfesor() {
		return tableProfesor;
	}


	public JScrollPane getScrollProfesor() {
		return scrollProfesor;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public JTextField getTfCodigo() {
		return tfCodigo;
	}


	public JTextField getTfNombre() {
		return tfNombre;
	}


	public JButton getBtnIngresar() {
		return btnIngresar;
	}


	public JButton getBtnModificar() {
		return btnModificar;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public JTextField getTfDniProfesor() {
		return tfDniProfesor;
	}


	public JLabel getLbTituloProfesor() {
		return lbTituloProfesor;
	}
	
	


	
	
}

