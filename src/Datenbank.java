
import java.sql.*;
import java.util.Calendar;

public class Datenbank {

	Class.forName(myDriver);
	Connection conn = DriverManager.getConnection(myUrl, "root", "");
	public static void main(String[] args) {
		// mySQL Datenbank-Connection erstellen
		try {
	
		//SQL Datum-Objekt erstellen.
			
			
			//INSERT-Befehl
			String query = " insert into TABELLENNAMEN (SPALTENNAMEN)" + " values (?)";
			
		} catch (Exception e) {
			System.err.println("In Klasse Datenbank ist ein Fehler aufgetreten!");
		     System.err.println(e.getMessage());
		}
	}
	public static String getMyUrl() {
		return "jdbc:mysql://localhost/warenlager?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}
	
	public static String getMyDriver() {
		return "org.gjt.mm.mysql.Driver";
	}
	
	public static void insert() {
		//Vorbereiteter INSERT-Befehl wird verwendet
		PreparedStatement preInsert = conn.prepareStatement(query);
		preInsert.setString(1,"Barney");
		preInsert.setString(2, "Rubble");
		preInsert.setDate(3, startDate);
		preInsert.setBoolean(4,false);
		preInsert.setInt(5,5000);
		
		//Vorbereiteten Befehl ausführen
		preInsert.execute();
	}
}