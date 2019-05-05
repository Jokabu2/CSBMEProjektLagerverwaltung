import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameWindow window = new FrameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		
		/*ConnectionToDB db = new ConnectionToDB();
		db.connectToMysql("localhost:3306", "lagerverwaltung", "root", "Kunxholli123");
		System.out.println("Fertig");
		*/
	}

}
