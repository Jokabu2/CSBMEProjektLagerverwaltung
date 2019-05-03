import java.sql.*;
import java.util.Calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Date;

public class DBConnection {
	static Connection connection;

	public static void main (String [] args) {
		boolean a = connectToMysql("localhost:3306",  "test",  "root",  "Kunxholli123");
		System.out.println(a);
	}
	
	public static boolean connectToMysql(String host, String database, String user, String passwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String connectionCommand = "jdbc:mysql://"+host+"/"+database+"?user="+user+"&password="+passwd +"&serverTimezone=UTC";
				 
			connection = DriverManager.getConnection(connectionCommand);
			return true;

		} catch (Exception ex) {
			System.out.println("false");
			System.err.println(ex);
			return false;
		}
	}
}