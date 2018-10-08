package fujitsu.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_DB", "root", "root");

		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}