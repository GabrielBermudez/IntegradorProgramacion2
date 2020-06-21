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
import com.toedter.calendar.JDateChooser;

public class VistaInscripcion extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JTable tableCarrera;
	private JScrollPane scrollCarrera;
	private JButton btnVolver;
	private JTextField tfDniAlumno;
	private JTextField tfCodigoCarrera;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tableAlumno;
	private JLabel lbTituloMateria;
	private JLabel lbTituloAlumno;
	private JTextField tfCodigo;
	private JDateChooser dateChooser;
	private JLabel lbFondo;
	
	
	public VistaInscripcion() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 630);
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
		scroll.setBounds(41, 45, 796, 129);
		
		contentPane.add(scroll);
		

		tableCarrera = new JTable();
		tableCarrera.setBackground(new Color(192, 192, 192));
		tableCarrera.setGridColor(new Color(128, 128, 128));
		tableCarrera.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCarrera.setEnabled(false);
		tableCarrera.setBounds(60, 39, 399, 118);
		
		scrollCarrera= new JScrollPane(tableCarrera);
		scrollCarrera.setEnabled(false);
		scrollCarrera.setBounds(458, 383, 416, 142);
		
		contentPane.add(scrollCarrera);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(774, 556, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lbTituloInscripcion = new JLabel("Inscripcion");
		lbTituloInscripcion.setBounds(317, 0, 275, 32);
		lbTituloInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloInscripcion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(lbTituloInscripcion);
		
		JLabel lbDniAlumno = new JLabel("DNI Alumno:");
		lbDniAlumno.setBounds(41, 252, 65, 14);
		contentPane.add(lbDniAlumno);
		
		JLabel lbCodCarrera = new JLabel("Codigo Carrera:");
		lbCodCarrera.setBounds(41, 280, 81, 14);
		contentPane.add(lbCodCarrera);
		
		tfDniAlumno = new JTextField();
		tfDniAlumno.setBounds(132, 249, 86, 20);
		contentPane.add(tfDniAlumno);
		tfDniAlumno.setColumns(10);
		
		tfCodigoCarrera = new JTextField();
		tfCodigoCarrera.setBounds(132, 274, 86, 20);
		contentPane.add(tfCodigoCarrera);
		tfCodigoCarrera.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(255, 257, 89, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(353, 257, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(458, 257, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lbNota = new JLabel("Fecha:");
		lbNota.setBounds(41, 305, 77, 14);
		lbNota.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbNota);
		
		JScrollPane scrollAlumno = new JScrollPane((Component) null);
		scrollAlumno.setEnabled(false);
		scrollAlumno.setBounds(15, 383, 416, 142);
		contentPane.add(scrollAlumno);
		
		tableAlumno = new JTable();
		tableAlumno.setGridColor(new Color(128, 128, 128));
		tableAlumno.setBackground(new Color(192, 192, 192));
		tableAlumno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAlumno.setEnabled(false);
		scrollAlumno.setViewportView(tableAlumno);
		
		lbTituloMateria = new JLabel("Materia");
		lbTituloMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloMateria.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lbTituloMateria.setBounds(628, 340, 121, 32);
		contentPane.add(lbTituloMateria);
		
		lbTituloAlumno = new JLabel("Alumnos");
		lbTituloAlumno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lbTituloAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloAlumno.setBounds(127, 344, 181, 25);
		contentPane.add(lbTituloAlumno);
		
		JLabel lbCodigo = new JLabel("Codigo:");
		lbCodigo.setBounds(41, 227, 42, 14);
		contentPane.add(lbCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setDisabledTextColor(new Color(128, 128, 128));
		tfCodigo.setEnabled(false);
		tfCodigo.setBounds(132, 224, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(132, 299, 181, 20);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser);
		
		lbFondo = new JLabel("");
		lbFondo.setIcon(new ImageIcon("C:\\Users\\gabri\\Desktop\\HANAMI\\ProyectoFinalHanami\\src\\Image\\FondoVistaInscripcion.png"));
		lbFondo.setBounds(0, 0, 894, 601);
		contentPane.add(lbFondo);
	}


	public JTable getTable() {
		return table;
	}


	public JScrollPane getScroll() {
		return scroll;
	}


	public JTable getTableCarrera() {
		return tableCarrera;
	}


	public JScrollPane getScrollCarrera() {
		return scrollCarrera;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public JTextField getTfDniAlumno() {
		return tfDniAlumno;
	}


	public JTextField getTfCodigoCarrera() {
		return tfCodigoCarrera;
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


	public JTable getTableAlumno() {
		return tableAlumno;
	}


	public JLabel getLbTituloMateria() {
		return lbTituloMateria;
	}


	public JLabel getLbTituloAlumno() {
		return lbTituloAlumno;
	}


	public JTextField getTfCodigo() {
		return tfCodigo;
	}


	public JDateChooser getDateChooser() {
		return dateChooser;
	}


	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	
	

}	
	
