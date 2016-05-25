package possystem;

// Oberklasse von Hemd, Hose und Schuh
public class Artikel {
    private String marke;
    private String farbe;
    private String geschlecht;
    private Warengruppe warengruppe;
    private double preis;
    private double rabatt;
    private int artikelID;
    private int anzahl;
    private static int idCounter = 2000;
    
    // Standartkonstruktor
    public Artikel() { 
    }
    
    // Konstruktor mit Parameter
    public Artikel(Warengruppe warengruppe, String marke, String farbe, String geschlecht, double preis, double rabatt, int anzahl) {
        this.warengruppe = warengruppe;
        this.farbe = farbe;
        this.marke = marke;
        this.geschlecht = geschlecht;
        this.preis = preis;
        this.rabatt = rabatt;
        this.anzahl = anzahl;
        this.artikelID = idCounter;
        idCounter++;
    }
    
    // set-Methoden
    public void setMarke(String marke) {
        this.marke = marke;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }
    public void setWarengruppe(Warengruppe warengruppe) {
        this.warengruppe = warengruppe;
    }
    public void setPreis(double preis) {
        this.preis = preis;
    }
    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }
    public void setArtikelID(int artikelID) {
        this.artikelID = artikelID;
    }
    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
    
    // get-Methoden
    public String getMarke() {
        return this.marke;
    }
    public String getFarbe() {
        return this.farbe;
    }
    public String getGeschlecht() {
        return this.geschlecht;
    }
    public double getPreis() {
        return this.preis;
    }
    public double getRabatt() {
        return this.rabatt;
    }
    public int getArtikelID() {
        return this.artikelID;
    }
    public Warengruppe getWarengruppe() {
        return this.warengruppe;
    }
    public int getAnzahl() {
        return this.anzahl;
    }
}
