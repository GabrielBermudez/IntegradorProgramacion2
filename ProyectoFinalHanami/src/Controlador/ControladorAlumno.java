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

import Modelo.ModeloAlumno;
import Vista.VistaAlumno;
import Vista.MenuPrincipal;

public class ControladorAlumno implements ActionListener, MouseListener  {
	VistaAlumno alumnoVista;
	ModeloAlumno alumnoModelo;
	MenuPrincipal menuPrincipal;
	private DefaultTableModel tableModel;
	private ArrayList<ModeloAlumno> alumnos;
	private java.util.Date fechaDate=null;
	
	public ControladorAlumno(VistaAlumno alumnoVista, ModeloAlumno alumnoModelo, MenuPrincipal menuPrincipal)  {
		this.alumnoVista=alumnoVista;
		this.alumnoModelo=alumnoModelo;
		this.menuPrincipal = menuPrincipal;
		EscucharBotones();
		RecargarTabla(alumnoVista.getTable());
		this.alumnoVista.setVisible(true);
	}
	
	
	public void EscucharBotones() {
		this.alumnoVista.setLocationRelativeTo(null);
	    this.alumnoVista.getBtnVolver().addActionListener(this);
	    this.alumnoVista.getBtnIngresar().addActionListener(this);
	    this.alumnoVista.getBtnModificar().addActionListener(this);
	    this.alumnoVista.getBtnEliminar().addActionListener(this);
	    this.alumnoVista.getTable().addMouseListener(this);
	     

    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.alumnoVista.getBtnVolver())){
			this.menuPrincipal.setVisible(true);
			alumnoVista.dispose();
		
			//BOTON INGRESAR
		}else if(e.getSource().equals(this.alumnoVista.getBtnIngresar())){
			try {
			if(this.alumnoVista.getTfNombre().getText().length() != 0 && 
			   this.alumnoVista.getTfApellido().getText().length() !=0 &&
			   this.alumnoVista.getTfDomicilio().getText().length() !=0 &&
			   ValidarDatosNumericos() && !this.alumnoModelo.VerificarExistencia(this.alumnoVista.getTfDni().getText()))
				{
				
				this.alumnoModelo.setNombre(this.alumnoVista.getTfNombre().getText());
	            this.alumnoModelo.setApellido(this.alumnoVista.getTfApellido().getText());
	            this.alumnoModelo.setDni(this.alumnoVista.getTfDni().getText());
	            this.alumnoModelo.setDomicilio(this.alumnoVista.getTfDomicilio().getText());
	            this.alumnoModelo.setTelefono(this.alumnoVista.getTfTelefono().getText());
	            
	            fechaDate = this.alumnoVista.getDateChooserFecha().getDate();
	            Date fechasql = new Date(fechaDate.getTime());
	   
	            this.alumnoModelo.setFechaNac(fechasql);
	            ValidarFecha(fechasql);
				
	            this.alumnoModelo.CargarDatos(this.alumnoModelo);
				
				RecargarTabla(this.alumnoVista.getTable());
				JOptionPane.showMessageDialog(null,"Alumno "+this.alumnoVista.getTfApellido().getText()+" "+this.alumnoVista.getTfNombre().getText() + " fue cargado correctamente.");
				LimpiarTextField();
				
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null,"-Asegurese de completar todos los campos correctamente \n"
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
		}else if(e.getSource().equals(this.alumnoVista.getBtnModificar())){
			try {
			if(this.alumnoVista.getTfNombre().getText().length() != 0 && 
			   this.alumnoVista.getTfApellido().getText().length() !=0 &&
			   this.alumnoVista.getTfDomicilio().getText().length() !=0 &&
		       ValidarDatosNumericos()&& this.alumnoModelo.VerificarExistencia(this.alumnoVista.getTfDni().getText()))
				{
				
			
			this.alumnoModelo.setNombre(this.alumnoVista.getTfNombre().getText());
            this.alumnoModelo.setApellido(this.alumnoVista.getTfApellido().getText());
            this.alumnoModelo.setDni(this.alumnoVista.getTfDni().getText());
            this.alumnoModelo.setDomicilio(this.alumnoVista.getTfDomicilio().getText());
            this.alumnoModelo.setTelefono(this.alumnoVista.getTfTelefono().getText());
            
            fechaDate = this.alumnoVista.getDateChooserFecha().getDate();
            Date fechasql = new Date(fechaDate.getTime());
            System.out.println(fechasql);
            this.alumnoModelo.setFechaNac(fechasql);
            
            
            this.alumnoModelo.ModificarDatos(this.alumnoModelo);
          
			RecargarTabla(this.alumnoVista.getTable());
			JOptionPane.showMessageDialog(null,"Alumno "+this.alumnoVista.getTfApellido().getText()+" "+this.alumnoVista.getTfNombre().getText() + " fue modificado correctamente.");
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
			
			
		//ELIMINAR
		}else if(e.getSource().equals(this.alumnoVista.getBtnEliminar())) {
			
			this.alumnoModelo.BajaAlumno(Integer.parseInt(this.alumnoVista.getTfDni().getText())); //REVISAR
			
			RecargarTabla(this.alumnoVista.getTable());
			JOptionPane.showMessageDialog(null,"Alumno "+this.alumnoVista.getTfApellido().getText()+" "+this.alumnoVista.getTfNombre().getText() + " fue eliminado correctamente.");
			LimpiarTextField();
		}
		
	}
	
	public void RecargarTabla(JTable table)  {
		String[] columna = {"DNI", "Nombre","Apellido","Fecha de Nacimiento", "Domicilio", "Telefono"};
		alumnos = this.alumnoModelo.ArrayDatosAlumno();
		this.tableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=0; i<this.tableModel.getRowCount(); i++){
	           this.tableModel.removeRow(i);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[6];
        if (alumnos.size() > 0) {
            for (int i = 0; i < alumnos.size(); i++) {
            	datos[0] = alumnos.get(i).getDni();
                datos[1] = alumnos.get(i).getNombre();
                datos[2] = alumnos.get(i).getApellido();             
                datos[3] = alumnos.get(i).getFechaNac();
                datos[4] = alumnos.get(i).getDomicilio();
                datos[5] = alumnos.get(i).getTelefono();
                this.tableModel.addRow(datos);
            }
        }

        table.setModel(this.tableModel);
        alumnos.clear();
		
	}
	
	
	private void LimpiarTextField(){
	    this.alumnoVista.getTfDni().setText("");
        this.alumnoVista.getTfNombre().setText("");
        this.alumnoVista.getTfApellido().setText("");
        this.alumnoVista.getTfDomicilio().setText("");
        this.alumnoVista.getTfTelefono().setText("");
        //this.alumnoVista.getDateChooserFecha().set
    }
	
	
	@Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.alumnoVista.getTable().rowAtPoint(e.getPoint());
            if (fila > -1) {
            	this.alumnoVista.getTfDni().setText(String.valueOf(this.alumnoVista.getTable().getValueAt(fila, 0)));
                this.alumnoVista.getTfNombre().setText(String.valueOf(this.alumnoVista.getTable().getValueAt(fila, 1)));
                this.alumnoVista.getTfApellido().setText(String.valueOf(this.alumnoVista.getTable().getValueAt(fila, 2)));
                this.alumnoVista.getDateChooserFecha().setDate((java.util.Date) this.alumnoVista.getTable().getValueAt(fila, 3));
                this.alumnoVista.getTfDomicilio().setText(String.valueOf(this.alumnoVista.getTable().getValueAt(fila, 4)));
                this.alumnoVista.getTfTelefono().setText(String.valueOf(this.alumnoVista.getTable().getValueAt(fila, 5)));
                
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
		String dni=this.alumnoVista.getTfDni().getText();
		String telefono=this.alumnoVista.getTfTelefono().getText();
		
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
