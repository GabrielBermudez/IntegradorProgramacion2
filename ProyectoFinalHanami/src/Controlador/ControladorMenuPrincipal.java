package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Modelo.ModeloAlumno;
import Modelo.ModeloCarrera;
import Modelo.ModeloCursado;
import Modelo.ModeloInscripcion;
import Modelo.ModeloMateria;
import Modelo.ModeloMenuPrincipal;
import Modelo.ModeloProfesor;
import Vista.VistaAlumno;
import Vista.VistaCarrera;
import Vista.VistaCursado;
import Vista.VistaInscripcion;
import Vista.VistaMateria;
import Vista.VistaProfesor;
import Vista.MenuPrincipal;

public class ControladorMenuPrincipal implements ActionListener {
	
	MenuPrincipal menuPrincipal;
	ModeloMenuPrincipal modeloMenuPrincipal;
	
	
	public ControladorMenuPrincipal(MenuPrincipal menu, ModeloMenuPrincipal modelo) {
		this.menuPrincipal=menu;
		this.modeloMenuPrincipal = modelo;
		EscucharBotones();
		menu.setVisible(true);
	}
	
	public void EscucharBotones() {
		this.menuPrincipal.setLocationRelativeTo(null);
	    this.menuPrincipal.getBtnAlumno().addActionListener(this);
	    this.menuPrincipal.getBtnProfesor().addActionListener(this);
	    this.menuPrincipal.getBtnMateria().addActionListener(this);
	    this.menuPrincipal.getBtnCursado().addActionListener(this);
	    this.menuPrincipal.getBtnCarrera().addActionListener(this);
	    this.menuPrincipal.getBtnInscripcion().addActionListener(this);

    }

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.menuPrincipal.getBtnAlumno())){
			VistaAlumno alumnoVista = new VistaAlumno();
			ModeloAlumno alumnoModelo = new ModeloAlumno();
			
	
			ControladorAlumno alumnoControlador = new ControladorAlumno(alumnoVista,alumnoModelo,this.menuPrincipal);
			
		
			this.menuPrincipal.dispose();

		}else if(e.getSource().equals(this.menuPrincipal.getBtnProfesor())){
			VistaProfesor vistaProfesor = new VistaProfesor();
			ModeloProfesor modeloProfesor = new ModeloProfesor();
			
			ControladorProfesor controladorProfesor = new ControladorProfesor(vistaProfesor,modeloProfesor,this.menuPrincipal);
			
			this.menuPrincipal.dispose();

		}else if(e.getSource().equals(this.menuPrincipal.getBtnMateria())){
			
			VistaMateria vistaMateria = new VistaMateria();
			ModeloMateria modeloMateria = new ModeloMateria();
			
			ControladorMateria controladorMateria = new ControladorMateria(vistaMateria,modeloMateria,this.menuPrincipal);
			
			this.menuPrincipal.dispose();

		}else if(e.getSource().equals(this.menuPrincipal.getBtnCursado())){
			VistaCursado vistaCursado = new VistaCursado();
			ModeloCursado modeloCursado= new ModeloCursado();
			
			ControladorCursado controladorCursado = new ControladorCursado(vistaCursado,modeloCursado,this.menuPrincipal);
			
			this.menuPrincipal.dispose();
			
		}else if(e.getSource().equals(this.menuPrincipal.getBtnCarrera())){
			VistaCarrera vistaCarrera = new VistaCarrera();
			ModeloCarrera modeloCarrera = new ModeloCarrera();
			
			ControladorCarrera controladorCarrera = new ControladorCarrera(vistaCarrera, modeloCarrera, this.menuPrincipal);
			
			this.menuPrincipal.dispose();
			
		}else if(e.getSource().equals(this.menuPrincipal.getBtnInscripcion())){
			
			VistaInscripcion vistaInscripcion = new VistaInscripcion();
			ModeloInscripcion modeloInscripcion = new ModeloInscripcion();
			
			ControladorInscripcion controladorInscripcion = new ControladorInscripcion(vistaInscripcion,modeloInscripcion,this.menuPrincipal);
			
			this.menuPrincipal.dispose();

			
		}
		
		
		
	}
	
	
	
}
