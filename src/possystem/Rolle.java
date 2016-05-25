package possystem;

public enum Rolle {
    KS("Kassierer", 1),
    LV("Lagerverwalter", 2),
    GF("Geschaeftsfuehrer", 3);
    
    private String typ;
    private int bewertungszahl;
    
    // Konstruktor mit Parameter
    Rolle(String rollenTyp, int bewertungszahl) {
        this.typ = rollenTyp;
        this.bewertungszahl = bewertungszahl;
    }
    // get-Methoden
    public int getBewertungszahl( ) {
        return this.bewertungszahl;
    }
    public String getTyp() {
        return this.typ;
    }
}
