import java.time.LocalDate;

public class AktuellesDatum {

	static String getCurrentDate() {
		LocalDate date = LocalDate.now();
		String d = date.toString();
		
		return d; // 2016-01-31
	}
}