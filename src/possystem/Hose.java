package possystem;

// Unterklasse von Artikel
public class Hose extends Artikel {
    private double weite;
    private double laenge;
    
    // Standartkonstruktor
    public Hose() {   
    }
    
    // Konstruktor mit Parameter
    public Hose(Warengruppe warengruppe, String marke, String farbe, String geschlecht, double preis, double rabatt, int anzahl, double weite, double laenge) {
        super(warengruppe, marke, farbe, geschlecht, preis, rabatt, anzahl); // verwendet den Konstruktor der Oberklasse (Superklasse). Muss an erster Stelle stehen!
        this.weite = weite;
        this.laenge = laenge;
    }   
    
    // set-Methoden
    public void setWeite(double weite) {
        this.weite = weite;
    }
    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }
    
    // get-Methoden
    public double getWeite() {
        return this.weite;
    }
    public double getLaenge() {
        return this.laenge;
    }
}
