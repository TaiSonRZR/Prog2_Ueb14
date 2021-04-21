/**
 * Reservierung Klasse
 * Eigenschaften der Reservierung
 */
public class Reservierung {
	private String bemerkung;
	private Uhrzeit begin;
	private Uhrzeit ende;
	
	protected Mitarbeiter von;
	protected Raum raum;
	
	public Reservierung(String bemerkung,Uhrzeit begin, Uhrzeit ende) {
		this.bemerkung= bemerkung;
		this.begin= begin;
		this.ende = ende;
		
	}
	
	/**
	 *  Setter für Bemerkung
	 * @param bemerkung
	 */
	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}
	/**
	 * Setter für Mitarbeiter
	 * @param mitarbeiter
	 */
	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.von= mitarbeiter;
	}
	
	/**
	 * Setter für Raum
	 * @param raum
	 */
	public void setRaum(Raum raum) {
		this.raum = raum;
	}
	/**
	 * 
	 * @return bemerkung
	 */
	public String getBemerkung() {
		return bemerkung;
	}
	/**
	 * 
	 * @return begin
	 */
	public Uhrzeit getBegin() {
		return begin;
	}
	/**
	 * 
	 * @return ende
	 */
	public Uhrzeit getEnde() {
		return ende;
	}

	//write to string
	public String toString() {
		return "strng";
	}


}
