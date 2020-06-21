package Modelo;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.InscripcionDAO;
import BD.MateriaDAO;
import Vista.MenuPrincipal;

public class ModeloInscripcion {

	 
	 private String codigo,dniAlumno,nombre,apellido,codigoCarrera,nombreCarrera,duracion,telefono;
	 private Date fecha;
	 private InscripcionDAO inscripcionDAO = new InscripcionDAO();
	 
	 
	 
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
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

	public String getCodigoCarrera() {
		return codigoCarrera;
	}

	public void setCodigoCarrera(String codigoCarrera) {
		this.codigoCarrera = codigoCarrera;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	
	
	

	public void CargarDatos(ModeloInscripcion inscripcion) {
		inscripcionDAO.IngresarDatos(inscripcion);
	     
	   }

	public void ModificarInscripcion(ModeloInscripcion inscripcion) {
		inscripcionDAO.ModificarInscripcion(inscripcion);
	}
	
	public ArrayList<ModeloInscripcion> ArrayDatosInscripcion()  {
		return inscripcionDAO.ConsultaInscripcionDAO();
	}
	
	public void BajaInscripcion(String codigo) {
		inscripcionDAO.EliminarInscripcion(codigo);
	}
	
	public boolean VerificarExistenciaAlumno(String alumno_dni, String codigo) {
		return inscripcionDAO.ValidarExistenciaAlumno(alumno_dni, codigo);
	}
	
	/*public boolean VerificarExistenciaRepetida(String alumno_dni, String codigo) {
		return inscripcionDAO.ValidarExistenciaRepetida(alalumno_dniumno_id,codigo);
	}*/
}