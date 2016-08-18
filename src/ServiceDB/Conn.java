package ServiceDB;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FreeComp
 */
public class Conn {

	public static Connection conn;

	public static Connection getconnection() throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		try {
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/database_task03",
							"root", "root");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return conn;

	}

}