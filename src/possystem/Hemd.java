package possystem;

// Unterklasse von Artikel
public class Hemd extends Artikel {
    private String groesse;
    
    // Standartkonstruktor
    public Hemd() {
    }
    
    // Konstruktor mit Parameter
    public Hemd(Warengruppe warengruppe, String marke, String farbe, String geschlecht, double preis, double rabatt, int anzahl, String groesse) {
        super(warengruppe, marke, farbe, geschlecht, preis, rabatt, anzahl); // verwendet den Konstruktor der Oberklasse (Superklasse). Muss an erster Stelle stehen!
        this.groesse = groesse;
    }
    
    // set-Methoden
    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }
    
    // get-Methoden
    public String getGroesse() {
        return this.groesse;
    }
}
