package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloMateria;
import Modelo.ModeloProfesor;
import Vista.MenuPrincipal;
import Vista.VistaMateria;


public class ControladorMateria implements ActionListener, MouseListener  {
	VistaMateria vistaMateria;
	ModeloMateria modeloMateria;
	MenuPrincipal menuPrincipal;
	private DefaultTableModel materiaTableModel;
	private DefaultTableModel profesorTableModel;
	private ArrayList<ModeloMateria> materias;

	
	public ControladorMateria(VistaMateria vistaMateria, ModeloMateria modeloMateria, MenuPrincipal menuPrincipal)  {
		this.vistaMateria=vistaMateria;
		this.modeloMateria=modeloMateria;
		this.menuPrincipal = menuPrincipal;
		EscucharBotones();
		RecargarTabla(vistaMateria.getTable());
		RecargarTablaProfesor(this.vistaMateria.getTableProfesor());
		this.vistaMateria.setVisible(true);
	}
	
	
	public void EscucharBotones() {
		this.vistaMateria.setLocationRelativeTo(null);
	    this.vistaMateria.getBtnVolver().addActionListener(this);
	    this.vistaMateria.getBtnIngresar().addActionListener(this);
	    this.vistaMateria.getBtnModificar().addActionListener(this);
	    this.vistaMateria.getBtnEliminar().addActionListener(this);
	    this.vistaMateria.getTable().addMouseListener(this);
	    
	     

    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.vistaMateria.getBtnVolver())){
			this.menuPrincipal.setVisible(true);
			vistaMateria.dispose();
		
			//BOTON INGRESAR
		}else if(e.getSource().equals(this.vistaMateria.getBtnIngresar())){
			
			if(this.vistaMateria.getTfCodigo().getText().length() != 0 && 
			   this.vistaMateria.getTfNombre().getText().length() !=0 &&
			   this.vistaMateria.getTfDniProfesor().getText().length() !=0 &&
			   ValidarDatosNumericos() && 
			   this.modeloMateria.VerificarExistenciaProfesor(Integer.parseInt(this.vistaMateria.getTfDniProfesor().getText()))&&
			   !this.modeloMateria.VerificarExistenciaRepetida(Integer.parseInt(this.vistaMateria.getTfDniProfesor().getText()), this.vistaMateria.getTfNombre().getText(), this.vistaMateria.getTfCodigo().getText())
			   )
			{
				
				this.modeloMateria.setCodigo(this.vistaMateria.getTfCodigo().getText());
	            this.modeloMateria.setNombre(this.vistaMateria.getTfNombre().getText());
	            this.modeloMateria.setDniProfesor(this.vistaMateria.getTfDniProfesor().getText());
	            
				
	            this.modeloMateria.CargarDatos(this.modeloMateria);
				
				RecargarTabla(this.vistaMateria.getTable());
				JOptionPane.showMessageDialog(null,"La materia "+this.vistaMateria.getTfNombre().getText()+" fue cargado correctamente.");
				LimpiarTextField();
				
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-El ID Profesor puede encontrarse repetido o no es numerico");
			}
		

			
			//BOTON MODIFICAR		
		}else if(e.getSource().equals(this.vistaMateria.getBtnModificar())){
			if(this.vistaMateria.getTfCodigo().getText().length() != 0 && 
					   this.vistaMateria.getTfNombre().getText().length() !=0 &&
					   this.vistaMateria.getTfDniProfesor().getText().length() !=0 && 
					   ValidarDatosNumericos() && 
					   this.modeloMateria.VerificarExistenciaProfesor(Integer.parseInt(this.vistaMateria.getTfDniProfesor().getText()))&&
					   !this.modeloMateria.VerificarExistenciaRepetida(Integer.parseInt(this.vistaMateria.getTfDniProfesor().getText()), this.vistaMateria.getTfNombre().getText(), this.vistaMateria.getTfCodigo().getText())
					   )
					{
			
			this.modeloMateria.setCodigo(this.vistaMateria.getTfCodigo().getText());
	        this.modeloMateria.setNombre(this.vistaMateria.getTfNombre().getText());
	        this.modeloMateria.setDniProfesor(this.vistaMateria.getTfDniProfesor().getText());
            
            this.modeloMateria.ModificarDatos(this.modeloMateria);
          
			RecargarTabla(this.vistaMateria.getTable());
			JOptionPane.showMessageDialog(null,"La materia "+this.vistaMateria.getTfNombre().getText()+" fue modificado correctamente.");
			LimpiarTextField();
			
			}else{
				LimpiarTextField();
				JOptionPane.showMessageDialog(null, "-Asegurese de completar todos los campos correctamente \n"
						+ "-El ID Profesor puede encontrarse repetido o no es numerico");
			}
			
			
			
		}else if(e.getSource().equals(this.vistaMateria.getBtnEliminar())) {
			
			this.modeloMateria.BajaAlumno(Integer.parseInt(this.vistaMateria.getTfDniProfesor().getText()));
			
			RecargarTabla(this.vistaMateria.getTable());
			JOptionPane.showMessageDialog(null,"La materia "+this.vistaMateria.getTfNombre().getText()+" fue eliminada correctamente.");
			LimpiarTextField();
		}
		
	}
		
	
	


	public void RecargarTabla(JTable table)  {
		String[] columna = {"Codigo", "Nombre","DNI Profesor","Nombre","Apellido"};
	
		materias = this.modeloMateria.ArrayDatosMateria();
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
	
	public void RecargarTablaProfesor(JTable table)  {
		ArrayList<ModeloProfesor> profesores;
		ModeloProfesor modeloProfesor = new ModeloProfesor();
		
		String[] columna = {"DNI","Nombre", "Apellido","Fecha de Nacimiento", "Domicilio", "Telefono"};
		
		profesores = modeloProfesor.ArrayDatosProfesor();
		
		this.profesorTableModel=new DefaultTableModel(null, columna);
		
		//Limpia todos los datos de la tabla
		for(int i=this.profesorTableModel.getRowCount(); i>0; i--){
	           this.profesorTableModel.removeRow(i-1);
	    }
		
		
		//this.limpiarTabla(this.alumnoVista.getjTableAlumno());
        Object datos[] = new Object[6];
        if (profesores.size() > 0) {
            for (int i = 0; i < profesores.size(); i++) {
            	//datos[0] = profesores.get(i).getId();
                datos[0] = profesores.get(i).getDni();
                datos[1] = profesores.get(i).getNombre();
                datos[2] = profesores.get(i).getApellido();
                datos[3] = profesores.get(i).getFechaNac();
                datos[4] = profesores.get(i).getDomicilio();
                datos[5] = profesores.get(i).getTelefono();
                this.profesorTableModel.addRow(datos);
            }
        }

        table.setModel(this.profesorTableModel);
        profesores.clear();
		
	}
	
	
	private void LimpiarTextField(){		
        this.vistaMateria.getTfCodigo().setText("");
        this.vistaMateria.getTfNombre().setText("");
        this.vistaMateria.getTfDniProfesor().setText("");
        
    }
	
	
	
	
	@Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.vistaMateria.getTable().rowAtPoint(e.getPoint());
            if (fila > -1) {
            	
                this.vistaMateria.getTfCodigo().setText(String.valueOf(this.vistaMateria.getTable().getValueAt(fila, 0)));
                this.vistaMateria.getTfNombre().setText(String.valueOf(this.vistaMateria.getTable().getValueAt(fila, 1)));
                this.vistaMateria.getTfDniProfesor().setText(String.valueOf(this.vistaMateria.getTable().getValueAt(fila, 2)));
                
               
            }
        }
       
    }
	

	public boolean ValidarDatosNumericos() {
		String codigo=this.vistaMateria.getTfCodigo().getText();
		String id_profesor=this.vistaMateria.getTfDniProfesor().getText();
		
		if(codigo.matches("\\d*") && id_profesor.matches("\\d*")) {
			
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