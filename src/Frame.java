//Klasse DBConnection
import java.sql.*;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 9074017999343903867L;
	JButton button1;
	JButton button2;
	JButton button3;
	
	JMenuBar menubar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	
	JLabel label;
	JPanel panel;

	Frame() {
		// Erzeugen des Fensters
		this.setTitle("Lagerverwaltungssystem");
		this.setSize(1280, 720);
		panel = new JPanel();

		// Leeres JLabel-Objekt wird erzeugt
		label = new JLabel();
		
		// Menubar erzeugen
		menubar = new JMenuBar();
		
		// Menü einfügen
		menu = new JMenu("A menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menubar.add(menu);

		// Drei Buttons werden erstellt
		button1 = new JButton("INSERT");
		button2 = new JButton("SELECT");
		button3 = new JButton("DELETE");

		// Buttons werden dem Listener zugeordnet
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		// Buttons werden dem JPanel hinzugefügt
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		// JLabel wird dem Panel hinzugefügt
		panel.add(label);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Die Quelle wird mit getSource() abgefragt und mit den
		// Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
		// der Buttons ist, wird der Text des JLabels entsprechend geändert

		if (ae.getSource() == this.button1) {
			d1.insert("IT123456", "Drucker", "HP", "HMDHHD77H", "Fabian hat einen .:.", 12.21, "amazon", "2019-05-05", "2019-05-05");
		} else if (ae.getSource() == this.button2) {
			
			d1.tabelleAusgeben();
			
			label.setText("Button 2 wurde betätigt");
		} else if (ae.getSource() == this.button3) {
			label.setText("Button 3 wurde betätigt");
		}

	}
}


class DBConnection{

	Connection con;
	String myDriver = "com.mysql.cj.jdbc.Driver";

	public DBConnection() {
		//Eingabeparamter: host, Datenbank, Benutzer, Passwort
		connectToMysql("localhost:3306",  "lagerverwaltung",  "root",  "Kunxholli123");
	}
	
	public void connectToMysql(String host, String database, String user, String passwd) {
		try {
			Class.forName(myDriver).newInstance();
			String connectionCommand = "jdbc:mysql://"+host+"/"+database+"?user="+user+"&password="+passwd +"&serverTimezone=UTC";
				 
			con = DriverManager.getConnection(connectionCommand);
			System.out.println("connectToMysql Connection wurde erstellt");

		} catch (Exception ex) {
			System.err.println(ex);
			System.out.println("Fehler in der Methode: connectToMysql");
		}
	}
	
	public String getInsertQuery() {
		String query = "insert into bestand (inventarnummer, produkttyp, hersteller, modellnummer, beschreibung, preis, lieferant, einlagerungsdatum, auslagerungsdatum) VALUES (?,?,?,?,?,?,?,?,?)";
		return query;
	}

	public void insert(String inventarnummer, String produkttyp, String hersteller, String modellnummer,
			String beschreibung, double preis, String lieferant, String einlagerungsdatum, String auslagerungsdatum) {
		
		// Vorbereiteter INSERT-Befehl wird verwendet
		PreparedStatement preInsert;
		try {
			Statement stmt = con.createStatement();
    		stmt.execute("INSERT INTO lagerbestand (inventarnummer, produkttyp, hersteller, modellnummer, beschreibung, preis, lieferant, einlagerungsdatum, auslagerungsdatum)" + "VALUES ('IT123456','Drucker','HP','MPD233J', 'Sehr schwer','123.45','Amazon','2019-05-05','2019-05-05')");
/*
			// Eventuell VARCHAR Größen beachten

			preInsert = con.prepareStatement(getInsertQuery());
			preInsert.setString(1, inventarnummer);
			preInsert.setString(2, produkttyp);
			preInsert.setString(3, hersteller);
			preInsert.setString(4, modellnummer);
			preInsert.setString(5, beschreibung);
			preInsert.setDouble(6, preis);
			preInsert.setString(7, lieferant);
			preInsert.setString(8, einlagerungsdatum);
			preInsert.setString(9, auslagerungsdatum);
*/
			// Vorbereiteten Befehl ausführen
			//preInsert.execute();

		} catch (SQLException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}
	}
}
