
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
	
	
	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}
	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.von= mitarbeiter;
	}
	
	public void setRaum(Raum raum) {
		this.raum = raum;
}
	public String getBemerkung() {
		return bemerkung;
	}
	public Uhrzeit getBegin() {
		return begin;
	}
	public Uhrzeit getEnde() {
		return ende;
	}
//write to string
	public String toString() {
		return "strng";
	}


}
