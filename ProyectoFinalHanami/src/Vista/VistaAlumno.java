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
import com.toedter.calendar.JDateChooser;
import java.awt.ComponentOrientation;

public class VistaAlumno extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnVolver;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDni;
	private JTextField tfDomicilio;
	private JTextField tfTelefono;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JDateChooser dateChooserFecha;
	
	
	public VistaAlumno() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(false);
		table.setBounds(10, 39, 399, 118);
		
		scroll= new JScrollPane(table);
		scroll.setBounds(10, 39, 429, 118);
		
		contentPane.add(scroll);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 352, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lbTituloIngresarAlumno = new JLabel("Ingresar Alumno");
		lbTituloIngresarAlumno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lbTituloIngresarAlumno.setBounds(92, 0, 275, 32);
		contentPane.add(lbTituloIngresarAlumno);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setBounds(10, 210, 65, 14);
		contentPane.add(lbNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 238, 65, 14);
		contentPane.add(lblApellido);
		
		JLabel lbDni = new JLabel("DNI:");
		lbDni.setBounds(10, 183, 65, 14);
		contentPane.add(lbDni);
		
		JLabel lbDomicilio = new JLabel("Domicilio:");
		lbDomicilio.setBounds(242, 182, 65, 14);
		contentPane.add(lbDomicilio);
		
		JLabel lbTelefono = new JLabel("Telefono:");
		lbTelefono.setBounds(242, 207, 65, 14);
		contentPane.add(lbTelefono);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(119, 205, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(119, 233, 86, 20);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(119, 180, 86, 20);
		contentPane.add(tfDni);
		
		tfDomicilio = new JTextField();
		tfDomicilio.setColumns(10);
		tfDomicilio.setBounds(317, 179, 86, 20);
		contentPane.add(tfDomicilio);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(317, 204, 86, 20);
		contentPane.add(tfTelefono);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(78, 316, 89, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(188, 316, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(294, 316, 89, 23);
		contentPane.add(btnEliminar);
		
		dateChooserFecha = new JDateChooser();
		dateChooserFecha.setBounds(129, 264, 158, 20);
		dateChooserFecha.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooserFecha);
		
		
		JLabel lbFechaNac = new JLabel("Fecha de Nacimiento:");
		lbFechaNac.setBounds(10, 270, 126, 14);
		contentPane.add(lbFechaNac);
	}
	
	
	
	
	/**
	 * @return the dateChooserFecha
	 */
	public JDateChooser getDateChooserFecha() {
		return dateChooserFecha;
	}


	



	/**
	 * @return the btnIngresar
	 */
	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	/**
	 * @return the btnModificar
	 */
	public JButton getBtnModificar() {
		return btnModificar;
	}

	/**
	 * @return the btnEliminar
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @return the scroll
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * @return the tfNombre
	 */
	public JTextField getTfNombre() {
		return tfNombre;
	}

	/**
	 * @return the tfApellido
	 */
	public JTextField getTfApellido() {
		return tfApellido;
	}

	/**
	 * @return the tfDni
	 */
	public JTextField getTfDni() {
		return tfDni;
	}

	/**
	 * @return the tfDomicilio
	 */
	public JTextField getTfDomicilio() {
		return tfDomicilio;
	}

	/**
	 * @return the tfTelefono
	 */
	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	/**
	 * @return the btnVolver
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}


	/**
	 * @param btnVolver the btnVolver to set
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
}