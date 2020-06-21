package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloAlumno;
import Modelo.ModeloInscripcion;
import Modelo.ModeloCarrera;

import Vista.MenuPrincipal;
import Vista.VistaInscripcion;


public class ControladorInscripcion implements ActionListener, MouseListener {
	VistaInscripcion vistaInscripcion;
	ModeloInscripcion modeloInscripcion;
	MenuPrincipal menuPrincipal;
	private DefaultTableModel inscripcionTableModel;
	private DefaultTableModel alumnoTableModel;
	private DefaultTableModel carreraTableModel;
	private ArrayList<ModeloInscripcion> inscripciones;
	private java.util.Date fechaDate=null;
	
	public ControladorInscripcion(VistaInscripcion vistaInscripcion,ModeloInscripcion modeloInscripcion,MenuPrincipal menu) {
		this.vistaInscripcion=vistaInscripcion;
		this.modeloInscripcion=modeloInscripcion;
		this.menuPrincipal=menu;
		
		
		EscucharBotones();
		RecargarTabla(this.vistaInscripcion.getTable());
		RecargarTablaAlumno(this.vistaInscripcion.getTableAlumno());
		RecargarTablaCarrera(this.vistaInscripcion.getTableCarrera());
		
		this.vistaInscripcion.setVisible(true);
	}
	
	
	public void EscucharBotones() {
		this.vistaInscripcion.setLocationRelativeTo(null);
		this.vistaInscripcion.getBtnVolver().addActionListener(this);
	    this.vistaInscripcion.getBtnIngresar().addActionListener(this);
	    this.vistaInscripcion.getBtnModificar().addActionListener(this);
	    this.vistaInscripcion.getBtnEliminar().addActionListener(this);
	    this.vistaInscripcion.getTable().addMouseListener(this);
	   

    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.vistaInscripcion.getBtnVolver())){
			this.menuPrincipal.setVisible(true);
			vistaInscripcion.dispose();
		
			//BOTON INGRESAR
		}else if(e.getSource().equals(this.vistaInscripcion.getBtnIngresar())){

			if(this.vistaInscripcion.getTfDniAlumno().getText().length() != 0 && 
			   this.vistaInscripcion.getTfCodigoCarrera().getText().length() !=0 &&
			   ValidarDatosNumericos() && 
			   !this.modeloInscripcion.VerificarExistenciaAlumno(this.vistaInscripcion.getTfDniAlumno().getText(),this.vistaInscripcion.getTfCodigoCarrera().getText())
			   
			   )
			{
				
				this.modeloInscripcion.setDniAlumno(this.vistaInscripcion.getTfDniAlumno().getText());
	            this.modeloInscripcion.setCodigoCarrera(this.vistaInscripcion.getTfCodigoCarrera().getText());
	            
	            fechaDate = this.vistaInscripcion.getDateChooser().getDate();
	            Date fechasql = new Date(fechaDate.getTime());
	   
	            this.modeloInscripcion.setFecha(fechasql);
	            //ValidarFecha(fechasql);
	            
				
	            this.modeloInscripcion.CargarDatos(this.modeloInscripcion);
				
				RecargarTabla(this.vistaInscripcion.getTable());
				JOptionPane.showMessageDialog(null,"La inscripcion del alumno con DNI "+this.vistaInscripcion.getTfDniAlumno().getText()+" fue cargado correctamente.");
				LimpiarTextField();
				
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-El DNI Alumno puede encontrarse repetido o no es numerico");
			}
		

			
			//BOTON MODIFICAR		
		}else if(e.getSource().equals(this.vistaInscripcion.getBtnModificar())){

			if(this.vistaInscripcion.getTfDniAlumno().getText().length() != 0 && 
					   this.vistaInscripcion.getTfCodigoCarrera().getText().length() !=0 &&
					   ValidarDatosNumericos() &&
					   !this.modeloInscripcion.VerificarExistenciaAlumno(this.vistaInscripcion.getTfDniAlumno().getText(),this.vistaInscripcion.getTfCodigoCarrera().getText())
					   //!this.modeloCursado.VerificarExistenciaRepetida(Integer.parseInt(this.vistaCursado.getTfIDProfesor().getText()), this.vistaCursado.getTfNombre().getText(), this.vistaCursado.getTfCodigoMateria().getText())
					   )
					{
				this.modeloInscripcion.setCodigo(this.vistaInscripcion.getTfCodigo().getText());
				this.modeloInscripcion.setDniAlumno(this.vistaInscripcion.getTfDniAlumno().getText());
	            this.modeloInscripcion.setCodigoCarrera(this.vistaInscripcion.getTfCodigoCarrera().getText());
	            
	            fechaDate = this.vistaInscripcion.getDateChooser().getDate();
	            Date fechasql = new Date(fechaDate.getTime());
	            this.modeloInscripcion.setFecha(fechasql);
	            
            
            this.modeloInscripcion.ModificarInscripcion(this.modeloInscripcion);
          
			RecargarTabla(this.vistaInscripcion.getTable());
			JOptionPane.showMessageDialog(null,"La inscripcion del alumno DNI "+this.vistaInscripcion.getTfDniAlumno().getText()+" fue modificado correctamente.");
			LimpiarTextField();
			
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-El DNI Alumno puede encontrarse repetido o no es numerico");
			}
			
			
			
		}else if(e.getSource().equals(this.vistaInscripcion.getBtnEliminar())) {
			
			this.modeloInscripcion.BajaInscripcion(this.vistaInscripcion.getTfCodigo().getText());
			
			RecargarTabla(this.vistaInscripcion.getTable());
			JOptionPane.showMessageDialog(null,"La inscripcion del alumno DNI "+this.vistaInscripcion.getTfDniAlumno().getText()+" fue eliminada correctamente.");
			LimpiarTextField();
		}
		
	}
		
	
	


	public void RecargarTabla(JTable table)  {
		String[] columna = {"Codigo","DNI","Nombre","Apellido","Telefono","Codigo", "Carrera","Duracion","Fecha Inscripcion"};
	
		inscripciones = this.modeloInscripcion.ArrayDatosInscripcion();
		this.inscripcionTableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=this.inscripcionTableModel.getRowCount(); i>0; i--){
	           this.inscripcionTableModel.removeRow(i-1);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[9];
        if (inscripciones.size() > 0) {
            for (int i = 0; i < inscripciones.size(); i++) {
            	datos[0] = inscripciones.get(i).getCodigo();
                datos[1] = inscripciones.get(i).getDniAlumno();
                datos[2] = inscripciones.get(i).getNombre();
                datos[3] = inscripciones.get(i).getApellido();
                datos[4] = inscripciones.get(i).getTelefono();
                datos[5] = inscripciones.get(i).getCodigoCarrera();
                datos[6] = inscripciones.get(i).getNombreCarrera();
                datos[7] = inscripciones.get(i).getDuracion();
                datos[8] = inscripciones.get(i).getFecha();

                this.inscripcionTableModel.addRow(datos);
            }
        }

        table.setModel(this.inscripcionTableModel);
        inscripciones.clear();
		
	}
	
	public void RecargarTablaAlumno(JTable table)  {
		ArrayList<ModeloAlumno> alumnos;
		ModeloAlumno modeloAlumno = new ModeloAlumno();
		
		String[] columna = {"DNI","Nombre", "Apellido","Fecha de Nacimiento", "Domicilio", "Telefono"};
		
		alumnos = modeloAlumno.ArrayDatosAlumno();
		
		this.alumnoTableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=this.alumnoTableModel.getRowCount(); i>0; i--){
	           this.alumnoTableModel.removeRow(i-1);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[6];
        if (alumnos.size() > 0) {
            for (int i = 0; i < alumnos.size(); i++) {
            	//datos[0] = alumnos.get(i).getId();
            	datos[0] = alumnos.get(i).getDni();
                datos[1] = alumnos.get(i).getNombre();
                datos[2] = alumnos.get(i).getApellido();
                datos[3] = alumnos.get(i).getFechaNac();
                datos[4] = alumnos.get(i).getDomicilio();
                datos[5] = alumnos.get(i).getTelefono();
                this.alumnoTableModel.addRow(datos);
            }
        }

        table.setModel(this.alumnoTableModel);
        alumnos.clear();
		
	}
	
	
	
	
	
	public void RecargarTablaCarrera(JTable table)  {
		ArrayList<ModeloCarrera> carreras;
		ModeloCarrera modeloCarrera = new ModeloCarrera();
		String[] columna = {"Codigo","Nombre","Duracion"};
	
		carreras = modeloCarrera.ArrayDatosCarrera();
		this.carreraTableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=this.carreraTableModel.getRowCount(); i>0; i--){
	           this.carreraTableModel.removeRow(i-1);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[3];
        if (carreras.size() > 0) {
            for (int i = 0; i < carreras.size(); i++) {
                datos[0] = carreras.get(i).getCodigo();
                datos[1] = carreras.get(i).getNombre();
                datos[2] = carreras.get(i).getDuracion();
               
                
               
                this.carreraTableModel.addRow(datos);
            }
        }

        table.setModel(this.carreraTableModel);
        carreras.clear();
		
	}
	
	
	private void LimpiarTextField(){
		this.vistaInscripcion.getTfCodigo().setText("");
		this.vistaInscripcion.getTfDniAlumno().setText("");
        this.vistaInscripcion.getTfCodigoCarrera().setText("");
                
    }
	
	
	
	
	@Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
        	
        	
            int fila = this.vistaInscripcion.getTable().rowAtPoint(e.getPoint());
           
            
            if (fila > -1) {
           
            	this.vistaInscripcion.getTfCodigo().setText(String.valueOf(this.vistaInscripcion.getTable().getValueAt(fila, 0)));
            	this.vistaInscripcion.getTfDniAlumno().setText(String.valueOf(this.vistaInscripcion.getTable().getValueAt(fila, 1)));
                this.vistaInscripcion.getTfCodigoCarrera().setText(String.valueOf(this.vistaInscripcion.getTable().getValueAt(fila, 5)));
                this.vistaInscripcion.getDateChooser().setDate((java.util.Date)this.vistaInscripcion.getTable().getValueAt(fila, 8));
            
          
            }
            
            
        
        }
       
    }
	

	

	public boolean ValidarDatosNumericos() {
		String dniAlumno=this.vistaInscripcion.getTfDniAlumno().getText();
		String codigoCarrera=this.vistaInscripcion.getTfCodigoCarrera().getText();


		if(dniAlumno.matches("\\d*") && codigoCarrera.matches("\\d*") ) {
			
		return true;
			
		}
		
		return false;
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


	
	
}
