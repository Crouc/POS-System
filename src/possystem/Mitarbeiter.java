package possystem;

public class Mitarbeiter {
    private String name;
    private String vorname;
    private Rolle rolle;                  // Mitarbeiter kann verschiedene Rollen einnehmen (Kassierer, Lagerverwalter, Geschäftsführer)
    private String user;
    private String pw;
    private String homeTEL;
    private String mobilTEL;
    private int alter;
    private int mitarbeiterID;
    private static int idCounter = 2000;
    
    // Standartkonstruktor
    public Mitarbeiter() {
    }
    
    // Konstruktor mit Parameter
    public Mitarbeiter(String vorname, String name, Rolle rolle, int alter, String user, String pw, String home, String mobil) {
        this.vorname = vorname;
        this.name = name;
        this.rolle = rolle;
        this.alter = alter;
        this.user = user;
        this.pw = pw;
        this.homeTEL = home;
        this.mobilTEL = mobil;
        this.mitarbeiterID = idCounter;
        idCounter++;
    }
    
    // set-Methoden
    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }
    public void setAlter(int alter) {
        this.alter = alter;
    }
    public void setMitarbeiterID(int mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public void setHomeTEL(String home) {
        this.homeTEL = home;
    }
    public void setMobilTEL(String mobil) {
        this.mobilTEL = mobil;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPW(String pw) {
        this.pw = pw;
    }
    
    // get-Methoden
    public Rolle getRolle() {
        return this.rolle;
    }
    public int getAlter() {
        return this.alter;
    }
    public int getMitarbeiterID() {
        return this.mitarbeiterID;
    }
    public String getName() {
        return this.name;
    }
    public String getVorname() {
        return this.vorname;
    }
    public String getHomeTEL() {
        return this.homeTEL;
    }
    public String getMobilTEL() {
        return this.mobilTEL;
    }
    public String getUser() {
        return this.user;
    }
    public String getPW() {
        return this.pw;
    }
}
