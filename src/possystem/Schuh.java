package possystem;

// Unterklasse von Artikel
public class Schuh extends Artikel {
    private int schuhgroesse;
    
    // Standartkonstruktor
    public Schuh() {
    }
    
    // Konstruktor mit Parameter
    public Schuh(Warengruppe warengruppe, String marke, String farbe, String geschlecht, double preis, double rabatt, int anzahl, int schuhgroesse) {
        super(warengruppe, marke, farbe, geschlecht, preis, rabatt, anzahl); // verwendet den Konstruktor der Oberklasse (Superklasse). Muss an erster Stelle stehen!
        this.schuhgroesse = schuhgroesse;
    }
    
    // set-Methoden
    public void setSchuhGroesse(int groesse) {
        this.schuhgroesse = groesse;
    }
    
    // get-Methoden
    public int getSchuhGroesse() {
        return this.schuhgroesse;
    }    
}
