package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import Modelo.ModeloMateria;

public class MateriaDAO{
	
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	
	private String sqlQuery="";
	PreparedStatement preparedStmt=null;
	
	public void IngresarDatos(ModeloMateria materia){
		try {
			Connection conexion = conexionMySQL.ConectarMySQL();
			
			String sqlQuery="INSERT INTO materia(mat_cod,mat_nombre,mat_prof_dni) VALUES (?,?,?)";
		
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			
			preparedStmt = (PreparedStatement) conexion.prepareStatement(sqlQuery);
			
			preparedStmt.setString(1, materia.getCodigo());
		    preparedStmt.setString(2, materia.getNombre());
		    preparedStmt.setString(3, materia.getDniProfesor());

		    
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    conexionMySQL.CerrarMySQL();
		    
		}catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
		}

	
	}
	
	public ArrayList<ModeloMateria> ConsultaMateriasDAO()  {
        ArrayList<ModeloMateria> materias = new ArrayList<>();
         	
        	PreparedStatement consulta;
			try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				consulta = conexion.prepareStatement("SELECT materia.mat_cod,materia.mat_nombre,materia.mat_prof_dni,profesor.prof_nombre,profesor.prof_apellido FROM materia, profesor WHERE profesor.prof_dni = materia.mat_prof_dni");
				 ResultSet resultados = consulta.executeQuery();
				 
		            while (resultados.next()) {
		            	ModeloMateria materia = new ModeloMateria();
		            	//System.out.println(resultados.getInt(1));
		            	materia.setCodigo(resultados.getString(1));
		            	materia.setNombre(resultados.getString(2));
		            	materia.setDniProfesor(String.valueOf(resultados.getInt(3)));
		            	materia.setNombreProfesor(resultados.getString(4));
		            	materia.setApellidoProfesor(resultados.getString(5));
		            	materias.add(materia);
		               }
		            
		            resultados.close();
		            consulta.close();
		            conexionMySQL.CerrarMySQL();
				
			}catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            
			}
			
       return materias;
        
    }
	
	public void ModificarMateria(ModeloMateria materia) {
		 try{	
			 	//System.out.println(profesor.getId());
			 	String sqlQuery="UPDATE materia SET mat_cod=?, mat_nombre=?, mat_prof_dni=? WHERE mat_cod=?";
			 	Connection conexion = conexionMySQL.ConectarMySQL();
	            PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
	            preparedStmt.setString(1, materia.getCodigo());
	            preparedStmt.setString(2, materia.getNombre());
	            preparedStmt.setString(3, materia.getDniProfesor());
	            preparedStmt.setString(4, materia.getCodigo());
	            
	            preparedStmt.executeUpdate();
	            preparedStmt.close();
	            conexionMySQL.CerrarMySQL();
	           
	            
	        }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
	}
	
	public void EliminarMateria(int dni) {
	
		try {
			//System.out.println(id);
			String sqlQuery="DELETE FROM materia WHERE mat_prof_dni = ?";
			Connection conexion = conexionMySQL.ConectarMySQL();
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
			preparedStmt.setInt(1, dni);
			preparedStmt.execute();
			preparedStmt.close();
	        conexionMySQL.CerrarMySQL();
	           
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
}
	
	public boolean ValidarExistenciaProfesor(int profesor_dni) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
				preparedStmt.executeQuery();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM profesor WHERE prof_dni = ?");
				consulta.setInt(1,profesor_dni);
				ResultSet resultados = consulta.executeQuery();
				if(resultados.next()){
					consulta.close();
			        conexionMySQL.CerrarMySQL();
			        return true;
				}
					
				consulta.close();
		        conexionMySQL.CerrarMySQL();
		       
		          
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
		
		
		return false;
	}
	
	public boolean ValidarExistenciaRepetida(int profesor_dni, String nombreMateria, String codigo) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
				preparedStmt.executeQuery();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM materia WHERE (mat_prof_dni = ?) AND (mat_nombre = ? OR mat_cod = ?)");
				consulta.setInt(1,profesor_dni);
				consulta.setString(2, nombreMateria);
				consulta.setString(3, codigo);
				ResultSet resultados = consulta.executeQuery();
				if(resultados.next()){
					consulta.close();
			        conexionMySQL.CerrarMySQL();
			        //System.out.println("Existe");
			        return true;
				}
				 //System.out.println("No existe");
				consulta.close();
		        conexionMySQL.CerrarMySQL();
		       
		          
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
		
		
		return false;
	}
}
