package Modelo;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.CursadoDAO;
import BD.MateriaDAO;
import Vista.MenuPrincipal;

public class ModeloCursado {
 
	 private String dniAlumno;
	 private int nota;
	 private String nombre,apellido,dni,codigoMateria,nombreMateria;
	 private String nombreProfesor, apellidoProfesor, dniProfesor, telefonoProfesor;
	
	 private CursadoDAO cursadoDAO = new CursadoDAO();
	 


	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getApellidoProfesor() {
		return apellidoProfesor;
	}

	public void setApellidoProfesor(String apellidoProfesor) {
		this.apellidoProfesor = apellidoProfesor;
	}

	public String getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	public String getTelefonoProfesor() {
		return telefonoProfesor;
	}

	public void setTelefonoProfesor(String telefonoProfesor) {
		this.telefonoProfesor = telefonoProfesor;
	}

	public String getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}


	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
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



	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public CursadoDAO getCursadoDAO() {
		return cursadoDAO;
	}

	public void setCursadoDAO(CursadoDAO cursadoDAO) {
		this.cursadoDAO = cursadoDAO;
	}

	public void CargarDatos(ModeloCursado cursado) {
		cursadoDAO.IngresarDatos(cursado);
	     
	   }

	public void ModificarDatos(ModeloCursado cursado) {
		cursadoDAO.ModificarNota(cursado);
	}
	
	public ArrayList<ModeloCursado> ArrayDatosNotas()  {
		return cursadoDAO.ConsultaNotasDAO();
	}
	
	public void BajaNota(int dni) {
		cursadoDAO.EliminarNota(dni);
	}
	
	public boolean VerificarExistenciaAlumno(int alumno_dni, int codigo) {
		return cursadoDAO.ValidarExistenciaAlumno(alumno_dni, codigo);
	}
	
	public boolean VerificarExistenciaRepetida(int alumno_id, String nombreMateria, String codigo) {
		return cursadoDAO.ValidarExistenciaRepetida(alumno_id, nombreMateria, codigo);
	}
}