package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import Modelo.ModeloInscripcion;

public class InscripcionDAO{
	
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	
	private String sqlQuery="";
	PreparedStatement preparedStmt=null;
	
	public void IngresarDatos(ModeloInscripcion inscripcion){
		try {
			Connection conexion = conexionMySQL.ConectarMySQL();
			
			String sqlQuery="INSERT INTO inscripcion(insc_nombre, insc_fecha,insc_car_cod) VALUES (?,?,?)";
		
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			
			preparedStmt = (PreparedStatement) conexion.prepareStatement(sqlQuery);
			preparedStmt.setString(1, inscripcion.getDniAlumno());
			preparedStmt.setDate(2, inscripcion.getFecha());
		    preparedStmt.setString(3, inscripcion.getCodigoCarrera());
		    

		    
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    conexionMySQL.CerrarMySQL();
		    
		}catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            
		}

	
	}
	
	public ArrayList<ModeloInscripcion> ConsultaInscripcionDAO()  {
        ArrayList<ModeloInscripcion> inscripciones = new ArrayList<>();
         
        	PreparedStatement consulta;
			try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				consulta = conexion.prepareStatement("SELECT inscripcion.insc_cod, inscripcion.insc_nombre,alumno.alu_nombre,alumno.alu_apellido,alumno.alu_telefono, inscripcion.insc_car_cod,carrera.car_nombre,carrera.car_duracion,inscripcion.insc_fecha FROM inscripcion,carrera,alumno WHERE carrera.car_cod = inscripcion.insc_car_cod AND inscripcion.insc_nombre = alumno.alu_dni");
				ResultSet resultados = consulta.executeQuery();
				 
		            while (resultados.next()) {
		            	ModeloInscripcion inscripcion = new ModeloInscripcion();
		            	
		            	inscripcion.setCodigo(resultados.getString(1));
		            	inscripcion.setDniAlumno(resultados.getString(2));
		            	inscripcion.setNombre(resultados.getString(3));
		            	inscripcion.setApellido(resultados.getString(4));
		            	inscripcion.setTelefono(resultados.getString(5));
		            	inscripcion.setCodigoCarrera(resultados.getString(6));
		            	inscripcion.setNombreCarrera(resultados.getString(7));
		            	inscripcion.setDuracion(resultados.getString(8));
		            	inscripcion.setFecha(resultados.getDate(9));
		            	
		            	inscripciones.add(inscripcion);
		               }
		            
		            resultados.close();
		            consulta.close();
		            conexionMySQL.CerrarMySQL();
				
			}catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
	            
			}
			
       return inscripciones;
        
    }
	
	public void ModificarInscripcion(ModeloInscripcion cursado) {
		 try{	
			 	String sqlQuery="UPDATE inscripcion SET insc_nombre=?, insc_fecha=?, insc_car_cod=? WHERE insc_cod=?";
			 	Connection conexion = conexionMySQL.ConectarMySQL();
			 	PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
	     
	            preparedStmt.setString(1, cursado.getDniAlumno());
	            preparedStmt.setDate(2, cursado.getFecha());
	            preparedStmt.setString(3, cursado.getCodigoCarrera());
	            preparedStmt.setString(4, cursado.getCodigo());
	       
	            
	            preparedStmt.executeUpdate();
	            preparedStmt.close();
	            conexionMySQL.CerrarMySQL();
	           
	            
	        }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
	}
	
	public void EliminarInscripcion(String codigo) {
	
		try {
			//System.out.println(id);
			String sqlQuery="DELETE FROM inscripcion WHERE insc_cod = ?";
			Connection conexion = conexionMySQL.ConectarMySQL();
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
			preparedStmt.setString(1, codigo);
			preparedStmt.execute();
			preparedStmt.close();
	        conexionMySQL.CerrarMySQL();
	           
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
}
	
	public boolean ValidarExistenciaAlumno(String alumno_dni, String codigo) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
				preparedStmt.executeQuery();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM inscripcion WHERE insc_nombre = ? AND insc_car_cod=?");
				consulta.setString(1,alumno_dni);
				consulta.setString(2, codigo);
				ResultSet resultados = consulta.executeQuery();
				if(resultados.next()){
					consulta.close();
			        conexionMySQL.CerrarMySQL();
			        return true;
				}
					
				consulta.close();
		        conexionMySQL.CerrarMySQL();
		       
		          
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
		
		
		return false;
	}
	
	/*public boolean ValidarExistenciaRepetida(int profesor_id, String nombreMateria, String codigo) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
				preparedStmt.executeQuery();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM materia WHERE (profesor_id = ?) AND (nombre = ? OR codigo = ?)");
				consulta.setInt(1,profesor_id);
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
	}*/
}
