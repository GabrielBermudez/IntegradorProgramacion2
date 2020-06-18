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

public class VistaCursado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JTable tableMateria;
	private JScrollPane scrollMateria;
	private JButton btnVolver;
	private JTextField tfDniAlumno;
	private JTextField tfCodMateria;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField tfNota;
	private JTable tableAlumno;
	private JLabel lbTituloMateria;
	private JLabel lblNewLabel;
	
	
	public VistaCursado() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(false);
		table.setBounds(10, 39, 399, 118);
		
		scroll= new JScrollPane(table);
		scroll.setBounds(41, 45, 796, 168);
		
		contentPane.add(scroll);
		

		tableMateria = new JTable();
		tableMateria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMateria.setEnabled(false);
		tableMateria.setBounds(60, 39, 399, 118);
		
		scrollMateria= new JScrollPane(tableMateria);
		scrollMateria.setEnabled(false);
		scrollMateria.setBounds(453, 352, 416, 181);
		
		contentPane.add(scrollMateria);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(780, 555, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lbTituloCursado = new JLabel("Cursado");
		lbTituloCursado.setBounds(317, 0, 275, 32);
		lbTituloCursado.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloCursado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(lbTituloCursado);
		
		JLabel lbDniAlumno = new JLabel("DNI Alumno:");
		lbDniAlumno.setBounds(31, 241, 65, 14);
		contentPane.add(lbDniAlumno);
		
		JLabel lbCodMateria = new JLabel("Codigo Materia:");
		lbCodMateria.setBounds(31, 266, 81, 14);
		contentPane.add(lbCodMateria);
		
		tfDniAlumno = new JTextField();
		tfDniAlumno.setBounds(122, 235, 86, 20);
		contentPane.add(tfDniAlumno);
		tfDniAlumno.setColumns(10);
		
		tfCodMateria = new JTextField();
		tfCodMateria.setBounds(122, 260, 86, 20);
		contentPane.add(tfCodMateria);
		tfCodMateria.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(255, 257, 89, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(353, 257, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(458, 257, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lbNota = new JLabel("Nota:");
		lbNota.setBounds(31, 291, 77, 14);
		lbNota.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbNota);
		
		tfNota = new JTextField();
		tfNota.setBounds(122, 285, 86, 20);
		contentPane.add(tfNota);
		tfNota.setColumns(10);
		
		JScrollPane scrollAlumno = new JScrollPane((Component) null);
		scrollAlumno.setEnabled(false);
		scrollAlumno.setBounds(10, 352, 416, 181);
		contentPane.add(scrollAlumno);
		
		tableAlumno = new JTable();
		tableAlumno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAlumno.setEnabled(false);
		scrollAlumno.setViewportView(tableAlumno);
		
		lbTituloMateria = new JLabel("Materia");
		lbTituloMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloMateria.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lbTituloMateria.setBounds(627, 312, 121, 32);
		contentPane.add(lbTituloMateria);
		
		lblNewLabel = new JLabel("Alumnos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(126, 316, 181, 25);
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


	public JTable getTableMateria() {
		return tableMateria;
	}


	public JScrollPane getScrollMateria() {
		return scrollMateria;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public JTextField getTfDniAlumno() {
		return tfDniAlumno;
	}


	public JTextField getTfCodigoMateria() {
		return tfCodMateria;
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


	public JTextField getTfNota() {
		return tfNota;
	}


	public JTable getTableAlumno() {
		return tableAlumno;
	}


	public JLabel getLbTituloMateria() {
		return lbTituloMateria;
	}


	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}




}	
	
