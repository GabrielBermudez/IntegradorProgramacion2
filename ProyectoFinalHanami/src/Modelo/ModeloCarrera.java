package Modelo;

import java.sql.*;
import java.util.ArrayList;



import BD.CarreraDAO;

import Vista.MenuPrincipal;

public class ModeloCarrera{
	 private String codigo;
	 private String nombre;
	 private String duracion;
	 
	
	 private CarreraDAO carreraDAO = new CarreraDAO();


	 	
	 
	 
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDuracion() {
		return duracion;
	}



	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}



	public CarreraDAO getCarreraDAO() {
		return carreraDAO;
	}



	public void setCarreraDAO(CarreraDAO carreraDAO) {
		this.carreraDAO = carreraDAO;
	}



	public void CargarDatos(ModeloCarrera carrera) {
	     carreraDAO.IngresarDatos(carrera);
	     
	   }
	
	
	
	public void ModificarDatos(ModeloCarrera carrera) {
		carreraDAO.ModificarCarrera(carrera);
	}
	
	public ArrayList<ModeloCarrera> ArrayDatosCarrera()  {
		return carreraDAO.ConsultaCarrerasDAO();
	}
	
	public void BajaCarrera(String codigo) {
		carreraDAO.EliminarCarrera(codigo);
	}
	
	public boolean VerificarExistencia(String codigo) {
		return carreraDAO.ValidarExistencia(codigo);
	}
	
}
