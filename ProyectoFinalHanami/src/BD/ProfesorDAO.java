package BD;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import Modelo.ModeloProfesor;

public class ProfesorDAO{
	
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	
	private String sqlQuery="";
	PreparedStatement preparedStmt=null;
	
	public void IngresarDatos(ModeloProfesor profesor){
		try {
			Connection conexion = conexionMySQL.ConectarMySQL();
			
			String sqlQuery="INSERT INTO profesor(prof_dni, prof_nombre, prof_apellido, prof_fec_nac, prof_domicilio, prof_telefono) VALUES (?,?,?,?,?,?)";
			Date fecha = new Date(2020-1900,06,10);
			
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			
			preparedStmt = (PreparedStatement) conexion.prepareStatement(sqlQuery);
			
			preparedStmt.setString(1, profesor.getDni());
			preparedStmt.setString(2, profesor.getNombre());
		    preparedStmt.setString(3, profesor.getApellido());
		    preparedStmt.setDate(4, profesor.getFechaNac());
		    preparedStmt.setString(5, profesor.getDomicilio());
		    preparedStmt.setString(6, profesor.getTelefono());
		    
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    conexionMySQL.CerrarMySQL();
		    
		}catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            
		}

	
	}
	
	public ArrayList<ModeloProfesor> ConsultaProfesoresDAO()  {
        ArrayList<ModeloProfesor> profesores = new ArrayList<>();
         
        	PreparedStatement consulta;
			try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				consulta = conexion.prepareStatement("SELECT * FROM profesor");
				 ResultSet resultados = consulta.executeQuery();

		            while (resultados.next()) {
		            	ModeloProfesor profesor = new ModeloProfesor();
		            	//System.out.println(resultados.getInt(1));
		            	profesor.setDni(resultados.getString(1));
		            	profesor.setNombre(resultados.getString(2));
		            	profesor.setApellido(resultados.getString(3));
		            	profesor.setFechaNac(resultados.getDate(4));
		            	profesor.setDomicilio(resultados.getString(5));
		            	profesor.setTelefono(resultados.getString(6));
		            	profesores.add(profesor);
		               }
		            
		            resultados.close();
		            consulta.close();
		            conexionMySQL.CerrarMySQL();
				
			}catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
	            
			}
			
       return profesores;
        
    }
	
	public void ModificarProfesor(ModeloProfesor profesor) {
		 try{	
			 	//System.out.println(profesor.getId());
			 	String sqlQuery="UPDATE profesor SET prof_nombre=?, prof_apellido=?, prof_fec_nac=?, prof_domicilio=?, prof_telefono=? WHERE prof_dni=?";
			 	Connection conexion = conexionMySQL.ConectarMySQL();
	            PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
	            preparedStmt.setString(1, profesor.getNombre());
	            preparedStmt.setString(2, profesor.getApellido());
	            preparedStmt.setDate(3, profesor.getFechaNac());
	            preparedStmt.setString(4, profesor.getDomicilio());
	            preparedStmt.setString(5, profesor.getTelefono());
	            preparedStmt.setInt(6,Integer.parseInt( profesor.getDni()));
	            
	            preparedStmt.executeUpdate();
	            preparedStmt.close();
	            conexionMySQL.CerrarMySQL();
	           
	            
	        }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
	}
	
	public void EliminarProfesor(int dni) {
	
		try {
			String sqlQuery="DELETE FROM profesor WHERE prof_dni = ?";
			Connection conexion = conexionMySQL.ConectarMySQL();
			PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
			preparedStmt.setInt(1, dni);
			preparedStmt.execute();
			preparedStmt.close();
	        conexionMySQL.CerrarMySQL();
	           
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
}
	
	public boolean ValidarExistencia(String dni) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM profesor WHERE prof_dni = ?");
				consulta.setString(1, dni);
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
}
