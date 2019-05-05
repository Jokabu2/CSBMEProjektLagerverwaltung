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
import java.awt.TextArea;
import javax.swing.JTextArea;

public class FrameWindow {

	JFrame frame;
	private JTextField textFieldInventarnummer;
	private JTextField textFieldEinlagerungsdatum;
	private JTextField textFieldModellNr;
	private JTextField textFieldPreis;
	private JTextField textFieldAuslDatum;
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
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 992, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmSchliessen = new JMenuItem("Schliessen");
		mnDatei.add(mntmSchliessen);
		
		JLabel lblNewLabel = new JLabel("Lager\u00FCbersicht");
		lblNewLabel.setForeground(Color.BLACK);
		
		JLabel lblBitteLagerAuswhlen = new JLabel("Bitte Lager ausw\u00E4hlen");
		lblBitteLagerAuswhlen.setForeground(Color.DARK_GRAY);
		
		JLabel lblAktion = new JLabel("Aktion");
		lblAktion.setForeground(Color.BLACK);
		
		JLabel lblAktionAuswhlen = new JLabel("Aktion ausw\u00E4hlen");
		lblAktionAuswhlen.setForeground(Color.DARK_GRAY);
		
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
		comboBoxLager.setName("");
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
		lblInventarnummer.setForeground(Color.BLACK);
		
		JLabel lblProdukttyp = new JLabel("Produkttyp");
		lblProdukttyp.setForeground(Color.BLACK);
		
		JLabel lblHersteller = new JLabel("Hersteller");
		lblHersteller.setForeground(Color.BLACK);
		
		JLabel lblModellnummer = new JLabel("Modellnummer");
		lblModellnummer.setForeground(Color.BLACK);
		
		textFieldEinlagerungsdatum = new JTextField();
		textFieldEinlagerungsdatum.setColumns(10);
		
		textFieldModellNr = new JTextField();
		textFieldModellNr.setColumns(10);
		
		textFieldPreis = new JTextField();
		textFieldPreis.setColumns(10);
		
		JLabel lblLieferant = new JLabel("Lieferant");
		lblLieferant.setForeground(Color.BLACK);
		
		JLabel lblPreis = new JLabel("Preis");
		lblPreis.setForeground(Color.BLACK);
		
		textFieldAuslDatum = new JTextField();
		textFieldAuslDatum.setColumns(10);
		
		JLabel lblEinlagerungsdatum = new JLabel("Einlagerungsdatum");
		lblEinlagerungsdatum.setForeground(Color.BLACK);
		
		JLabel lblAuslagerungsdatum = new JLabel("Auslagerungsdatum");
		lblAuslagerungsdatum.setForeground(Color.BLACK);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung");
		lblBeschreibung.setForeground(Color.BLACK);
		
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
		btnEingabenVerwerfen.setAutoscrolls(true);
		
		JButton btnAusfhren = new JButton("Ausf\u00FChren");
		btnAusfhren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Button: Ausführen");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		

		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnEingabenVerwerfen)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAusfhren))
								.addComponent(lblBeschreibung)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(comboBoxLager, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBoxHersteller, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textFieldInventarnummer, Alignment.LEADING)
										.addComponent(lblHersteller, Alignment.LEADING)
										.addComponent(lblInventarnummer, Alignment.LEADING)
										.addComponent(lblProdukttyp, Alignment.LEADING)
										.addComponent(textFieldEinlagerungsdatum, Alignment.LEADING)
										.addComponent(lblEinlagerungsdatum, Alignment.LEADING)
										.addComponent(comboBoxProdTyp, Alignment.LEADING, 0, 144, Short.MAX_VALUE)
										.addComponent(comboBoxAktionen, 0, 122, Short.MAX_VALUE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(38)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblAuslagerungsdatum)
												.addComponent(textFieldAuslDatum)
												.addComponent(lblPreis)
												.addComponent(lblLieferant)
												.addComponent(textFieldPreis)
												.addComponent(textFieldModellNr)
												.addComponent(comboBoxLieferant, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblModellnummer)))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAktionAuswhlen)
												.addComponent(lblBitteLagerAuswhlen))))))
							.addComponent(lblAktion)))
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxLager, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBitteLagerAuswhlen))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAktion)
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxAktionen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAktionAuswhlen))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
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
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEingabenVerwerfen)
								.addComponent(btnAusfhren))))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		
		frame.getContentPane().setLayout(groupLayout);
	}
}
