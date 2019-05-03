import java.time.LocalDate;

/**
 * @category Hilfsklasse
 */
public class AktuellesDatum {

	/**
	 * @return Aktuelles Datum wird als String zurückgegeben | Format: Jahr-Monat-Tag
	 */
	public static String getCurrentDate() {
		LocalDate date = LocalDate.now();
		String d = date.toString();

		return d; // 2016-01-31
	}
}