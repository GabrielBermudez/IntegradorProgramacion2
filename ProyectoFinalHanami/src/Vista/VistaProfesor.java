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
import javax.swing.JSeparator;

public class VistaProfesor extends JFrame {
	
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
	private JDateChooser dateChooserFechaNac;
	private JLabel Fondo;
	private JSeparator separator;

	
	public VistaProfesor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		table = new JTable();
		table.setGridColor(new Color(128, 128, 128));
		table.setBackground(new Color(192, 192, 192));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(false);
		table.setBounds(10, 39, 399, 118);
		
		scroll= new JScrollPane(table);
		scroll.setBounds(10, 39, 429, 118);
		
		contentPane.add(scroll);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 355, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lbTituloIngresarProfesor = new JLabel("Profesor");
		lbTituloIngresarProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloIngresarProfesor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lbTituloIngresarProfesor.setBounds(-49, 0, 275, 32);
		contentPane.add(lbTituloIngresarProfesor);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setForeground(Color.BLACK);
		lbNombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbNombre.setBounds(10, 207, 65, 14);
		contentPane.add(lbNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.BLACK);
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblApellido.setBounds(10, 232, 65, 14);
		contentPane.add(lblApellido);
		
		JLabel lbDni = new JLabel("DNI:");
		lbDni.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbDni.setBounds(10, 182, 65, 14);
		contentPane.add(lbDni);
		
		JLabel lbDomicilio = new JLabel("Domicilio:");
		lbDomicilio.setForeground(Color.BLACK);
		lbDomicilio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbDomicilio.setBounds(10, 260, 89, 14);
		contentPane.add(lbDomicilio);
		
		JLabel lbTelefono = new JLabel("Telefono:");
		lbTelefono.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbTelefono.setBounds(10, 285, 65, 14);
		contentPane.add(lbTelefono);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(85, 204, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(85, 229, 86, 20);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(85, 179, 86, 20);
		contentPane.add(tfDni);
		
		tfDomicilio = new JTextField();
		tfDomicilio.setColumns(10);
		tfDomicilio.setBounds(85, 257, 86, 20);
		contentPane.add(tfDomicilio);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(85, 282, 86, 20);
		contentPane.add(tfTelefono);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(192, 202, 89, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(192, 236, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(192, 276, 89, 23);
		contentPane.add(btnEliminar);
		
		dateChooserFechaNac = new JDateChooser();
		dateChooserFechaNac.setBounds(165, 325, 164, 20);
		dateChooserFechaNac.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooserFechaNac);
		
		JLabel lbFechaNac = new JLabel("Fecha de Nacimiento:");
		lbFechaNac.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbFechaNac.setBounds(10, 328, 161, 14);
		contentPane.add(lbFechaNac);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 168, 439, 2);
		contentPane.add(separator);
		
		Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("C:\\Users\\gabri\\Desktop\\HANAMI\\ProyectoFinalHanami\\src\\Image\\FondoVistaProfesor.png"));
		Fondo.setBounds(0, 0, 449, 389);
		contentPane.add(Fondo);
	}
	
	
	
	
	/**
	 * @return the dateChooserFechaNac
	 */
	public JDateChooser getDateChooserFechaNac() {
		return dateChooserFechaNac;
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
