
import java.sql.*;
import java.util.Calendar;

public class Datenbank {
	// SQL Datum-Objekt erstellen.
	java.sql.Date startDate = getStartDate();
	Connection conn = createConnection();
	DBConnection();
	
	
	public Datenbank() {
		
	}
	
	public void DBConnection1() {
		try {
			// mySQL Datenbank-Connection erstellen
			String myUrl = getMyUrl();
			String myDriver = getMyDriver();
			Class.forName(myDriver);
				
		} catch (Exception e) {
			System.err.println("In Klasse Datenbank ist ein Fehler aufgetreten!");
			System.err.println(e.getMessage());
		}
	}


	public String getMyUrl() {
		return "jdbc:mysql://localhost/warenlager?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}

	public String getMyDriver() {
		return "org.gjt.mm.mysql.Driver";
	}

	public Date getStartDate() {
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	    return startDate;
	}
	
	public Connection createConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(getMyUrl(), "root", "");
		} catch (SQLException e) {
			System.err.println("Fehler im Connectionaufbau");
			e.printStackTrace();
		}
		return conn;
	}
	
	public String getQuery() {
		String query = " insert into TABELLENNAMEN (SPALTENNAMEN)" + " values (?)";
		return query;
	}
	
	public void insert() {
		// Vorbereiteter INSERT-Befehl wird verwendet
		PreparedStatement preInsert;
		try {
			preInsert = conn.prepareStatement(getQuery());
			preInsert.setString(1, "Barney");
			preInsert.setString(2, "Rubble");
			preInsert.setDate(3, startDate);
			preInsert.setBoolean(4, false);
			preInsert.setInt(5, 5000);

			// Vorbereiteten Befehl ausführen
			preInsert.execute();
			
		} catch (SQLException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}

	}
	
	public void tabelleAusgeben () {
		try {  		
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("Select * from lagerbestand");
    		
    		String s = "";
    		
    		while(rs.next()) {
    			
    			s += rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6)+" | "+rs.getString(7)+"\n";        			        			
    			
    		}
    		System.out.println(s);
    		
    		rs.close();
    		stmt.close();
    		
    	} catch(Exception e) {
    		System.err.println("Fehlermeldung in Methode tabelleAusgeben" + e);
    	}
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
