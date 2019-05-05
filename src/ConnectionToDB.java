import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

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
			System.out.println("########## DB Connection wurde erstellt ##########"); // Statusausgabe

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
	public void insert(String tabellenname, String inventarnummer, String produkttyp, String hersteller,
			String modellnummer, String beschreibung, String preis, String lieferant, String einlagerungsdatum,
			String auslagerungsdatum) {

		// Länge der Eingaben prüfen
		if (checkInventarnummer(inventarnummer) == true || checkModellnummer(modellnummer) == true
				|| checkBeschreibung(beschreibung) == true) {
			String message = null;
			if (checkInventarnummer(inventarnummer) == true) {
				message = "Die Inventarnummer ist zu lang!";
			}
			if (checkModellnummer(modellnummer) == true) {
				message = message + "\nDie Modellnummer ist zu lang!";
			}
			if (checkBeschreibung(beschreibung) == true) {
				message = message + "\nDie Beschreibung ist zu lang!";
			}
			JOptionPane.showMessageDialog(null, message, "Datenbank-Info", 0); // Fehlermeldung bei zu langen Eingaben.

		} else {
			// Eingaben auf Vollständigkeit prüfen und anpassen.
			if (inventarnummer.equals("")) {
				inventarnummer = null;
			}
			if (preis.equals("")) {
				preis = "0";
			}
			if (modellnummer.equals("")) {
				modellnummer = null;
			}
			if (beschreibung.equals("")) {
				beschreibung = null;
			}
			try {
				connectToMysql(host, database, user, passwd);
				Statement stmt = con.createStatement();
				stmt.execute("INSERT INTO " + tabellenname
						+ " (inventarnummer, produkttyp, hersteller, modellnummer, beschreibung, preis, lieferant, einlagerungsdatum, auslagerungsdatum)"
						+ " VALUES ('" + inventarnummer + "','" + produkttyp + "','" + hersteller + "','" + modellnummer
						+ "','" + beschreibung + "','" + preis + "','" + lieferant + "','" + einlagerungsdatum + "','"
						+ auslagerungsdatum + "')");

				stmt.close();
				con.close();
				System.out.println("########## DB Connection wurde beendet  ##########"); // Statusausgabe
				JOptionPane.showMessageDialog(null, "Der Datensatz wurde erfolgreich hinzugefügt!", "Datenbank-Info",
						1);
			} catch (SQLException e) {
				if (e instanceof SQLIntegrityConstraintViolationException) { // Abfangen von falscher Eingabe, wenn
																				// die
																				// Inventarnummer doppelt verwendet
																				// werden
																				// will. Inventarnummer ist in der
																				// DB
																				// unique.

					System.out.println("########## DB Connection wurde beendet  ##########"); // Statusausgabe
					JOptionPane.showMessageDialog(null, "Die Inventarnummer ist bereits vergeben oder nicht gültig!",
							"Datenbank-Info", 0);
				} else if (e instanceof com.mysql.cj.jdbc.exceptions.MysqlDataTruncation) { // Abfangen von zu
																							// langen
																							// Eingaben.
					String a = e.toString();
					System.out.println(a);
					System.err.println(e);
					System.out.println("########## DB Connection wurde beendet  ##########"); // Statusausgabe
					JOptionPane.showMessageDialog(null,
							"Der Datensatz kann nicht eingefügt werden, ein Feld ist zu lang!.", "Datenbank-Info", 0);
				} else {
					System.err.println(e);
					System.out.println("########## DB Connection wurde beendet  ##########"); // Statusausgabe
					JOptionPane.showMessageDialog(null, "Der Datensatz konnte nicht hinzugefügt werden!",
							"Datenbank-Info", 0);
				}
			}
		}

	}

	public void delete(String tabelle, String inventarnummer) {
		if (wertVorhanden(tabelle, "inventarnummer", inventarnummer) == true) {
			try {
				connectToMysql(host, database, user, passwd);
				Statement stmt = con.createStatement();
				stmt.execute("DELETE FROM " + tabelle + " WHERE inventarnummer = '" + inventarnummer + "'");
				JOptionPane.showMessageDialog(null, "Der Datensatz wurde erfolgreich entfernt!", "Datenbank-Info", 1);
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Die Inventarnummer exestiert nicht!", "Datenbank-Info", 0);
		}

	}

	public void selectAll(String tabelle) {
		try {
			connectToMysql(host, database, user, passwd);
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
			String modellnummer, String beschreibung, String preis, String lieferant, String einlagerungsdatum,
			String auslagerungsdatum) {
		try {
			connectToMysql(host, database, user, passwd);
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE " + tabellenname + " SET produkttyp = '" + produkttyp + "', hersteller = '"
					+ hersteller + "', modellnummer = '" + modellnummer + "', beschreibung = '" + beschreibung
					+ "', preis = '" + preis + "', lieferant = '" + lieferant + "', einlagerungsdatum = '"
					+ einlagerungsdatum + "', auslagerungsdatum = '" + auslagerungsdatum + "' WHERE inventarnummer = '"
					+ inventarnummer + "'");

			stmt.close();

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
			connectToMysql(host, database, user, passwd);
			String query = "SELECT * FROM " + tabellenname;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int anzahlSpalten = rs.getMetaData().getColumnCount();
			con.close();
			return anzahlSpalten;

		} catch (SQLException e) {
			e.printStackTrace();

			return -1;
		}

	}

	/**
	 * @param tabellenname
	 * @param spalte
	 * @param wert
	 * @return Wenn es mindestens einen Datensatz mit dem Wert in der Spalte gibt,
	 *         dann wird true zurückgegeben.
	 */
	public boolean wertVorhanden(String tabellenname, String spalte, String wert) {
		try {
			connectToMysql(host, database, user, passwd);
			String query = "SELECT * FROM " + tabellenname + " WHERE " + spalte + " = '" + wert + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			boolean erg = rs.first();
			rs.close();
			stmt.close();
			con.close();
			return erg;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * @param inventarnummer
	 * @return true, wenn inventarnummer nicht die größtmögliche Länge
	 *         überschreitet.
	 */
	public boolean checkInventarnummer(String inventarnummer) {
		if (inventarnummer.length() > 8) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param modellnummer
	 * @return true, wenn modellnummer nicht die größtmögliche Länge überschreitet.
	 */
	public boolean checkModellnummer(String modellnummer) {
		if (modellnummer.length() > 45) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param beschreibung
	 * @return true, wenn beschreibung nicht die größtmögliche Länge überschreitet.
	 */
	public boolean checkBeschreibung(String beschreibung) {
		if (beschreibung.length() > 255) {
			return true;
		} else {
			return false;
		}
	}

}
