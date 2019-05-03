import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		Datenbank db1 = new Datenbank();
		db1.DBConnection();
		db1.insert("IT224567", "Drucker", "HP", "HK23jh", "Farbducker", 12334.34, "Amazon", "2019-01-30", null);
		
		
		/*
		Frame fl = new Frame();
        fl.setVisible(true);
        fl.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 */

		
	}

}
