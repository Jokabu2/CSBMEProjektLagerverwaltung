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
		
		// Men� einf�gen
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

		// Buttons werden dem JPanel hinzugef�gt
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		// JLabel wird dem Panel hinzugef�gt
		panel.add(label);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Die Quelle wird mit getSource() abgefragt und mit den
		// Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
		// der Buttons ist, wird der Text des JLabels entsprechend ge�ndert

		if (ae.getSource() == this.button1) {
			label.setText("Button 1 wurde bet�tigt");
		} else if (ae.getSource() == this.button2) {
			
			d1.tabelleAusgeben();
			
			label.setText("Button 2 wurde bet�tigt");
		} else if (ae.getSource() == this.button3) {
			label.setText("Button 3 wurde bet�tigt");
		}

	}
}
