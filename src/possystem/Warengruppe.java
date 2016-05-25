package possystem;

public enum Warengruppe {
    SH("Shirt", 1),
    TO("Top", 2),
    BL("Bluse", 3),
    PU("Pullover und Sweatshirt", 4),
    HE("Hemd", 5),
    JE("Jeans", 6),
    HO("Hose", 7),
    SC("Schuh", 8);
    
    private String typ;
    private int bewertungszahl;
    
    Warengruppe(String rollenTyp, int bewertungszahl) {
        this.typ = rollenTyp;
        this.bewertungszahl = bewertungszahl;
    }
    
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public void setBewertungszahl(int zahl) {
        this.bewertungszahl = zahl;
    }
    
    public int getBewertungszahl( ) {
        return this.bewertungszahl;
    }
    public String getTyp() {
        return this.typ;
    }   
}
