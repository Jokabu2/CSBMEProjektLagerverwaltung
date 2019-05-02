
import java.sql.*;
import java.util.Calendar;

public class Datenbank {
	// SQL Datum-Objekt erstellen.
	static java.sql.Date startDate = getStartDate();
	
	public static void main(String[] args) {
		try {
			// mySQL Datenbank-Connection erstellen
			String myUrl = getMyUrl();
			String myDriver = getMyDriver();
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(getMyUrl(), "root", "");
	
			// INSERT-Befehl
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

	private static Date getStartDate() {
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	    return startDate;
	}

	public static void insert() {
		// Vorbereiteter INSERT-Befehl wird verwendet
		PreparedStatement preInsert = conn.prepareStatement(query);
		preInsert.setString(1, "Barney");
		preInsert.setString(2, "Rubble");
		preInsert.setDate(3, startDate);
		preInsert.setBoolean(4, false);
		preInsert.setInt(5, 5000);

		// Vorbereiteten Befehl ausführen
		preInsert.execute();
	}
}

/*
DB TABELLE:
create table users (
id int unsigned auto_increment not null,
first_name varchar(32) not null,
last_name varchar(32) not null,
date_created timestamp default now(),
is_admin boolean,
num_points int,
primary key (id));
 */
