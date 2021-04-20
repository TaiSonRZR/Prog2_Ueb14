
import java.util.ArrayList;
/**
 * Klasse zum erstellen eines Mitarbeiters. Diese Klasse erbt von der Klasse Person
 */
public class Mitarbeiter extends Person {
	private String email;
	protected ArrayList<Reservierung> buchungen = new ArrayList<Reservierung>();
	
	public Mitarbeiter(String vorname,String nachname,String email) {
		super(vorname,nachname);
		this.email = email;
		
	}

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * tostring methode
	 */
	public String toString() {
	
		return super.getVorname() + " " + super.getNachname() + " " +"(" + this.getEmail() + ")";
		
	}
	
	/**
	 * Methode um einer Reservierung abzuschließen
	 * @param raum
	 * @param begin
	 * @param ende
	 * @param bemerkung
	 */
	public void reserviere(Raum raum,Uhrzeit begin,Uhrzeit ende,String bemerkung) {
		Reservierung res = new Reservierung(bemerkung,begin,ende);
		res.setRaum(raum);
		res.setMitarbeiter(this);
		raum.addReservierung(res);
		buchungen.add(res);
		}
	
	public boolean equals(Object obj) {
		Mitarbeiter mit1 = (Mitarbeiter) obj;
		
		if(!mit1.getVorname().equals(this.getVorname()))
			return false;
		
		if(!mit1.getNachname().equals(this.getNachname()))
			return false;
		
		
		if(!mit1.getEmail().equals(this.getEmail()))
			return false;
		
		return true;
				
	}
}
