package BD;


import java.sql.*;

/**
 *
 * @author Cristian
 */
public class Query {
	protected Connection conn;
    protected PreparedStatement consulta;
    protected ResultSet datos;
    
    public void conectar(String servidor, String bd, String usuario, String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+bd,usuario,password);
    }
    
    public void desconectar() throws SQLException{
        this.conn.close();
        this.consulta.close();
    }
    
    public void desconectar(ResultSet rs) throws SQLException{
        this.desconectar();
        rs.close();
    }

    
}
