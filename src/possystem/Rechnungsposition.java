package possystem;

public class Rechnungsposition {
    private Artikel artikel;
    private int anzahl;
    private float zwischensumme;
    
    // Standartkonstruktor
    public Rechnungsposition() {
    }
    
    // Konstruktor mit Parameter
    public Rechnungsposition(Artikel artikel, int anzahl, int zwischensumme) {
        this.anzahl = anzahl;
        this.artikel = artikel;
        this.zwischensumme = zwischensumme;
    }
    
    // set-Methoden
    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
    public void setZwischensumme(float zwischensumme) {
        this.zwischensumme = zwischensumme;
    }
    
    // get-Methoden
    public int getAnzahl() {
        return this.anzahl;
    }
    public Artikel getArtikel() {
        return this.artikel;
    }
    public float getZwischensumme() {
        return this.zwischensumme;
    }
}
