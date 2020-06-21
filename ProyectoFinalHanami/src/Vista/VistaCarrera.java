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
import java.awt.ComponentOrientation;

public class VistaCarrera extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnVolver;
	private JTextField tfNombre;
	private JTextField tfDuracion;
	private JTextField tfCodigo;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	
	
	public VistaCarrera() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		table = new JTable();
		table.setGridColor(new Color(128, 128, 128));
		table.setBackground(new Color(192, 192, 192));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(false);
		table.setBounds(10, 39, 399, 118);
		
		scroll= new JScrollPane(table);
		scroll.setBounds(10, 39, 429, 118);
		
		contentPane.add(scroll);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(337, 329, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lbTituloIngresarCarrera = new JLabel("Ingresar Carrera");
		lbTituloIngresarCarrera.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lbTituloIngresarCarrera.setBounds(92, 0, 275, 32);
		contentPane.add(lbTituloIngresarCarrera);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setBounds(10, 210, 65, 14);
		contentPane.add(lbNombre);
		
		JLabel lblApellido = new JLabel("Duracion:");
		lblApellido.setBounds(10, 238, 65, 14);
		contentPane.add(lblApellido);
		
		JLabel lbCodMateria = new JLabel("Codigo:");
		lbCodMateria.setBounds(10, 183, 65, 14);
		contentPane.add(lbCodMateria);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(119, 205, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(119, 233, 86, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(119, 180, 86, 20);
		contentPane.add(tfCodigo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(26, 280, 89, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(125, 280, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(224, 280, 89, 23);
		contentPane.add(btnEliminar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gabri\\Desktop\\HANAMI\\ProyectoFinalHanami\\src\\Image\\FondoCarrera.png"));
		lblNewLabel.setBounds(0, 0, 449, 363);
		contentPane.add(lblNewLabel);
	}


	public JTable getTable() {
		return table;
	}


	public JScrollPane getScroll() {
		return scroll;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public JTextField getTfNombre() {
		return tfNombre;
	}


	public JTextField getTfDuracion() {
		return tfDuracion;
	}


	public JTextField getTfCodigo() {
		return tfCodigo;
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
	
	
	
	
}