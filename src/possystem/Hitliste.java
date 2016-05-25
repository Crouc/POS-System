package possystem;

import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Hitliste {
    private Mitarbeiter mitarbeiter;
    private Date datum;
    private double summe;
    
    public Hitliste() {
    }
    // Konstruktor mit Parameter
    public Hitliste(Mitarbeiter mitarbeiter, double summe, Date datum) {
        this.mitarbeiter = mitarbeiter;
        this.summe = summe;
        this.datum = datum;
    }
    
    // get-Methoden
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }
    public double getSumme() {
        return this.summe;
    }
    public Date getDatum() {
        return this.datum;
    }
}
