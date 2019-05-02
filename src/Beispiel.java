import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
 
// Damit Objekte der Klasse BeispielListener
// zum ActionListener werden kann, muss das Interface
// ActionListener implementiert werden
public class BeispielListener extends JFrame implements ActionListener
{
    JButton button1;
    JButton button2;
    JButton button3;
    JLabel label;
    JPanel panel;

 
    public BeispielListener(){
        this.setTitle("ActionListener Beispiel");
        this.setSize(400, 200);
        panel = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        label = new JLabel();
 
        //Drei Buttons werden erstellt
        button1 = new JButton("INSERT");
        button2 = new JButton ("SELECT");
        button3 = new JButton ("DELETE");
 
        //Buttons werden dem Listener zugeordnet
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
 
        //Buttons werden dem JPanel hinzugefügt
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
 
        //JLabel wird dem Panel hinzugefügt
        panel.add(label);
        this.add(panel);
    }
 
    public void actionPerformed (ActionEvent ae){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
        if(ae.getSource() == this.button1){
        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        		Connection con = DriverManager.getConnection(url,"root","");		
        		Statement stmt = con.createStatement();
        		stmt.execute("INSERT INTO lagerbestand (id,artikelname,anzahl)" + "VALUES (23,'Gucci-Tasche',5)");        		
        		stmt.close();
        		con.close();
        		
        	} catch(Exception e) {
        		System.out.println("**** FEHLERMELDUNG **** ->" + e);
        	}
            
            //label.setText(("Button 1 wurde betätigt"));
        }
        else if(ae.getSource() == this.button2){
        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        		
        		Connection con = DriverManager.getConnection(url,"root","");
        		
        		con.setReadOnly(true);
        		
        		Statement stmt = con.createStatement();
        		
        		ResultSet rs = stmt.executeQuery("Select * from lagerbestand");
        		
        		String s = "";
        		
        		while(rs.next()) {
        			
        			s += rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6)+" | "+rs.getString(7)+"\n";        			        			
        			
        		}
        		System.out.println(s);
        		label.setText(s);
        		
        		rs.close();
        		stmt.close();
        		con.close();
        		
        	} catch(Exception e) {
        		System.out.println("**** FEHLERMELDUNG **** ->" + e);
        	}
        }
        else if (ae.getSource() == this.button3){
        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        		
        		Connection con = DriverManager.getConnection(url,"root","");
        		
        		
        		
        		Statement stmt = con.createStatement();
        		
        		stmt.execute("DELETE FROM lagerbestand WHERE ID = 23");        		
        		
        		stmt.close();
        		con.close();
        		
        	} catch(Exception e) {
        		System.out.println("**** FEHLERMELDUNG **** ->" + e);
        	}
            
            //label.setText(("Button 1 wurde betätigt"));
        }
    }
}


https://download.eclipse.org/technology/babel/update-site/R0.16.1/2018-12/