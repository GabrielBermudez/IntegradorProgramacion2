package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modelo.ModeloCarrera;

public class CarreraDAO{
	
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	
	private String sqlQuery="";
	PreparedStatement preparedStmt=null;
	
	public void IngresarDatos(ModeloCarrera carrera){
		try {
			Connection conexion = conexionMySQL.ConectarMySQL();
			
			String sqlQuery="INSERT INTO carrera(car_cod,car_nombre,car_duracion) VALUES (?,?,?)";
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			
			preparedStmt = (PreparedStatement) conexion.prepareStatement(sqlQuery);
			
			preparedStmt.setString(1, carrera.getCodigo());
			preparedStmt.setString(2, carrera.getNombre());
		    preparedStmt.setString(3, carrera.getDuracion());
		   
		    
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    conexionMySQL.CerrarMySQL();
		    
		}catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            
		}

	
	}
	
	public ArrayList<ModeloCarrera> ConsultaCarrerasDAO()  {
        ArrayList<ModeloCarrera> carreras = new ArrayList<>();
         
        	PreparedStatement consulta;
			try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				consulta = conexion.prepareStatement("SELECT * FROM carrera");
				 ResultSet resultados = consulta.executeQuery();

		            while (resultados.next()) {
		            	ModeloCarrera carrera = new ModeloCarrera();
		            	
		                carrera.setCodigo(resultados.getString(1));
		                carrera.setNombre(resultados.getString(2));
		                carrera.setDuracion(resultados.getString(3));
		               
		                carreras.add(carrera);
		               }
		            
		            resultados.close();
		            consulta.close();
		            conexionMySQL.CerrarMySQL();
				
			}catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
	            
			}
			
       return carreras;
        
    }
	
	public void ModificarCarrera(ModeloCarrera carrera) {
		 try{	
			 	//System.out.println(carrera.getCodigo());
			 	String sqlQuery="UPDATE carrera SET car_nombre=?, car_duracion=? WHERE car_cod=?";
			 	Connection conexion = conexionMySQL.ConectarMySQL();
	            PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
	            preparedStmt.setString(1, carrera.getNombre());
	            preparedStmt.setString(2, carrera.getDuracion());
	            preparedStmt.setString(3, carrera.getCodigo());
	            
	            preparedStmt.executeUpdate();
	            preparedStmt.close();
	            conexionMySQL.CerrarMySQL();
	           
	            
	        }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
	}
	
	public void EliminarCarrera(String codigo) {
	
		try {
			String sqlQuery="DELETE FROM carrera WHERE car_cod= ?";
			Connection conexion = conexionMySQL.ConectarMySQL();
			PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
			preparedStmt.setString(1, codigo);
			preparedStmt.execute();
			preparedStmt.close();
	        conexionMySQL.CerrarMySQL();
	           
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
}
	
	public boolean ValidarExistencia(String codigo) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM carrera WHERE car_cod = ?");
				consulta.setString(1, codigo);
				ResultSet resultados = consulta.executeQuery();
				if(resultados.next()){
					consulta.close();
			        conexionMySQL.CerrarMySQL();
			        return true;
				}
					
				consulta.close();
		        conexionMySQL.CerrarMySQL();
		       
		          
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
		
		
		return false;
	}
}
