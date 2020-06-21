package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloCarrera;
import Vista.VistaCarrera;
import Vista.MenuPrincipal;

public class ControladorCarrera implements ActionListener, MouseListener {
	VistaCarrera vistaCarrera;
	ModeloCarrera modeloCarrera;
	MenuPrincipal menuPrincipal;

	private DefaultTableModel tableModel;
	private ArrayList<ModeloCarrera> carreras;

	public ControladorCarrera(VistaCarrera vistaCarrera, ModeloCarrera modeloCarrera, MenuPrincipal menuPrincipal) {
		this.vistaCarrera = vistaCarrera;
		this.modeloCarrera = modeloCarrera;
		this.menuPrincipal = menuPrincipal;
		EscucharBotones();
		RecargarTabla(vistaCarrera.getTable());
		this.vistaCarrera.setVisible(true);
	}

	public void EscucharBotones() {
		this.vistaCarrera.setLocationRelativeTo(null);
		this.vistaCarrera.getBtnVolver().addActionListener(this);
		this.vistaCarrera.getBtnIngresar().addActionListener(this);
		this.vistaCarrera.getBtnModificar().addActionListener(this);
		this.vistaCarrera.getBtnEliminar().addActionListener(this);
		this.vistaCarrera.getTable().addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.vistaCarrera.getBtnVolver())) {
			this.menuPrincipal.setVisible(true);
			vistaCarrera.dispose();

			// BOTON INGRESAR
		} else if (e.getSource().equals(this.vistaCarrera.getBtnIngresar())) {
			if (this.vistaCarrera.getTfCodigo().getText().length() != 0
					&& this.vistaCarrera.getTfNombre().getText().length() != 0
					&& this.vistaCarrera.getTfDuracion().getText().length() != 0 && ValidarDatosNumericos()
					&& !this.modeloCarrera.VerificarExistencia(this.vistaCarrera.getTfCodigo().getText()))
			{

				this.modeloCarrera.setCodigo(this.vistaCarrera.getTfCodigo().getText());
				this.modeloCarrera.setNombre(this.vistaCarrera.getTfNombre().getText());
				this.modeloCarrera.setDuracion(this.vistaCarrera.getTfDuracion().getText());

				this.modeloCarrera.CargarDatos(this.modeloCarrera);

				RecargarTabla(this.vistaCarrera.getTable());
				JOptionPane.showMessageDialog(null,
						"La carrera " + this.vistaCarrera.getTfNombre().getText() + " fue cargado correctamente.");
				LimpiarTextField();

			} else {
				LimpiarTextField();
				JOptionPane.showMessageDialog(null,
						"-Asegurese de completar todos los campos correctamente \n"
								+ "-Los campos codigo y duracion deben ser numericos \n"
								+ "-El codigo puede encontrarse repetido");
			}

			// BOTON MODIFICAR
		} else if (e.getSource().equals(this.vistaCarrera.getBtnModificar())) {
				if (this.vistaCarrera.getTfCodigo().getText().length() != 0
						&& this.vistaCarrera.getTfNombre().getText().length() != 0
						&& this.vistaCarrera.getTfDuracion().getText().length() != 0 
						&& ValidarDatosNumericos() 
						&& this.modeloCarrera.VerificarExistencia(this.vistaCarrera.getTfCodigo().getText()))
				{

					this.modeloCarrera.setCodigo(this.vistaCarrera.getTfCodigo().getText());
					this.modeloCarrera.setNombre(this.vistaCarrera.getTfNombre().getText());
					this.modeloCarrera.setDuracion(this.vistaCarrera.getTfDuracion().getText());

					this.modeloCarrera.ModificarDatos(this.modeloCarrera);

					RecargarTabla(this.vistaCarrera.getTable());
					JOptionPane.showMessageDialog(null,
							"La carrera " + this.vistaCarrera.getTfNombre().getText() + " fue cargado correctamente.");
					LimpiarTextField();

				} else {
					LimpiarTextField();
					JOptionPane.showMessageDialog(null,
							"-Asegurese de completar todos los campos correctamente \n"
									+ "-Los campos codigo y duracion deben ser numericos \n"
									+ "-El codigo puede encontrarse repetido");
				}


			

			// ELIMINAR
		} else if (e.getSource().equals(this.vistaCarrera.getBtnEliminar())) {

			this.modeloCarrera.BajaCarrera(this.vistaCarrera.getTfCodigo().getText());

			RecargarTabla(this.vistaCarrera.getTable());
			JOptionPane.showMessageDialog(null, "La carrera " + this.vistaCarrera.getTfNombre().getText() + " fue eliminado correctamente.");
			LimpiarTextField();
		}

	}

	public void RecargarTabla(JTable table) {
		String[] columna = { "Codigo", "Nombre", "Duracion"};
		carreras = this.modeloCarrera.ArrayDatosCarrera();
		this.tableModel = new DefaultTableModel(null, columna);

		// Limpia todos los datos de la tabla
		for (int i = 0; i < this.tableModel.getRowCount(); i++) {
			this.tableModel.removeRow(i);
		}

		// this.limpiarTabla(this.alumnoVista.getjTableAlumno());
		Object datos[] = new Object[3];
		if (carreras.size() > 0) {
			for (int i = 0; i < carreras.size(); i++) {
				datos[0] = carreras.get(i).getCodigo();
				datos[1] = carreras.get(i).getNombre();
				datos[2] = carreras.get(i).getDuracion();
				this.tableModel.addRow(datos);
			}
		}

		table.setModel(this.tableModel);
		carreras.clear();

	}

	private void LimpiarTextField() {
		this.vistaCarrera.getTfCodigo().setText("");
		this.vistaCarrera.getTfNombre().setText("");
		this.vistaCarrera.getTfDuracion().setText("");
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			int fila = this.vistaCarrera.getTable().rowAtPoint(e.getPoint());
			if (fila > -1) {
				this.vistaCarrera.getTfCodigo().setText(String.valueOf(this.vistaCarrera.getTable().getValueAt(fila, 0)));
				this.vistaCarrera.getTfNombre().setText(String.valueOf(this.vistaCarrera.getTable().getValueAt(fila, 1)));
				this.vistaCarrera.getTfDuracion().setText(String.valueOf(this.vistaCarrera.getTable().getValueAt(fila, 2)));
				
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean ValidarDatosNumericos() {
		String codigo = this.vistaCarrera.getTfCodigo().getText();
		String duracion = this.vistaCarrera.getTfDuracion().getText();

		if (codigo.matches("\\d*") && duracion.matches("\\d*")) {

			return true;
		}

		return false;
	}

	

}
