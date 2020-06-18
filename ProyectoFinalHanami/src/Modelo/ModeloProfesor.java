package Modelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;


import BD.ProfesorDAO;
import Vista.VistaProfesor;
import Vista.MenuPrincipal;

public class ModeloProfesor {
	 private String nombre;
	 private String apellido;
	 private String dni;
	 private Date fechaNac;
	 private String domicilio;
	 private String telefono;
	 private ProfesorDAO profesorDAO = new ProfesorDAO();






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
		this.fechaNac= fechaNac;
	}

	public void CargarDatos(ModeloProfesor profesor) {
		profesorDAO.IngresarDatos(profesor);
	     
	   }
	
	
	
	public void ModificarDatos(ModeloProfesor profesor) {
		profesorDAO.ModificarProfesor(profesor);
	}
	
	public ArrayList<ModeloProfesor> ArrayDatosProfesor()  {
		return profesorDAO.ConsultaProfesoresDAO();
	}
	
	public void BajaAlumno(int dni) {
		profesorDAO.EliminarProfesor(dni);
	}
	
	public boolean VerificarExistencia(String dni) {
		return profesorDAO.ValidarExistencia(dni);
	}
}
