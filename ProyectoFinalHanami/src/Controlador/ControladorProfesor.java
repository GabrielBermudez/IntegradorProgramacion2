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


import Modelo.ModeloProfesor;
import Vista.VistaProfesor;
import Vista.MenuPrincipal;

public class ControladorProfesor implements ActionListener, MouseListener  {
	VistaProfesor vistaProfesor;
	ModeloProfesor modeloProfesor;
	MenuPrincipal menuPrincipal;
	private DefaultTableModel tableModel;
	private ArrayList<ModeloProfesor> profesores;
	private java.util.Date fechaDate;
	
	public ControladorProfesor() {
		
	}
	
	public ControladorProfesor(VistaProfesor vistaProfesor, ModeloProfesor modeloProfesor, MenuPrincipal menuPrincipal)  {
		this.vistaProfesor=vistaProfesor;
		this.modeloProfesor=modeloProfesor;
		this.menuPrincipal = menuPrincipal;
		EscucharBotones();
		RecargarTabla(vistaProfesor.getTable());
		this.vistaProfesor.setVisible(true);
	}
	
	
	public void EscucharBotones() {
		this.vistaProfesor.setLocationRelativeTo(null);
	    this.vistaProfesor.getBtnVolver().addActionListener(this);
	    this.vistaProfesor.getBtnIngresar().addActionListener(this);
	    this.vistaProfesor.getBtnModificar().addActionListener(this);
	    this.vistaProfesor.getBtnEliminar().addActionListener(this);
	    this.vistaProfesor.getTable().addMouseListener(this);
	     

    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.vistaProfesor.getBtnVolver())){
			this.menuPrincipal.setVisible(true);
			vistaProfesor.dispose();
		
			//BOTON INGRESAR
		}else if(e.getSource().equals(this.vistaProfesor.getBtnIngresar())){
			try {
			//System.out.println(this.vistaProfesor.getDateChooserFechaNac().getDate());
			if(this.vistaProfesor.getTfNombre().getText().length() != 0 && 
			   this.vistaProfesor.getTfApellido().getText().length() !=0 &&
			   this.vistaProfesor.getTfDomicilio().getText().length() !=0 &&
			   ValidarDatosNumericos() && !this.modeloProfesor.VerificarExistencia(this.vistaProfesor.getTfDni().getText()))
			{
				
				this.modeloProfesor.setNombre(this.vistaProfesor.getTfNombre().getText());
	            this.modeloProfesor.setApellido(this.vistaProfesor.getTfApellido().getText());
	            this.modeloProfesor.setDni(this.vistaProfesor.getTfDni().getText());
	            this.modeloProfesor.setDomicilio(this.vistaProfesor.getTfDomicilio().getText());
	            this.modeloProfesor.setTelefono(this.vistaProfesor.getTfTelefono().getText());
				
	            fechaDate = this.vistaProfesor.getDateChooserFechaNac().getDate();
	            Date fechasql = new Date(fechaDate.getTime());
	            this.modeloProfesor.setFechaNac(fechasql);
	     
	            this.modeloProfesor.CargarDatos(this.modeloProfesor);
				
				RecargarTabla(this.vistaProfesor.getTable());
				JOptionPane.showMessageDialog(null,"Profesor "+this.vistaProfesor.getTfApellido().getText()+" "+this.vistaProfesor.getTfNombre().getText() + " fue cargado correctamente.");
				LimpiarTextField();
				
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-Los campos DNI y Telefono deben ser numericos \n"
						+ "-El DNI puede encontrarse repetido");
			}
			
			  } catch(NullPointerException ex) {
				  JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
							+ "-Los campos DNI y Telefono deben ser numericos \n"
							+ "-El DNI puede encontrarse repetido \n"
							+ "-Verifique haber ingresado una fecha");
			  }
			
            
			
			
			//BOTON MODIFICAR		
		}else if(e.getSource().equals(this.vistaProfesor.getBtnModificar())){
			try {
			if(this.vistaProfesor.getTfNombre().getText().length() != 0 && 
			   this.vistaProfesor.getTfApellido().getText().length() !=0 &&
			   this.vistaProfesor.getTfDomicilio().getText().length() !=0 &&
			   ValidarDatosNumericos() && this.modeloProfesor.VerificarExistencia(this.vistaProfesor.getTfDni().getText()))
			{
				
			this.modeloProfesor.setDni(this.vistaProfesor.getTfDni().getText());
			this.modeloProfesor.setNombre(this.vistaProfesor.getTfNombre().getText());
            this.modeloProfesor.setApellido(this.vistaProfesor.getTfApellido().getText());
            this.modeloProfesor.setDomicilio(this.vistaProfesor.getTfDomicilio().getText());
            this.modeloProfesor.setTelefono(this.vistaProfesor.getTfTelefono().getText());
            
            fechaDate = this.vistaProfesor.getDateChooserFechaNac().getDate();
            Date fechasql = new Date(fechaDate.getTime());
            
            this.modeloProfesor.setFechaNac(fechasql);
      
            
            this.modeloProfesor.ModificarDatos(this.modeloProfesor);
            
			RecargarTabla(this.vistaProfesor.getTable());
			JOptionPane.showMessageDialog(null,"Profesor "+this.vistaProfesor.getTfApellido().getText()+" "+this.vistaProfesor.getTfNombre().getText() + " fue modificado correctamente.");
			LimpiarTextField();
			
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-Los campos DNI y Telefono deben ser numericos \n"
						+ "-El DNI puede encontrarse repetido");
			}
			
			} catch(NullPointerException ex) {
			  JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-Los campos DNI y Telefono deben ser numericos \n"
						+ "-El DNI puede encontrarse repetido \n"
						+ "-Verifique haber ingresado una fecha");
			}
			
			
			
		}else if(e.getSource().equals(this.vistaProfesor.getBtnEliminar())) {
			
			this.modeloProfesor.BajaAlumno(Integer.parseInt(this.vistaProfesor.getTfDni().getText()));
			
			RecargarTabla(this.vistaProfesor.getTable());
			JOptionPane.showMessageDialog(null,"Profesor "+this.vistaProfesor.getTfApellido().getText()+" "+this.vistaProfesor.getTfNombre().getText() + " fue eliminado correctamente.");
			LimpiarTextField();
		}
		
	}
	
	public void RecargarTabla(JTable table)  {
		String[] columna = {"DNI","Nombre", "Apellido","Fecha de Nacimiento", "Domicilio", "Telefono"};
		
		profesores = this.modeloProfesor.ArrayDatosProfesor();
		this.tableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=this.tableModel.getRowCount(); i>0; i--){
	           this.tableModel.removeRow(i-1);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[6];
        if (profesores.size() > 0) {
            for (int i = 0; i < profesores.size(); i++) {
            	datos[0] = profesores.get(i).getDni();
                datos[1] = profesores.get(i).getNombre();
                datos[2] = profesores.get(i).getApellido();
                datos[3] = profesores.get(i).getFechaNac();
                datos[4] = profesores.get(i).getDomicilio();
                datos[5] = profesores.get(i).getTelefono();
                this.tableModel.addRow(datos);
            }
        }

        table.setModel(this.tableModel);
        profesores.clear();
		
	}
	
	
	private void LimpiarTextField(){
		
        this.vistaProfesor.getTfDni().setText("");
        this.vistaProfesor.getTfNombre().setText("");
        this.vistaProfesor.getTfApellido().setText("");
        this.vistaProfesor.getTfDomicilio().setText("");
        this.vistaProfesor.getTfTelefono().setText("");
    }
	
	
	@Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.vistaProfesor.getTable().rowAtPoint(e.getPoint());
            if (fila > -1) {
            	this.vistaProfesor.getTfDni().setText(String.valueOf(this.vistaProfesor.getTable().getValueAt(fila, 0)));
                this.vistaProfesor.getTfNombre().setText(String.valueOf(this.vistaProfesor.getTable().getValueAt(fila, 1)));
                this.vistaProfesor.getTfApellido().setText(String.valueOf(this.vistaProfesor.getTable().getValueAt(fila, 2)));
                this.vistaProfesor.getDateChooserFechaNac().setDate((Date)this.vistaProfesor.getTable().getValueAt(fila, 3));
                this.vistaProfesor.getTfDomicilio().setText(String.valueOf(this.vistaProfesor.getTable().getValueAt(fila, 4)));
                this.vistaProfesor.getTfTelefono().setText(String.valueOf(this.vistaProfesor.getTable().getValueAt(fila, 5)));
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
		String dni=this.vistaProfesor.getTfDni().getText();
		String telefono=this.vistaProfesor.getTfTelefono().getText();
		
		if((dni.length() > 6 && dni.length() < 9) && (dni.matches("\\d*") && telefono.matches("\\d*"))) {
			
		return true;
			
		}
		
		return false;
	}
	

	public boolean ValidarFecha(Date fec) {
        System.out.println("TXT = " + fec);
        boolean fecValida = true;
        return fecValida;
    }
	
	
}
