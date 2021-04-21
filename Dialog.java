import java.util.ArrayList;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;


/**
 * @author Emre, Simon Dialog Klasse
 */

public class Dialog {
    public Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
    ArrayList<Mitarbeiter> emp = new ArrayList<>();
    ArrayList<Raum> rooms = new ArrayList<>();

    /**
     * Einlesen einer Integer-Eingabe durch den Nutzer
     * 
     * @return Integer
     */
    public int readInt() {
        int userInt = Integer.parseInt(sc.nextLine());
        return userInt;
    }

    /**
     * Einlesen einer String-Eingabe durch den Nutzer
     * 
     * @return String
     */
    public String readString() {
        // String userString = "/"" + sc.nextLine().trim() + "/""

        String userString = sc.nextLine().trim();
        userString = (String) userString;
        if (userString.isEmpty() != true) {
            return userString;
        }
        throw new IllegalStateException("Eingabe ist  Leer");
    }

    /**
     * Auflisten aller bestehenden Räume und anzeigen der bestehenden Buchungen
     */
    public void displayRooms() {
        if (rooms.size() != 0) {
            for (int i = 0; i < rooms.size(); i++) {
                System.out.printf("%d. %s%n", i, rooms.get(i).toString());
            }
        } else {
            System.out.println("Es gibt kein Raum");
        }
    }

    /**
     * Auflisten aller bestehenden Mitarbeiter
     */
    public void displayEmp() {
        if (emp.size() != 0) {
            for (int i = 0; i < emp.size(); i++) {
                System.out.printf("%d. %s%n", i, emp.get(i).toString());
            }
        } else {
            System.out.println("Gibt es kein mitarbeiter!2");
        }
    }

    /**
     * 
     */
    public void displayRes() {
        displayRooms();
        System.out.print("Raum auswählen um die Menge der Reservierungen eines Raum zu sehen: ");
        int usrInp = readInt();
        if (rooms.get(usrInp).getAnzahlReservierungen() == 0) {
            System.out.println("Keine Reservierung eingetragen");
        }
        System.out.println("es gibt " + rooms.get(usrInp).getAnzahlReservierungen() + " Reservierungen ");
    }

    /**
     * Zum erstellen eines Raumes Dieser wird in der ArrayList <rooms> gespeichert
     */
    public void createRaum() {
        System.out.print("Gebäude eingeben: ");
        int build = readInt();
        System.out.print("Etage eingeben: ");
        int floor = readInt();
        System.out.print("Raum eingeben: ");
        int room = readInt();
        rooms.add(new Raum(build, floor, room));
    }

    /**
     * Zum erstellen eines Mitarbeiters Dieser wird in der ArrayList <emp>
     * gespeichert
     */
    public void createMitarbeiter() {
        System.out.print("Vorname: ");
        String fn = readString();
        System.out.print("Nachname: ");
        String ln = readString();
        System.out.print("E-Mail: ");
        String mail = readString();
        emp.add(new Mitarbeiter(fn, ln, mail));
    }

    /**
     * Zum eingeben der Anfangszeit der Reservierung
     * 
     * @return Uhrzeit(start)
     */
    public Uhrzeit createUhrzeitAnfang() {
        System.out.print("Beginn Stunde: ");
        int hour = readInt();
        System.out.print("Beginn Minute: ");
        int min = readInt();
        return new Uhrzeit(hour, min);
    }

    /**
     * Zum eingeben der Endzeit der Reservierung
     * 
     * @return Uhrzeit(ende)
     */
    public Uhrzeit createUhrzeitEnde() {
        System.out.print("Ende Stunde: ");
        int hour = readInt();
        System.out.print("Ende Minute: ");
        int min = readInt();
        return new Uhrzeit(hour, min);
    }

    /**
     * Erstellen einer Reservierung
     */
    public void createReservierung() {
        while (true) {
            try {
                displayEmp();
                System.out.print("Wähle Mitarbeiter: ");
                int empInp = readInt();
                if (empInp > emp.size() - 1) {
                    System.out.println("Mitarbeiter nicht vorhanden");
                } else {
                    displayRooms();
                    System.out.print("Wähle Raum: ");
                    int roomInp = readInt();
                    if (roomInp > rooms.size() - 1) {
                        System.out.println("Raum nicht vorhanden");
                    } else {
                        System.out.print("Bemerkung: ");
                        String note = readString();
                        emp.get(empInp).reserviere(rooms.get(roomInp), createUhrzeitAnfang(), createUhrzeitEnde(),
                                note);
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    /**
     * Start des Dialogs
     */
    public void start() {
        final int RESERVIEREN = 1;
        final int MITARBEITERADD = 2;
        final int RAUMADD = 3;
        final int DISPLAYRAUM = 4;
        final int DISPLAYRES = 5;
        final int BEENDEN = 0;
        int eingabe = -1;

        while (eingabe != BEENDEN) {
            System.out.print("Reservieren: " + RESERVIEREN + "  Mitarbeiter hinzufügen: " + MITARBEITERADD
                    + "  Raum hinzufügen: " + RAUMADD + "  Räume anzeigen: " + DISPLAYRAUM
                    + "  Reservierungen Anzeigen: " + DISPLAYRES + "  Beenden: " + BEENDEN + "\n");
            eingabe = readInt();
            try {
                if (eingabe == RESERVIEREN) {
                    if (emp.size() == 0) {
                        System.out.println("Zuerst Mitarbeiter hinzufügen");
                    }
                    if (rooms.size() == 0) {
                        System.out.println("Zuerst einen Raum erstellen");
                    }
                    if (rooms.size() > 0 && emp.size() > 0) {
                        createReservierung();
                    }
                } else if (eingabe == MITARBEITERADD) {

                    createMitarbeiter();
                } else if (eingabe == RAUMADD) {
                    createRaum();
                } else if (eingabe == DISPLAYRAUM) {
                    displayRooms();
                } else if (eingabe == DISPLAYRES) {
                    if (rooms.size() == 0) {
                        System.out.println("Kein Raum vorhanden");
                    } else {
                        displayRes();
                    }
                } else if (eingabe == BEENDEN) {
                    break;
                } else {
                    System.out.println("Falsche Eingabe");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        Dialog h1 = new Dialog();
        h1.start();
    }
}
