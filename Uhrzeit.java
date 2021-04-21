/**
 * Klasse Uhrzeit
 * Eigenschaften von Uhrzeit
 */
public class Uhrzeit {
	private int stunde;
	private int minute;

	public Uhrzeit(int stunde, int minute) {
		if (stunde < 0 || stunde > 23) {
			throw new IllegalArgumentException("Ist größer als 23 oder kleiner als 0");
		}
		if (minute < 0 || minute > 59) {
			throw new IllegalArgumentException("Ist größer als 59 oder kleiner als 0");
		}
		this.stunde = stunde;
		this.minute = minute;
	}

	// override
	public String toString() {
		return this.getStunde() + ":" + this.getMinute() + " Uhr";
	}

	/**
	 * 
	 * @return stunde
	 */
	public int getStunde() {
		return stunde;
	}

	/**
	 * 
	 * @return minute
	 */
	public int getMinute() {
		return minute;
	}

	// override
	public boolean equals(Object obj) {
		Uhrzeit uhr = (Uhrzeit) obj;

		if (this.getStunde() != uhr.getStunde())
			return false;

		if (this.getMinute() != uhr.getMinute())
			return false;

		return true;

	}

}
