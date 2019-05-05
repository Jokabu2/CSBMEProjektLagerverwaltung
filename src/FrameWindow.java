import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class FrameWindow {

	JFrame frame;
	private JTextField textFieldInventarnummer;
	private JTextField textFieldEinlagerungsdatum;
	private JTextField textFieldModellNr;
	private JTextField textFieldPreis;
	private JTextField textFieldAuslDatum;
	private JTextField textFieldBeschreibung;
	private JTable table;

	/**
	 * Create the application.
	 */
	public FrameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String messageStrings[] = {"Lager 1","Lager 2","Lager 3"};
		String mySQLBefehle[] = {"SELECT","INSERT INTO","UPDATE","DELETE"};
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 992, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmSchliessen = new JMenuItem("Schliessen");
		mnDatei.add(mntmSchliessen);
		
		JLabel lblNewLabel = new JLabel("Lager\u00FCbersicht");
		
		JLabel lblBitteLagerAuswhlen = new JLabel("Bitte Lager ausw\u00E4hlen");
		
		JLabel lblAktion = new JLabel("Aktion");
		
		JLabel lblAktionAuswhlen = new JLabel("Aktion ausw\u00E4hlen");
		
		JComboBox comboBoxAktionen = new JComboBox(mySQLBefehle);
		comboBoxAktionen.setSelectedIndex(-1);
		comboBoxAktionen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == comboBoxAktionen) {
					JComboBox cb = (JComboBox)ae.getSource();
					String msg = (String)cb.getSelectedItem();
					switch (msg) {
						case "SELECT": lblAktionAuswhlen.setText("SELECT ausgewählt");
						break;
						case "INSERT INTO": lblAktionAuswhlen.setText("INSERT INTO ausgewählt");
						break;
						case "UPDATE": lblAktionAuswhlen.setText("UPDATE ausgewählt");
						break;
						case "DELETE": lblAktionAuswhlen.setText("DELETE ausgewählt");
						break;
						default: lblAktionAuswhlen.setText("Keine Aktion auswählen");
					}
				}
			}
		});
		

		
		JComboBox comboBoxLager = new JComboBox(messageStrings);
		comboBoxLager.setMaximumRowCount(10);
		comboBoxLager.setToolTipText("");
		comboBoxLager.setModel(new DefaultComboBoxModel(new String[] {"Lager 1 - Marketing", "Lager 2 - EDV", "Lager 3 - Fotostudio", "Lager 4 - Messe", "Lager 5 - Produktion", "Lager 6 - K\u00FCche"}));
		comboBoxLager.setSelectedIndex(-1);
		comboBoxLager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == comboBoxLager) {
					JComboBox cb = (JComboBox)ae.getSource();
					String msg = (String)cb.getSelectedItem();
					switch (msg) {
						case "Lager 1": lblBitteLagerAuswhlen.setText("Lager 1 ausgewählt");
						break;
						case "Lager 2": lblBitteLagerAuswhlen.setText("Lager 2 ausgewählt");
						break;
						case "Lager 3": lblBitteLagerAuswhlen.setText("Lager 3 ausgewählt");
						break;
						default: lblBitteLagerAuswhlen.setText("Kein Lager ausgewählt");
					}
				}
			}
		});
		
		textFieldInventarnummer = new JTextField();
		textFieldInventarnummer.setToolTipText("");
		textFieldInventarnummer.setColumns(10);
		
		JLabel lblInventarnummer = new JLabel("Inventarnummer");
		
		JLabel lblProdukttyp = new JLabel("Produkttyp");
		
		JLabel lblHersteller = new JLabel("Hersteller");
		
		JLabel lblModellnummer = new JLabel("Modellnummer");
		
		textFieldEinlagerungsdatum = new JTextField();
		textFieldEinlagerungsdatum.setColumns(10);
		
		textFieldModellNr = new JTextField();
		textFieldModellNr.setColumns(10);
		
		textFieldPreis = new JTextField();
		textFieldPreis.setColumns(10);
		
		JLabel lblLieferant = new JLabel("Lieferant");
		
		JLabel lblPreis = new JLabel("Preis");
		
		textFieldAuslDatum = new JTextField();
		textFieldAuslDatum.setColumns(10);
		
		JLabel lblEinlagerungsdatum = new JLabel("Einlagerungsdatum");
		
		JLabel lblAuslagerungsdatum = new JLabel("Auslagerungsdatum");
		
		JLabel lblBeschreibung = new JLabel("Beschreibung");
		
		textFieldBeschreibung = new JTextField();
		textFieldBeschreibung.setColumns(10);
		
		JComboBox comboBoxLieferant = new JComboBox();
		comboBoxLieferant.setModel(new DefaultComboBoxModel(new String[] {"Amazon", "Mindactory", "Reichelt"}));
		comboBoxLieferant.setSelectedIndex(-1);
		
		JComboBox comboBoxProdTyp = new JComboBox();
		comboBoxProdTyp.setModel(new DefaultComboBoxModel(new String[] {"Laptop", "Workstation", "Zero Client", "Bilschirm"}));
		comboBoxProdTyp.setSelectedIndex(-1);
		
		JComboBox comboBoxHersteller = new JComboBox();
		comboBoxHersteller.setModel(new DefaultComboBoxModel(new String[] {"HP", "Dell", "Apple", "Asus"}));
		comboBoxHersteller.setSelectedIndex(-1);
		
		JButton btnEingabenVerwerfen = new JButton("Eingaben verwerfen");
		
		JButton btnAusfhren = new JButton("Ausf\u00FChren");
		btnAusfhren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Button: Ausführen");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		

		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEingabenVerwerfen)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAusfhren))
						.addComponent(lblBeschreibung)
						.addComponent(lblAktion)
						.addComponent(textFieldBeschreibung)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxAktionen, 0, 122, Short.MAX_VALUE)
								.addComponent(comboBoxLager, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboBoxHersteller, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textFieldInventarnummer)
									.addComponent(lblHersteller)
									.addComponent(lblInventarnummer)
									.addComponent(lblProdukttyp)
									.addComponent(textFieldEinlagerungsdatum)
									.addComponent(lblEinlagerungsdatum)
									.addComponent(comboBoxProdTyp, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblAuslagerungsdatum)
									.addComponent(textFieldAuslDatum)
									.addComponent(lblPreis)
									.addComponent(lblLieferant)
									.addComponent(lblModellnummer)
									.addComponent(textFieldPreis)
									.addComponent(textFieldModellNr)
									.addComponent(comboBoxLieferant, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblBitteLagerAuswhlen)
									.addComponent(lblAktionAuswhlen)))))
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxLager, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBitteLagerAuswhlen))
							.addGap(18)
							.addComponent(lblAktion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxAktionen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAktionAuswhlen))
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInventarnummer)
								.addComponent(lblModellnummer))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldInventarnummer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldModellNr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProdukttyp)
								.addComponent(lblLieferant))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxLieferant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxProdTyp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHersteller)
								.addComponent(lblPreis))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldPreis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxHersteller, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEinlagerungsdatum)
								.addComponent(lblAuslagerungsdatum))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldEinlagerungsdatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldAuslDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBeschreibung)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldBeschreibung, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEingabenVerwerfen)
								.addComponent(btnAusfhren))))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		
		frame.getContentPane().setLayout(groupLayout);
	}
}
