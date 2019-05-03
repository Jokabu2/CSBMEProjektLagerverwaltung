//Klasse DBConnection
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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
	
	static Datenbank d1 = new Datenbank();

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
			label.setText("Button 1 wurde betätigt");
		} else if (ae.getSource() == this.button2) {
			
			d1.tabelleAusgeben();
			
			label.setText("Button 2 wurde betätigt");
		} else if (ae.getSource() == this.button3) {
			label.setText("Button 3 wurde betätigt");
		}

	}
}


class DBConnection{

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
