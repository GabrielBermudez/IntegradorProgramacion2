package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

	 // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "integradordb";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false & useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "mysql";
    
    public Connection conexion = null;
	
	public Connection ConectarMySQL() throws ClassNotFoundException, SQLException {

	        try {
	            Class.forName(driver);
	            conexion = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return conexion;
	    }
	 
	public void CerrarMySQL() {
		if (conexion != null) {
			try {
				this.conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	}
	 
}
