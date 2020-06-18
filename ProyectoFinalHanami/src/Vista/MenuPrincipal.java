package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnAlumno;
	private JButton btnProfesor;
	private JButton btnMateria;
	private JButton btnCursado;

	
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Hanami");
		labelTitulo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 45));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(102, 11, 193, 41);
		contentPane.add(labelTitulo);
		
		btnAlumno = new JButton("Alumno");
		btnAlumno.setBounds(144, 83, 116, 38);
		contentPane.add(btnAlumno);
		
		btnProfesor = new JButton("Profesor");
		btnProfesor.setBounds(144, 144, 116, 38);
		contentPane.add(btnProfesor);
		
		btnMateria = new JButton("Materia");
		btnMateria.setBounds(145, 205, 116, 38);
		contentPane.add(btnMateria);
		
		btnCursado = new JButton("Notas");
		btnCursado.setBounds(146, 264, 116, 38);
		contentPane.add(btnCursado);
		
		JButton btnAcercaDe = new JButton("Acerca de");
		btnAcercaDe.setBounds(429, 367, 89, 23);
		contentPane.add(btnAcercaDe);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gabri\\eclipse-workspace\\ProyectoFinalHanami\\src\\Images\\FondoMenuPrincipal.png"));
		lblNewLabel.setBounds(0, 0, 547, 412);
		contentPane.add(lblNewLabel);
	}


	/**
	 * @return the btnIngresarProducto
	 */
	public JButton getBtnAlumno() {
		return btnAlumno;
	}


	/**
	 * @param btnIngresarProducto the btnIngresarProducto to set
	 */
	public void setBtnAlumno(JButton btnAlumno) {
		this.btnAlumno = btnAlumno;
	}


	/**
	 * @return the btnModificarProducto
	 */
	public JButton getBtnProfesor() {
		return btnProfesor;
	}


	/**
	 * @param btnModificarProducto the btnModificarProducto to set
	 */
	public void setBtnProfesor(JButton btnProfesor) {
		this.btnProfesor = btnProfesor;
	}


	/**
	 * @return the btnEliminarProducto
	 */
	public JButton getBtnMateria() {
		return btnMateria;
	}


	/**
	 * @param btnEliminarProducto the btnEliminarProducto to set
	 */
	public void setBtnMateria(JButton btnMateria) {
		this.btnMateria = btnMateria;
	}


	/**
	 * @return the btnMostrarProducto
	 */
	public JButton getBtnCursado() {
		return btnCursado;
	}


	/**
	 * @param btnMostrarProducto the btnMostrarProducto to set
	 */
	public void setBtnCursado(JButton btnCursado) {
		this.btnCursado = btnCursado;
	}
}
