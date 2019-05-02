
public class Frame {

<<<<<<< HEAD
public class Frame extends JFrame implements ActionListener{

	JButton button1;
    JButton button2;
    JButton button3;
    JLabel label;
    JPanel panel;
	
	Frame(){
		//Erzeugen des Fensters
		this.setTitle("Lagerverwaltungssystem");
        this.setSize(400, 200);
        panel = new JPanel();
        
        //Leeres JLabel-Objekt wird erzeugt
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
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
           
		if(ae.getSource() == this.button1){
			label.setText("Button 1 wurde betätigt");
        }
        else if(ae.getSource() == this.button2){
        	label.setText("Button 2 wurde betätigt");
        }
        else if (ae.getSource() == this.button3){            
            label.setText("Button 3 wurde betätigt");
        }
		
=======
	public void setVisible(boolean b) {
		
		
		
		
		
	public static void
>>>>>>> branch 'master' of https://github.com/Jokabu2/CSBMEProjektLagerverwaltung.git
	}

}
