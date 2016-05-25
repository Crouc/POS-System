package possystem;

import java.util.Date;

public class Rechnung {
    private Date datum;
    private Kunde kunde;
    private Mitarbeiter mitarbeiter;
    private Rechnungsposition rechnungspos;
    private int rechnungsID;
    private static int idCounter = 5000;
    
    // Standartkonstruktor
    public Rechnung() {
    }
    
    // Konstruktor mit Parameter
    public Rechnung(Kunde kunde, Mitarbeiter mitarbeiter, Rechnungsposition rechnungspos, Date datum) {
        this.kunde = kunde;
        this.mitarbeiter = mitarbeiter;
        this.rechnungspos = rechnungspos;
        this.datum = datum;
        this.rechnungsID = idCounter;
        idCounter++;
    }
    
    // set-Methoden
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
    public void setRechnungsposition(Rechnungsposition rechnungspos) {
        this.rechnungspos = rechnungspos;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    public void setRechnungsID(int rechnungsID) {
        this.rechnungsID = rechnungsID;
    }
    
    // get-Methoden
    public Kunde getKunde() {
        return this.kunde;
    }
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }
    public Rechnungsposition getRechnungsposition() {
        return this.rechnungspos;
    }
    public Date getDatum() {
        return this.datum;
    }
    public int getRechnungsID() {
        return this.rechnungsID;
    }
}
