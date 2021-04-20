
public class Person {
	private String vorname;
	private String nachname;

	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String toString() {

		return this.vorname + this.nachname;

	}

	public boolean equals(Object obj) {
		Person per = (Person) obj;
		if (!this.getVorname().equals(per.getVorname()))
			return false;

		if (!this.getNachname().equals(per.getNachname()))
			return false;

		return true;
	}

}
