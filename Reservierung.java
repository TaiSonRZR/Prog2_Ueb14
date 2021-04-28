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
		return "Raum: " + this.raum.toString() + "Mitarbeiter : "+ this.von.toString()+
				"Beginnt um:" + this.getBegin().toString() + "Endet : " + this.getEnde().toString() +
				"Bemerkung : " + this.getBemerkung();
	}
	// override
	public boolean equals(Object obj) {
		Reservierung res = (Reservierung) obj;

		if (this.getEnde() != res.getEnde())
			return false;
		
		if (this.getBegin() != res.getBegin())
		return false;


		if (!this.getBemerkung().equals(res.getBemerkung()))
			return false;
		if(!this.von.equals(res.von))
			return false;
		if(!this.raum.equals(res.raum))
			return false;
		return true;

	}


}
