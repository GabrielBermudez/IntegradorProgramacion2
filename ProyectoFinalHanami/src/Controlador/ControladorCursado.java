package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloAlumno;
import Modelo.ModeloCursado;
import Modelo.ModeloMateria;

import Vista.MenuPrincipal;
import Vista.VistaCursado;


public class ControladorCursado implements ActionListener, MouseListener {
	VistaCursado vistaCursado;
	ModeloCursado modeloCursado;
	MenuPrincipal menuPrincipal;
	private DefaultTableModel notasTableModel;
	private DefaultTableModel alumnoTableModel;
	private DefaultTableModel materiaTableModel;
	private ArrayList<ModeloCursado> notas;
	
	public ControladorCursado(VistaCursado vistaCursado,ModeloCursado modeloCursado,MenuPrincipal menu) {
		this.vistaCursado=vistaCursado;
		this.modeloCursado=modeloCursado;
		this.menuPrincipal=menu;
		
		
		EscucharBotones();
		RecargarTabla(this.vistaCursado.getTable());
		RecargarTablaAlumno(this.vistaCursado.getTableAlumno());
		RecargarTablaMateria(this.vistaCursado.getTableMateria());
		
		this.vistaCursado.setVisible(true);
	}
	
	
	public void EscucharBotones() {
		this.vistaCursado.setLocationRelativeTo(null);
		this.vistaCursado.getBtnVolver().addActionListener(this);
	    this.vistaCursado.getBtnIngresar().addActionListener(this);
	    this.vistaCursado.getBtnModificar().addActionListener(this);
	    this.vistaCursado.getBtnEliminar().addActionListener(this);
	    this.vistaCursado.getTable().addMouseListener(this);
	     

    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.vistaCursado.getBtnVolver())){
			this.menuPrincipal.setVisible(true);
			vistaCursado.dispose();
		
			//BOTON INGRESAR
		}else if(e.getSource().equals(this.vistaCursado.getBtnIngresar())){

			if(this.vistaCursado.getTfDniAlumno().getText().length() != 0 && 
			   this.vistaCursado.getTfCodigoMateria().getText().length() !=0 &&
			   this.vistaCursado.getTfNota().getText().length() !=0 &&
			   ValidarDatosNumericos() && 
			   !this.modeloCursado.VerificarExistenciaAlumno(Integer.parseInt(this.vistaCursado.getTfDniAlumno().getText()),Integer.parseInt(this.vistaCursado.getTfCodigoMateria().getText()))
			   //!this.modeloCursado.VerificarExistenciaRepetida(Integer.parseInt(this.vistaCursado.getTfIDProfesor().getText()), this.vistaCursado.getTfNombre().getText(), this.vistaCursado.getTfCodigoMateria().getText())
			   )
			{
				
				this.modeloCursado.setDniAlumno(this.vistaCursado.getTfDniAlumno().getText());
	            this.modeloCursado.setCodigoMateria(this.vistaCursado.getTfCodigoMateria().getText());
	            this.modeloCursado.setNota(Integer.parseInt(this.vistaCursado.getTfNota().getText()));
	            
				
	            this.modeloCursado.CargarDatos(this.modeloCursado);
				
				RecargarTabla(this.vistaCursado.getTable());
				JOptionPane.showMessageDialog(null,"La nota del alumno DNI "+this.vistaCursado.getTfDniAlumno().getText()+" fue cargado correctamente.");
				LimpiarTextField();
				
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-El ID Profesor puede encontrarse repetido o no es numerico");
			}
		

			
			//BOTON MODIFICAR		
		}else if(e.getSource().equals(this.vistaCursado.getBtnModificar())){

			if(this.vistaCursado.getTfDniAlumno().getText().length() != 0 && 
					   this.vistaCursado.getTfCodigoMateria().getText().length() !=0 &&
					   this.vistaCursado.getTfNota().getText().length() !=0 &&
					   ValidarDatosNumericos() && 
					   !this.modeloCursado.VerificarExistenciaAlumno(Integer.parseInt(this.vistaCursado.getTfDniAlumno().getText()),Integer.parseInt(this.vistaCursado.getTfCodigoMateria().getText()))
					   //!this.modeloCursado.VerificarExistenciaRepetida(Integer.parseInt(this.vistaCursado.getTfIDProfesor().getText()), this.vistaCursado.getTfNombre().getText(), this.vistaCursado.getTfCodigoMateria().getText())
					   )
					{
				this.modeloCursado.setDniAlumno(this.vistaCursado.getTfDniAlumno().getText());
	            this.modeloCursado.setCodigoMateria(this.vistaCursado.getTfCodigoMateria().getText());
	            this.modeloCursado.setNota(Integer.parseInt(this.vistaCursado.getTfNota().getText()));
	            
            
            this.modeloCursado.ModificarDatos(this.modeloCursado);
          
			RecargarTabla(this.vistaCursado.getTable());
			JOptionPane.showMessageDialog(null,"La nota del alumno DNI "+this.vistaCursado.getTfDniAlumno().getText()+" fue modificado correctamente.");
			LimpiarTextField();
			
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-El ID Profesor puede encontrarse repetido o no es numerico");
			}
			
			
			
		}else if(e.getSource().equals(this.vistaCursado.getBtnEliminar())) {
			
			this.modeloCursado.BajaNota(Integer.parseInt(this.vistaCursado.getTfDniAlumno().getText()));
			
			RecargarTabla(this.vistaCursado.getTable());
			JOptionPane.showMessageDialog(null,"La nota del alumno DNI "+this.vistaCursado.getTfDniAlumno().getText()+" fue eliminada correctamente.");
			LimpiarTextField();
		}
		
	}
		
	
	


	public void RecargarTabla(JTable table)  {
		String[] columna = {"DNI Alumno", "Nombre","Apellido","Codigo Materia","Nombre Materia","Nota","DNI Profesor", "Nombre","Apellido","Telefono"};
	
		notas = this.modeloCursado.ArrayDatosNotas();
		this.notasTableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=this.notasTableModel.getRowCount(); i>0; i--){
	           this.notasTableModel.removeRow(i-1);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[10];
        if (notas.size() > 0) {
            for (int i = 0; i < notas.size(); i++) {
                datos[0] = notas.get(i).getDniAlumno();
                datos[1] = notas.get(i).getNombre();
                datos[2] = notas.get(i).getApellido();
                datos[3] = notas.get(i).getCodigoMateria();
                datos[4] = notas.get(i).getNombreMateria();
                datos[5] = notas.get(i).getNota();
                datos[6] = notas.get(i).getDniProfesor();
                datos[7] = notas.get(i).getNombreProfesor();
                datos[8] = notas.get(i).getApellidoProfesor();
                datos[9] = notas.get(i).getTelefonoProfesor();
               
                this.notasTableModel.addRow(datos);
            }
        }

        table.setModel(this.notasTableModel);
        notas.clear();
		
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
	
	
	
	
	
	public void RecargarTablaMateria(JTable table)  {
		ArrayList<ModeloMateria> materias;
		ModeloMateria modeloMateria = new ModeloMateria();
		String[] columna = {"Codigo","Nombre Materia","DNI Profesor","Nombre","Apellido"};
	
		materias = modeloMateria.ArrayDatosMateria();
		this.materiaTableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=this.materiaTableModel.getRowCount(); i>0; i--){
	           this.materiaTableModel.removeRow(i-1);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[5];
        if (materias.size() > 0) {
            for (int i = 0; i < materias.size(); i++) {
                datos[0] = materias.get(i).getCodigo();
                datos[1] = materias.get(i).getNombre();
                datos[2] = materias.get(i).getDniProfesor();
                datos[3] = materias.get(i).getNombreProfesor();
                datos[4] = materias.get(i).getApellidoProfesor();
                
               
                this.materiaTableModel.addRow(datos);
            }
        }

        table.setModel(this.materiaTableModel);
        materias.clear();
		
	}
	
	
	private void LimpiarTextField(){
		this.vistaCursado.getTfDniAlumno().setText("");
        this.vistaCursado.getTfCodigoMateria().setText("");
        this.vistaCursado.getTfNota().setText("");
        
    }
	
	
	
	
	@Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.vistaCursado.getTable().rowAtPoint(e.getPoint());

            if (fila > -1) {
            	this.vistaCursado.getTfDniAlumno().setText(String.valueOf(this.vistaCursado.getTable().getValueAt(fila, 0)));
                this.vistaCursado.getTfCodigoMateria().setText(String.valueOf(this.vistaCursado.getTable().getValueAt(fila, 3)));
                this.vistaCursado.getTfNota().setText(String.valueOf(this.vistaCursado.getTable().getValueAt(fila, 5)));
                
            }
        
        }
       
    }
	

	public boolean ValidarDatosNumericos() {
		String idAlumno=this.vistaCursado.getTfDniAlumno().getText();
		String idMateria=this.vistaCursado.getTfCodigoMateria().getText();
		String nota=this.vistaCursado.getTfNota().getText();
		
		if(idAlumno.matches("\\d*") && idMateria.matches("\\d*") && nota.matches("\\d*") ) {
			
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
