import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		//DB-Connection
		ConnectionToDB db = new ConnectionToDB();
		
		//Frame initialisieren
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameWindow window = new FrameWindow(db);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		

		
	}

}
