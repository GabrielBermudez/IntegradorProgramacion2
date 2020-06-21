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
	private JButton btnCarrera;
	private JButton btnInscripcion;

	
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
		btnAlumno.setBounds(144, 63, 116, 38);
		contentPane.add(btnAlumno);
		
		btnProfesor = new JButton("Profesor");
		btnProfesor.setBounds(144, 112, 116, 38);
		contentPane.add(btnProfesor);
		
		btnMateria = new JButton("Materia");
		btnMateria.setBounds(144, 161, 116, 38);
		contentPane.add(btnMateria);
		
		btnCursado = new JButton("Notas");
		btnCursado.setBounds(144, 206, 116, 38);
		contentPane.add(btnCursado);
		
		JButton btnAcercaDe = new JButton("Acerca de");
		btnAcercaDe.setBounds(429, 367, 89, 23);
		contentPane.add(btnAcercaDe);
		
		btnCarrera = new JButton("Carrera");
		btnCarrera.setBounds(144, 255, 116, 38);
		contentPane.add(btnCarrera);
		
		btnInscripcion = new JButton("Inscripcion");
		btnInscripcion.setBounds(144, 307, 116, 38);
		contentPane.add(btnInscripcion);
		
		JLabel lbFondo = new JLabel("");
		lbFondo.setIcon(new ImageIcon("C:\\Users\\gabri\\eclipse-workspace\\ProyectoFinalHanami\\src\\Images\\FondoMenuPrincipal.png"));
		lbFondo.setBounds(0, 0, 547, 412);
		contentPane.add(lbFondo);
	}


	public JButton getBtnAlumno() {
		return btnAlumno;
	}


	public JButton getBtnProfesor() {
		return btnProfesor;
	}


	public JButton getBtnMateria() {
		return btnMateria;
	}


	public JButton getBtnCursado() {
		return btnCursado;
	}


	public JButton getBtnCarrera() {
		return btnCarrera;
	}


	public JButton getBtnInscripcion() {
		return btnInscripcion;
	}

		
}
