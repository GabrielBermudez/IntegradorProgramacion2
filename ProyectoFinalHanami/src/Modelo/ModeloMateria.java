package Modelo;
import java.sql.SQLException;
import java.util.ArrayList;


import BD.MateriaDAO;
import Vista.MenuPrincipal;

public class ModeloMateria {

	 private String codigo;
	 private String nombre;
	 private String dniProfesor;
	 private String nombreProfesor;
	 private String apellidoProfesor;
	
	 private MateriaDAO materiaDAO = new MateriaDAO();

	




	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}



	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * @return the nombreProfesor
	 */
	public String getNombreProfesor() {
		return nombreProfesor;
	}



	/**
	 * @param nombreProfesor the nombreProfesor to set
	 */
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}



	/**
	 * @return the apellidoProfesor
	 */
	public String getApellidoProfesor() {
		return apellidoProfesor;
	}



	/**
	 * @param apellidoProfesor the apellidoProfesor to set
	 */
	public void setApellidoProfesor(String apellidoProfesor) {
		this.apellidoProfesor = apellidoProfesor;
	}



	/**
	 * @return the dniProfesor
	 */
	public String getDniProfesor() {
		return dniProfesor;
	}



	/**
	 * @param dniProfesor the dniProfesor to set
	 */
	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}



	public void CargarDatos(ModeloMateria materia) {
		materiaDAO.IngresarDatos(materia);
	     
	   }

	public void ModificarDatos(ModeloMateria materia) {
		materiaDAO.ModificarMateria(materia);
	}
	
	public ArrayList<ModeloMateria> ArrayDatosMateria()  {
		return materiaDAO.ConsultaMateriasDAO();
	}
	
	public void BajaAlumno(int dni) {
		materiaDAO.EliminarMateria(dni);
	}
	
	public boolean VerificarExistenciaProfesor(int profesor_dni) {
		return materiaDAO.ValidarExistenciaProfesor(profesor_dni);
	}
	
	public boolean VerificarExistenciaRepetida(int profesor_dni, String nombreMateria, String codigo) {
		return materiaDAO.ValidarExistenciaRepetida(profesor_dni, nombreMateria, codigo);
	}
}
