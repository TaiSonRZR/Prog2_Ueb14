import java.util.ArrayList;
import java.util.Scanner;

public class Dialog {
    public Scanner sc = new Scanner(System.in);
    ArrayList<Mitarbeiter> emp = new ArrayList<>();
    ArrayList<Raum> rooms = new ArrayList<>();

    public int readInt() {
        int userInt = Integer.parseInt(sc.nextLine());
        return userInt;
    }

    public String readString() {
        String userString = sc.nextLine().trim();
        if (userString.isEmpty() != true) {
            return userString;
        }
        throw new IllegalStateException("Eingabe ist Leer");
    }

    public void displayRooms() {
        if (rooms.size() != 0) {
            for (int i = 0; i < rooms.size(); i++) {
                System.out.printf("%d. %s%n", i, rooms.get(i).toString());
            }
        }
    }

    public void displayEmp() {
        if (emp.size() != 0) {
            for (int i = 0; i < emp.size(); i++) {
                System.out.printf("%d. %s%n", i, emp.get(i).toString());
            }
        }
    }

    public void createRaum() {
        System.out.print("Gebäude eingeben: ");
        int build = readInt();
        System.out.print("Etage eingeben: ");
        int floor = readInt();
        System.out.print("Raum eingeben: ");
        int room = readInt();
        rooms.add(new Raum(build, floor, room));
    }

    public void createMitarbeiter() {
        System.out.print("Vorname: ");
        String fn = readString();
        System.out.print("Nachname: ");
        String ln = readString();
        System.out.print("E-Mail: ");
        String mail = readString();
        emp.add(new Mitarbeiter(fn, ln, mail));
    }

    public Uhrzeit createUhrzeitAnfang() {
        System.out.print("Beginn Stunde: ");
        int hour = readInt();
        System.out.print("Beginn Minute: ");
        int min = readInt();
        return new Uhrzeit(hour, min);
    }

    public Uhrzeit createUhrzeitEnde() {
        System.out.print("Ende Stunde: ");
        int hour = readInt();
        System.out.print("Ende Minute: ");
        int min = readInt();
        return new Uhrzeit(hour, min);
    }

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
                        emp.get(empInp).reserviere(rooms.get(roomInp), createUhrzeitAnfang(), createUhrzeitEnde(),note);
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void start() {
        final int RESERVIEREN = 1;
        final int MITARBEITERADD = 2;
        final int RAUMADD = 3;
        final int DISPLAYRAUM = 4;
        final int BEENDEN = 0;
        int eingabe = -1;

        while (eingabe != BEENDEN) {
            System.out.print("Reservieren: " + RESERVIEREN + "  Mitarbeiter hinzufügen: " + MITARBEITERADD
                    + "  Raum hinzufügen: " + RAUMADD + "  Räume anzeigen: " + DISPLAYRAUM + "  Beenden: " + BEENDEN
                    + "\n");
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