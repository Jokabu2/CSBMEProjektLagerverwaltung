import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class ConnectionToDB {

	Connection con;

	// DB-Connection Infos
	String host = "localhost:3306";
	String database = "lagerverwaltung";
	String user = "root";
	String passwd = "Kunxholli123";

	/**
	 * @param host
	 * @param database
	 * @param user
	 * @param passwd
	 * 
	 *                 Datenbank-Connection wird aufgebaut. Bevor man mit einem
	 *                 SQL-Statement an der Datenbank arbeiten kann.
	 */
	public void connectToMysql(String host, String database, String user, String passwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password="
					+ passwd + "&serverTimezone=UTC");
			System.out.println("########## connectToMysql Connection wurde erstellt ##########"); //Statusausgabe

		} catch (Exception e) {
			System.err.println(e);
			System.out.println(" Fehler in der Methode: connectToMysql");
		}
	}

	/**
	 * @param inventarnummer
	 * @param produkttyp
	 * @param hersteller
	 * @param modellnummer
	 * @param beschreibung
	 * @param preis
	 * @param lieferant
	 * @param einlagerungsdatum
	 * @param auslagerungsdatum
	 * @return Mitteilung ob der Datensatz erfolgreich hinzugefügt wurde.
	 */
	public String insert(String inventarnummer, String produkttyp, String hersteller, String modellnummer,
			String beschreibung, String preis, String lieferant, String einlagerungsdatum, String auslagerungsdatum) {
		try {
			connectToMysql(host, database, user, passwd);
			Statement stmt = con.createStatement();
			stmt.execute(
					"INSERT INTO bestand (inventarnummer, produkttyp, hersteller, modellnummer, beschreibung, preis, lieferant, einlagerungsdatum, auslagerungsdatum)"
							+ " VALUES ('" + inventarnummer + "','" + produkttyp + "','" + hersteller + "','"
							+ modellnummer + "','" + beschreibung + "','" + preis + "','" + lieferant + "','"
							+ einlagerungsdatum + "','" + auslagerungsdatum + "')");

			stmt.close();
			con.close();
			return "Der Datensatz wurde erfolgreich hinzugefügt!";
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) { // Abfangen von falscher Eingabe, wenn die
																			// Inventarnummer doppelt verwendet werden
																			// will. Inventarnummer ist in der DB
																			// unique.
				
				return "Fehler! - Die Inventarnummer ist bereits vergeben: +" + inventarnummer;
			} else if (e instanceof com.mysql.cj.jdbc.exceptions.MysqlDataTruncation) { // Abfangen von zu langen
																						// Eingaben.
				System.err.println(e);
				return "Der Datensatz kann nicht eingefügt werden, ein Feld ist zu lang!.";
			} else {
				System.err.println(e);
				return "Der Datensatz konnte nicht hinzugefügt werden!";
			}
		}
	}

	public void delete(String inventarnummer, String tabelle) {
		try {
			Statement stmt = con.createStatement();
			stmt.execute("DELETE FROM " + tabelle + " WHERE inventarnummer = '" + inventarnummer + "'");

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public void selectAll(String tabelle) {
		try {
			Statement stmt = con.createStatement();
			stmt.execute("SELECT * FROM " + tabelle);

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	// Daten müssen vor dem UPDATE auf Eingabe überprüft werden, sonst setzt die
	// Methode leere Strings ein.

	public void update(String tabellenname, String inventarnummer, String produkttyp, String hersteller,
			String modellnummer, String beschreibung, int preis, String lieferant, String einlagerungsdatum,
			String auslagerungsdatum) {

		try {
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE " + tabellenname + " SET produkttyp = '" + produkttyp + "', hersteller = '"
					+ hersteller + "', modellnummer = '" + modellnummer + "', beschreibung = '" + beschreibung
					+ "', preis = '" + preis + "', lieferant = '" + lieferant + "', einlagerungsdatum = '"
					+ einlagerungsdatum + "', auslagerungsdatum = '" + auslagerungsdatum + "' WHERE inventarnummer = '"
					+ inventarnummer + "'");

			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param tabellenname
	 * @return Anzahl der Spalten der Tabelle im Eingabeparameter "tabellenname",
	 *         bei einem Fehler, wird die Spaltenanzahl -1 zurückgegeben.
	 */
	public int getAnzahlSpalten(String tabellenname) {
		try {
			String query = "SELECT * FROM " + tabellenname;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int anzahlSpalten = rs.getMetaData().getColumnCount();

			return anzahlSpalten;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
