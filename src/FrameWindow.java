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

import com.mysql.cj.util.TestUtils;

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
	private JTextField textFieldVerleihdatum;
	private JTable table;
	private JComboBox comboBoxLieferant;
	private JComboBox comboBoxProdTyp;
	private JComboBox comboBoxHersteller;
	private JTextArea textFieldBeschreibung;

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
		String messageStrings[] = { "Lager 1", "Lager 2", "Lager 3" };
		String mySQLBefehle[] = { "SELECT", "INSERT INTO", "UPDATE", "DELETE" };

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 1000, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);

		JMenuItem mntmSchliessen = new JMenuItem("Schliessen");
		mnDatei.add(mntmSchliessen);

		JLabel lblNewLabel = new JLabel("Lager\u00FCbersicht");
		lblNewLabel.setForeground(Color.BLACK);

		JLabel lblBitteLagerAuswhlen = new JLabel("Kein Lager ausgew\u00E4hlt");
		lblBitteLagerAuswhlen.setFont(new Font("SansSerif", Font.ITALIC, 12));
		lblBitteLagerAuswhlen.setForeground(Color.RED);

		JLabel lblAktion = new JLabel("Aktion");
		lblAktion.setForeground(Color.BLACK);

		JLabel lblAktionAuswhlen = new JLabel("Keine Aktion ausgew\u00E4hlt");
		lblAktionAuswhlen.setFont(new Font("SansSerif", Font.ITALIC, 12));
		lblAktionAuswhlen.setForeground(Color.RED);

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

		textFieldVerleihdatum = new JTextField();
		textFieldVerleihdatum.setColumns(10);

		JLabel lblEinlagerungsdatum = new JLabel("Einlagerungsdatum");
		lblEinlagerungsdatum.setForeground(Color.BLACK);

		JLabel lblVerleihdatum = new JLabel("Verleihdatum");
		lblVerleihdatum.setForeground(Color.BLACK);

		JLabel lblBeschreibung = new JLabel("Beschreibung");
		lblBeschreibung.setForeground(Color.BLACK);

		comboBoxLieferant = new JComboBox();
		comboBoxLieferant.setModel(new DefaultComboBoxModel(new String[] { "Amazon", "Mindactory", "Reichelt" }));
		comboBoxLieferant.setSelectedIndex(-1);

		comboBoxProdTyp = new JComboBox();
		comboBoxProdTyp.setModel(
				new DefaultComboBoxModel(new String[] { "Laptop", "Workstation", "Zero Client", "Bilschirm" }));
		comboBoxProdTyp.setSelectedIndex(-1);

		comboBoxHersteller = new JComboBox();
		comboBoxHersteller.setModel(new DefaultComboBoxModel(new String[] { "HP", "Dell", "Apple", "Asus" }));
		comboBoxHersteller.setSelectedIndex(-1);

		JButton btnEingabenVerwerfen = new JButton("Eingaben verwerfen");
		btnEingabenVerwerfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEingaben();
			}
		});
		btnEingabenVerwerfen.setAutoscrolls(true);

		JButton btnAusfhren = new JButton("Ausf\u00FChren");
		btnAusfhren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // Wen der Button "Ausführen" gedrückt wird, werden folgende
															// Anweisungen ausgeführt.
				textFieldEinlagerungsdatum.getText();
				deleteEingaben();
				System.out.println("Button: Ausführen");
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		textFieldBeschreibung = new JTextArea();
		scrollPane_1.setViewportView(textFieldBeschreibung);
		
		JScrollPane scrollPane = new JScrollPane();

		JSeparator separator = new JSeparator();

		JComboBox comboBoxLager = new JComboBox(messageStrings);
		comboBoxLager.setName("");
		comboBoxLager.setMaximumRowCount(10);
		comboBoxLager.setToolTipText("");
		comboBoxLager.setModel(new DefaultComboBoxModel(new String[] { "Lager 1 - Marketing", "Lager 2 - EDV",
				"Lager 3 - Fotostudio", "Lager 4 - Messe", "Lager 5 - Produktion", "Lager 6 - K\u00FCche" }));
		comboBoxLager.setSelectedIndex(-1);
		comboBoxLager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == comboBoxLager) {
					JComboBox cb = (JComboBox) ae.getSource();
					String msg = (String) cb.getSelectedItem();
					switch (msg) {
					case "Lager 1":
						lblBitteLagerAuswhlen.setVisible(false);
						break;
					case "Lager 2":
						lblBitteLagerAuswhlen.setVisible(false);
						break;
					case "Lager 3":
						lblBitteLagerAuswhlen.setVisible(false);
						break;
					default:
						
					}
				}
			}
		});
		
		JComboBox comboBoxAktionen = new JComboBox(mySQLBefehle);
		comboBoxAktionen.setModel(
				new DefaultComboBoxModel(new String[] { "Hinzuf\u00FCgen", "Suchen", "\u00C4ndern", "L\u00F6schen" }));
		comboBoxAktionen.setSelectedIndex(-1);
		comboBoxAktionen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == comboBoxAktionen) {
					JComboBox cb = (JComboBox) ae.getSource();
					String msg = (String) cb.getSelectedItem();

					switch (msg) {
					case "Hinzufügen":
						lblAktionAuswhlen.setVisible(false);
						textFieldEinlagerungsdatum.setEnabled(false);
						textFieldVerleihdatum.setEnabled(false);
						break;
					case "Suchen":
						lblAktionAuswhlen.setVisible(false);
						break;
					case "Ändern":
						lblAktionAuswhlen.setVisible(false);
						break;
					case "Löschen":

						break;
					default:
						
					}
				}
			}
		});
		


		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
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
													.addComponent(lblVerleihdatum)
													.addComponent(textFieldVerleihdatum)
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
													.addComponent(lblBitteLagerAuswhlen)))))
									.addComponent(scrollPane_1, Alignment.TRAILING))
								.addComponent(lblAktion))
							.addGap(12)))
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
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
								.addComponent(lblVerleihdatum))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldEinlagerungsdatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldVerleihdatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBeschreibung)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEingabenVerwerfen)
								.addComponent(btnAusfhren))))
					.addGap(1))
		);
		


		table = new JTable();
		scrollPane.setViewportView(table);

		frame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * Diese Methode setzt alle Felder auf sichtbar und editierbar.
	 */
	public void setAllVisibleAndEnabledTrue() {
		// Sichtbarkeit
		textFieldInventarnummer.setVisible(true);
		textFieldModellNr.setVisible(true);
		comboBoxProdTyp.setVisible(true);
		comboBoxLieferant.setVisible(true);
		comboBoxHersteller.setVisible(true);
		textFieldPreis.setVisible(true);
		textFieldEinlagerungsdatum.setVisible(true);
		textFieldVerleihdatum.setVisible(true);
		textFieldBeschreibung.setVisible(true);

		// Editierbarkeit
		textFieldInventarnummer.setEnabled(true);
		textFieldModellNr.setEnabled(true);
		comboBoxProdTyp.setEnabled(true);
		comboBoxLieferant.setEnabled(true);
		comboBoxHersteller.setEnabled(true);
		textFieldPreis.setEnabled(true);
		textFieldEinlagerungsdatum.setEnabled(true);
		textFieldVerleihdatum.setEnabled(true);
		textFieldBeschreibung.setEnabled(true);
	}

	/**
	 * Diese Methode setzt alle Felder auf nicht sichtbar und nicht editierbar.
	 */
	public void setAllVisibleAndEnabledFalse() {
		// Sichtbarkeit
		textFieldInventarnummer.setVisible(false);
		textFieldModellNr.setVisible(false);
		comboBoxProdTyp.setVisible(false);
		comboBoxLieferant.setVisible(false);
		comboBoxHersteller.setVisible(false);
		textFieldPreis.setVisible(false);
		textFieldEinlagerungsdatum.setVisible(false);
		textFieldVerleihdatum.setVisible(false);
		textFieldBeschreibung.setVisible(false);

		// Editierbarkeit
		textFieldInventarnummer.setEnabled(false);
		textFieldModellNr.setEnabled(false);
		comboBoxProdTyp.setEnabled(false);
		comboBoxLieferant.setEnabled(false);
		comboBoxHersteller.setEnabled(false);
		textFieldPreis.setEnabled(false);
		textFieldEinlagerungsdatum.setEnabled(false);
		textFieldVerleihdatum.setEnabled(false);
		textFieldBeschreibung.setEnabled(false);

	}
	
	/**
	 * Diese Methode setzt alle Eingabefelder auf null.
	 */
	public void deleteEingaben() {
		textFieldInventarnummer.setText(null);
		textFieldModellNr.setText(null);
		comboBoxProdTyp.setSelectedIndex(-1);
		comboBoxLieferant.setSelectedIndex(-1);
		comboBoxHersteller.setSelectedIndex(-1);
		textFieldPreis.setText(null);
		textFieldEinlagerungsdatum.setText(null);
		textFieldVerleihdatum.setText(null);
		textFieldVerleihdatum.setText(null);
		textFieldBeschreibung.setText(null);
	}

}
