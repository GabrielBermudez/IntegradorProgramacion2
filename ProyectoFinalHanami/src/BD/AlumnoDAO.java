package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modelo.ModeloAlumno;

public class AlumnoDAO{
	
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	
	private String sqlQuery="";
	PreparedStatement preparedStmt=null;
	
	public void IngresarDatos(ModeloAlumno alumno){
		try {
			Connection conexion = conexionMySQL.ConectarMySQL();
			
			String sqlQuery="INSERT INTO alumno(alu_dni,alu_nombre,alu_apellido,alu_fec_nac,alu_domicilio,alu_telefono) VALUES (?,?,?,?,?,?)";
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			
			preparedStmt = (PreparedStatement) conexion.prepareStatement(sqlQuery);
			
			preparedStmt.setString(1, alumno.getDni());
			preparedStmt.setString(2, alumno.getNombre());
		    preparedStmt.setString(3, alumno.getApellido());
		    preparedStmt.setDate(4, alumno.getFechaNac());
		    preparedStmt.setString(5, alumno.getDomicilio());
		    preparedStmt.setString(6, alumno.getTelefono());
		    
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    conexionMySQL.CerrarMySQL();
		    
		}catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
		}

	
	}
	
	public ArrayList<ModeloAlumno> ConsultaAlumnosDAO()  {
        ArrayList<ModeloAlumno> alumnos = new ArrayList<>();
         
        	PreparedStatement consulta;
			try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				consulta = conexion.prepareStatement("select * from alumno");
				 ResultSet resultados = consulta.executeQuery();

		            while (resultados.next()) {
		            	ModeloAlumno alumno = new ModeloAlumno();
		            	//System.out.println(resultados.getInt(1));
		                alumno.setDni(resultados.getString(1));
		                alumno.setNombre(resultados.getString(2));
		                alumno.setApellido(resultados.getString(3));
		                alumno.setFechaNac(resultados.getDate(4));
		                alumno.setDomicilio(resultados.getString(5));
		                alumno.setTelefono(resultados.getString(6));
		                alumnos.add(alumno);
		               }
		            
		            resultados.close();
		            consulta.close();
		            conexionMySQL.CerrarMySQL();
				
			}catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            
			}
			
       return alumnos;
        
    }
	
	public void ModificarAlumno(ModeloAlumno alumno) {
		 try{	
			 	System.out.println(alumno.getDni());
			 	String sqlQuery="UPDATE alumno SET alu_nombre=?, alu_apellido=?, alu_fec_nac=?, alu_domicilio=?, alu_telefono=? WHERE alu_dni=?";
			 	Connection conexion = conexionMySQL.ConectarMySQL();
	            PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
	            preparedStmt.setString(1, alumno.getNombre());
	            preparedStmt.setString(2, alumno.getApellido());
	            preparedStmt.setDate(3, alumno.getFechaNac());
	            preparedStmt.setString(4, alumno.getDomicilio());
	            preparedStmt.setString(5, alumno.getTelefono());
	            preparedStmt.setInt(6, Integer.parseInt(alumno.getDni()));
	            
	            preparedStmt.executeUpdate();
	            preparedStmt.close();
	            conexionMySQL.CerrarMySQL();
	           
	            
	        }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
	}
	
	public void EliminarAlumno(int dni) {
	
		try {
			String sqlQuery="DELETE FROM alumno WHERE alu_dni = ?";
			Connection conexion = conexionMySQL.ConectarMySQL();
			PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
			preparedStmt.setInt(1, dni);
			preparedStmt.execute();
			preparedStmt.close();
	        conexionMySQL.CerrarMySQL();
	           
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
}
	
	public boolean ValidarExistencia(String dni) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM alumno WHERE alu_dni = ?");
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
	            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
		
		
		return false;
	}
}
