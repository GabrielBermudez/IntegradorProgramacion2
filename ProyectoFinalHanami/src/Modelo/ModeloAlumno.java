package Modelo;

import java.sql.*;
import java.util.ArrayList;


import BD.AlumnoDAO;
import Vista.VistaAlumno;
import Vista.MenuPrincipal;

public class ModeloAlumno {
	 private String nombre;
	 private String apellido;
	 private String dni;
	 private Date fechaNac;
	 private String domicilio;
	 private String telefono;
	
	 private AlumnoDAO alumnoDAO = new AlumnoDAO();
	public ModeloAlumno( ) {
	
		
	}
	
	
	




	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	public String getDni() {
		return dni;
	}

	
	public void setDni(String dni) {
		this.dni = dni;
	}

	
	public String getDomicilio() {
		return domicilio;
	}

	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getTelefono() {
		return telefono;
	}

	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public void CargarDatos(ModeloAlumno alumno) {
	     alumnoDAO.IngresarDatos(alumno);
	     
	   }
	
	
	
	public void ModificarDatos(ModeloAlumno alumno) {
		alumnoDAO.ModificarAlumno(alumno);
	}
	
	public ArrayList<ModeloAlumno> ArrayDatosAlumno()  {
		return alumnoDAO.ConsultaAlumnosDAO();
	}
	
	public void BajaAlumno(int id) {
		alumnoDAO.EliminarAlumno(id);
	}
	
	public boolean VerificarExistencia(String dni) {
		return alumnoDAO.ValidarExistencia(dni);
	}
	
}
