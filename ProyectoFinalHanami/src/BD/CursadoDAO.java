package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import Modelo.ModeloCursado;

public class CursadoDAO{
	
	private ConexionMySQL conexionMySQL = new ConexionMySQL();
	
	private String sqlQuery="";
	PreparedStatement preparedStmt=null;
	
	public void IngresarDatos(ModeloCursado cursado){
		try {
			Connection conexion = conexionMySQL.ConectarMySQL();
			
			String sqlQuery="INSERT INTO cursado(cur_alu_dni, cur_mat_cod, cur_nota) VALUES (?,?,?)";
		
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			
			preparedStmt = (PreparedStatement) conexion.prepareStatement(sqlQuery);
			
			preparedStmt.setString(1, cursado.getDniAlumno());
		    preparedStmt.setString(2, cursado.getCodigoMateria());
		    preparedStmt.setInt(3, cursado.getNota());

		    
		    preparedStmt.execute();
		    
		    preparedStmt.close();
		    conexionMySQL.CerrarMySQL();
		    
		}catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
		}

	
	}
	
	public ArrayList<ModeloCursado> ConsultaNotasDAO()  {
        ArrayList<ModeloCursado> notas = new ArrayList<>();
         
        	PreparedStatement consulta;
			try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				consulta = conexion.prepareStatement("SELECT cursado.cur_alu_dni,alumno.alu_nombre,alumno.alu_apellido,cursado.cur_mat_cod,materia.mat_nombre,cursado.cur_nota, materia.mat_prof_dni,profesor.prof_nombre,profesor.prof_apellido,profesor.prof_telefono FROM cursado,materia, alumno , profesor WHERE alumno.alu_dni= cursado.cur_alu_dni AND materia.mat_cod = cursado.cur_mat_cod AND materia.mat_prof_dni = profesor.prof_dni;");
				 ResultSet resultados = consulta.executeQuery();

		            while (resultados.next()) {
		            	ModeloCursado cursado = new ModeloCursado();
		            	//System.out.println(resultados.getInt(1));
		            	cursado.setDniAlumno(resultados.getString(1));
		            	cursado.setNombre(resultados.getString(2));
		            	cursado.setApellido(resultados.getString(3));	  
		            	cursado.setCodigoMateria(resultados.getString(4));
		            	cursado.setNombreMateria(resultados.getString(5));
		            	cursado.setNota(resultados.getInt(6));
		            	cursado.setDniProfesor(resultados.getString(7));
		            	cursado.setNombreProfesor(resultados.getString(8));
		            	cursado.setApellidoProfesor(resultados.getString(9));
		            	cursado.setTelefonoProfesor(resultados.getString(10));
		            	
		            	notas.add(cursado);
		               }
		            
		            resultados.close();
		            consulta.close();
		            conexionMySQL.CerrarMySQL();
				
			}catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            
			}
			
       return notas;
        
    }
	
	public void ModificarNota(ModeloCursado cursado) {
		 try{	
			 	//System.out.println(profesor.getId());
			 	String sqlQuery="UPDATE cursado SET cur_alu_dni=?, cur_mat_cod=?, cur_nota=? WHERE cur_alu_dni=?";
			 	Connection conexion = conexionMySQL.ConectarMySQL();
	            PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
	            /*System.out.println(cursado.getIdAlumno());
	            System.out.println(cursado.getIdMateria());
	            System.out.println(cursado.getNota());
	            System.out.println(cursado.getId());*/
	          
	            preparedStmt.setString(1, cursado.getDniAlumno());
	            preparedStmt.setString(2, cursado.getCodigoMateria());
	            preparedStmt.setInt(3, cursado.getNota());
	            preparedStmt.setString(4, cursado.getDniAlumno());
	            
	            preparedStmt.executeUpdate();
	            preparedStmt.close();
	            conexionMySQL.CerrarMySQL();
	           
	            
	        }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
	}
	
	public void EliminarNota(int dni) {
	
		try {
			//System.out.println(id);
			String sqlQuery="DELETE FROM cursado WHERE cur_alu_dni = ?";
			Connection conexion = conexionMySQL.ConectarMySQL();
			preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			preparedStmt.executeQuery();
			PreparedStatement preparedStmt = (PreparedStatement)conexion.prepareStatement(sqlQuery);
			preparedStmt.setInt(1, dni);
			preparedStmt.execute();
			preparedStmt.close();
	        conexionMySQL.CerrarMySQL();
	           
			
		 }catch(ClassNotFoundException |SQLException ex) {
	            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);     
	        }
}
	
	public boolean ValidarExistenciaAlumno(int alumno_dni, int codigo) {
		try {
				Connection conexion = conexionMySQL.ConectarMySQL();
				preparedStmt=conexion.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
				preparedStmt.executeQuery();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM cursado WHERE cur_alu_dni = ? AND cur_mat_cod=?");
				consulta.setInt(1,alumno_dni);
				consulta.setInt(2, codigo);
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
	
	public boolean ValidarExistenciaRepetida(int profesor_id, String nombreMateria, String codigo) {
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
	}
}
