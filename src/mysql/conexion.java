package mysql;

/*Import*/
import alert.database_error;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
/*END Import*/

public class conexion {
	/*Valores para la conexion*/
	static final String username = "juan"; /*Nombre del usuario*/
	static final String password = "123456789"; /*Password database*/
	static final String database = "jdbc:mysql://localhost/inventario"; /* ->/nombre de la base de datos*/
	static final String driver = "com.mysql.jdbc.Driver"; /*NO mover*/
	Connection connect = null;
	/*END Valores para la conexion*/
	
	public Connection conexion() { /*Constructor de la conexion*/
		try {
			Class.forName(driver);
			connect = (Connection) DriverManager.getConnection(database, username, password);
		}catch(SQLException | ClassNotFoundException error) {
			//JOptionPane.showMessageDialog(null, error.getMessage());
			database_error window = new database_error();
			window.setVisible(true);
		}
		return connect;
	} /*END Conexion*/

	public Connection getConnection() {
		return this.connect;
	}
	public void desconectado() {
		this.connect = null;
	}

	/*Prueba de insert en database*/
	/*private static void setUser(String name, String lastname) {
		try {
			conexion conector = new conexion();
			PreparedStatement PS;
			String insertConsult = "insert into nombres values(?,?)";
			PS = (PreparedStatement) conector.getConnection().prepareStatement(insertConsult);
			PS.setString(1, name);
			PS.setString(2, lastname);
			PS.executeUpdate();
			PS.close();
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, error.getMessage());
		}
	}*/
	/*END database*/

	/*public static void main(String[] args) {
		conexion conector = new conexion();
		//Probar la conexion
	}*/
	
}
