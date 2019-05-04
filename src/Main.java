
public class Main {

	public static void main(String[] args) {
		ConnectionToDB db = new ConnectionToDB();
		db.connectToMysql("localhost:3306", "lagerverwaltung", "root", "Kunxholli123");
		System.out.println("Fertig");
		
	}

}
