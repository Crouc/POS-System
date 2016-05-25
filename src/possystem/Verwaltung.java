package possystem;

/*
 * Import-Anweisungen, um Bibliotheken einzubinden.
 */
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
//import java.beans.*;                        // fuer die XML-Speicherung
import java.io.*;                           // fuer das Speichern und Laden in / von Dateien
import java.util.*;                         // fuer ArrayLists
import de.htw.saarland.stl.Stdin;           // fuer Eingaben von der Konsole
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Verwaltung
{
    private ArrayList <Mitarbeiter> mitarbeiterListe;               // mitarbeiterListe: Hier werden alle Mitarbeiter abgelegt
    private ArrayList <Kunde> kundenListe;                          // kundenListe: Hier werden alle Kunden abgelegt
    private ArrayList <Artikel> artikelListe;                       // artikelListe: Hier werden alle Artikel abgelegt
    private ArrayList <Rechnung> rechnungsListe;                    // rechnungsListe: Hier werden alle Rechnungen abgelegt
    private ArrayList <Rechnungsposition> rechnungspositionsListe;  // rechnungspositionsListe: Hier werden alle Positionen einer Rechnung abgelegt (1 Position = 1 Artikel)
    private ArrayList <Hitliste> hitListe;                          // hitListe: Hier werden Mitarbeiter mit Ihren erzielten Umsätzen abgelegt
    private String rememberLoginName;                               // Speichern des Mitarbeiter der eingeloggt ist, um den Nachnamen später auf die Rechnung zu schreiben
    private String rememberLoginPrename;                            // Speichern des Mitarbeiter der eingeloggt ist, um den Vornamen später auf die Rechnung zu schreiben

    final static int FELDLAENGE = 20;

    /**
     * Konstruktor für Objekte der Klasse Verwaltung
     */
    public Verwaltung() {
        mitarbeiterListe = new ArrayList <Mitarbeiter>();           
        kundenListe = new ArrayList <Kunde>();  
        artikelListe = new ArrayList <Artikel>();
        rechnungsListe = new ArrayList <Rechnung>();
        rechnungspositionsListe = new ArrayList <Rechnungsposition>();
        hitListe = new ArrayList <Hitliste>();
    }

    // legt zu Beginn des Programms Mitarbeiter, Kunde, Artikel, Rechnungen, Rechnungspositionen und Hitlisten an
    public void erzeugeStartDaten() throws ParseException {
        Mitarbeiter m1 = new Mitarbeiter("Kati", "Kiefer", Rolle.KS, 25, "katik", "123456", "0613 12574", "0151 42218476");
        Mitarbeiter m2 = new Mitarbeiter("Thomas", "Ehrhardt", Rolle.LV, 27, "thomase", "123456", "0681 896522", "0160 78661234");
        Mitarbeiter m3 = new Mitarbeiter("Nomin", "Naranbaatar", Rolle.LV, 25, "nominn", "123456", "089 78411", "0170 12345723");
        Mitarbeiter m4 = new Mitarbeiter("Eric", "Grünemeier", Rolle.GF, 21, "ericg", "123456", "030 600124", "0151 21216400");
        Mitarbeiter m5 = new Mitarbeiter("Natalie", "Rauber", Rolle.GF, 21, "natalier", "123456", "0681 45755", "0151 2486464");
        mitarbeiterListe.add(m1);
        mitarbeiterListe.add(m2);
        mitarbeiterListe.add(m3);
        mitarbeiterListe.add(m4);
        mitarbeiterListe.add(m5);
        
        Kunde k1 = new  Kunde("Lukas", "Schneider", 23);
        Kunde k2 = new  Kunde("Lars", "Roob", 31);
        Kunde k3 = new  Kunde("Sabine", "Linn", 37);
        Kunde k4 = new  Kunde("Elisa", "Müller", 36);
        Kunde k5 = new  Kunde("Melissa", "Schneider", 28);
        kundenListe.add(k1);
        kundenListe.add(k2);
        kundenListe.add(k3);
        kundenListe.add(k4);
        kundenListe.add(k5);
        
        Hose ho1 = new Hose(Warengruppe.JE, "G-Star", "Blau", "m", 119.99, 0, 2, 32, 34);
        Hose ho2 = new Hose(Warengruppe.HO, "Hugo Boss", "Schwarz", "m", 99.98, 20, 5, 34, 32);
        Hemd he1 = new Hemd(Warengruppe.TO, "Marco Polo", "Blau", "m", 39.99, 0, 8, "L");
        Hemd he2 = new Hemd(Warengruppe.BL, "Vero Moda", "Rot", "w", 30.00, 0, 2, "M");
        Schuh s1 = new Schuh(Warengruppe.SC, "Nike Air Max", "Blau", "m", 119.00, 30, 1, 44);
        Schuh s2 = new Schuh(Warengruppe.SC, "Vicini", "Gelb", "w", 55.00, 10, 3, 38);
        
        artikelListe.add(ho1);
        artikelListe.add(ho2);
        artikelListe.add(he1);
        artikelListe.add(he2);
        artikelListe.add(s1);
        artikelListe.add(s2);
        /*
        Rechnungsposition rp1 = new Rechnungsposition(ho1, 2, 0);
        Rechnungsposition rp2 = new Rechnungsposition(he2, 4, 0);
        Rechnungsposition rp3 = new Rechnungsposition(s1, 3, 0);
        Rechnungsposition rp4 = new Rechnungsposition(he1, 1, 0);
       
        rechnungspositionsListe.add(rp1);
        rechnungspositionsListe.add(rp2);
        rechnungspositionsListe.add(rp3);
        rechnungspositionsListe.add(rp4);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date t1 = sdf.parse("01.01.2016");
        Date t2 = sdf.parse("08.03.2016");
        Date t3 = sdf.parse("01.03.2016");
        Date t4 = sdf.parse("10.03.2016");
        
        Rechnung r1 = new Rechnung(k1, m1, rp1, t1);
        Rechnung r2 = new Rechnung(k2, m2, rp2, t2);
        Rechnung r3 = new Rechnung(k3, m3, rp3, t3);
        Rechnung r4 = new Rechnung(k4, m4, rp4, t4);
        
        rechnungsListe.add(r1);
        rechnungsListe.add(r2);
        rechnungsListe.add(r3);
        rechnungsListe.add(r4);
        
        Hitliste h1 = new Hitliste(m1, 200, t1);
        Hitliste h2 = new Hitliste(m1, 400, t2);
        Hitliste h3 = new Hitliste(m2, 100, t3);
        Hitliste h4 = new Hitliste(m3, 150, t4);
        
        hitListe.add(h1);
        hitListe.add(h2);
        hitListe.add(h3);
        hitListe.add(h4);*/
    }
 
    
/***************************************************************************************************************/
/**********************************Funktionen zum Speichern der Daten*******************************************/
/***************************************************************************************************************/
    private void saveDataToXML() throws IOException {
        XMLEncoder o = new XMLEncoder(new FileOutputStream("POS-System.xml"));
        o.writeObject("POS-System");
        o.writeObject(this);
        o.close();
    }

    public Object loadDataFromXML() throws IOException {
        XMLDecoder o = new XMLDecoder(new FileInputStream("POS-System.xml"));
        o.readObject();
        Object obj = o.readObject();
        o.close();
        return obj;
    }

    private void save() {
        try {
            saveDataToXML();
        }
        catch(java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void load() {
        try {
            Verwaltung v = (Verwaltung) loadDataFromXML();
            // hier starten wir ein neues Programm (eine neue Instanz der Klasse Verwaltung, der wir auch die Kontrolle übergeben), damit wir an die geladenen Daten kommen
            v.loginMenue();
            
        }
        catch(java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void beenden() {
        System.exit(0);
    }
    
    // ArrayLists set-Methoden
    public void setkundenListe(ArrayList liste) {
        this.kundenListe = liste;
    }
    
    public void setmitarbeiterListe(ArrayList liste) {
        this.mitarbeiterListe = liste;
    }
    
    public void setartikelListe(ArrayList liste) {
        this.artikelListe = liste;
    }
    
    public void setrechnungsListe(ArrayList liste) {
        this.rechnungsListe = liste;
    }
    
    public void setrechnungspositionsListe(ArrayList liste) {
        this.rechnungspositionsListe = liste;
    }
    
    public void sethitListe(ArrayList liste) {
        this.hitListe = liste;
    }
    
    // Arraylists get-Methoden
    public ArrayList getkundenListe() {
        return this.kundenListe;
    }
    
    public ArrayList getmitarbeiterListe() {
        return this.mitarbeiterListe;
    }
    
    public ArrayList getartikelListe() {
        return this.artikelListe;
    }
    
    public ArrayList getrechnungsListe() {
        return this.rechnungsListe;
    }
    
    public ArrayList getrechnungspositionsListe() {
        return this.rechnungspositionsListe;
    }
    
    public ArrayList gethitListe() {
        return this.hitListe;
    }

    
/***************************************************************************************************************/
/*************************************************Menüführung***************************************************/
/***************************************************************************************************************/
    public void loginMenue() {
        printProgrammInfo();
        boolean treffer = false;
        try {
            String user = Stdin.readlnString("Bitte geben Sie Ihren Benutzernamen ein:");
            String pw = Stdin.readlnString("Bitte geben Sie Ihr Passwort ein:");

            Iterator <Mitarbeiter>iter = mitarbeiterListe.iterator();
            while (iter.hasNext()) {
                Mitarbeiter m = iter.next();
                if (m.getUser().equalsIgnoreCase(user) && m.getPW().equalsIgnoreCase(pw)) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println("Benutzername oder Passwort falsch!");
                loginMenue();
                System.out.println("");
                System.out.println("");
                
            } else {
                Iterator <Mitarbeiter>iter2 = mitarbeiterListe.iterator();
                while (iter2.hasNext()) {
                    Mitarbeiter e = iter2.next();

                    if (e.getUser().equalsIgnoreCase(user) && e.getPW().equalsIgnoreCase(pw)) {
                        System.out.println("Herzlich Willkommen " + e.getVorname() + " " + e.getName());
                        rememberLoginName = e.getName();
                        rememberLoginPrename = e.getVorname();
                        switch (e.getRolle()) {
                            case KS:
                                mainMenueKassierer();
                                break;
                            case LV:
                                mainMenueLagerverwalter();
                                break;
                            default:
                                mainMenueGeschaeftsfuehrer();
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void mainMenueGeschaeftsfuehrer() {
        char eingabe;
        try {
            do {
                System.out.println("HAUPTMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Verwaltungsmenue");
                System.out.println("[2] Mitarbeitermenue");
                System.out.println("[3] Kundenmenue");
                System.out.println("[4] Lagerverwaltung");
                System.out.println("[5] Rechnungsmenue");
                System.out.println("[0] Logout");
                System.out.println("[x] Programm beenden");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung des POS-System. Das Programm wird beendet.");
                    beenden();
                    case '1': verwaltungsMenue();
                              break;
                    case '2': mitarbeiterMenue();
                              break;
                    case '3': kundenMenue();
                              break;
                    case '4': artikelMenue();
                              break;
                    case '5': rechnungsMenue();
                              break;
                    case '0': logout();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void mainMenueKassierer() {
        char eingabe;
        try {
            do {
                System.out.println("HAUPTMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Kundenmenue");
                System.out.println("[2] Lagerverwaltung");
                System.out.println("[0] Logout");
                System.out.println("[x] Programm beenden");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung des POS-System. Das Programm wird beendet.");
                    beenden();
                    case '1': kundenMenue();
                              break;
                    case '2': artikelMenue();
                              break;
                    case '0': logout();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }

    public void mainMenueLagerverwalter() {
        char eingabe;
        try {
            do {
                System.out.println("HAUPTMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Lagerverwaltung");
                System.out.println("[0] Logout");
                System.out.println("[x] Programm beenden");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case 'x': System.out.println("Vielen Dank für die Nutzung des POS-System. Das Programm wird beendet.");
                    beenden();
                    case '1': artikelMenue();
                              break;
                    case '0': logout();
                              break;
                    default: printEingabeFehler();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void verwaltungsMenue()  {
        char eingabe;
        try {
            boolean menuewechsel = false;
            do {
                System.out.println("VERWALTUNGSMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Lade Daten aus XML-Datei");
                System.out.println("[2] Speichere Daten in XML-Datei");
                System.out.println("[0] HAUPTMENUE");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': load();
                        break;
                    case '2': save();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
        
    public void mitarbeiterMenue() {
        char eingabe;
        try {
            boolean menuewechsel = false;
            do {
                System.out.println("MITARBEITERMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Mitarbeiter anlegen");
                System.out.println("[2] Mitarbeiter anzeigen");
                System.out.println("[3] Mitarbeiter suchen");
                System.out.println("[4] Mitarbeiter aendern");
                System.out.println("[5] Mitarbeiter loeschen");
                System.out.println("[6] Nach Umsatz sortierte Auflistung aller Verkäufer mit dem Tagesumsatz");
                System.out.println("[7] Nach Umsatz sortierte Auflistung aller Verkäufer mit dem Wochenumsatz");
                System.out.println("[8] Nach Umsatz sortierte Auflistung aller Verkäufer mit dem Monatsumsatz");
                System.out.println("[9] Auflistung aller Verkäufer mit dem Jahresumsatz für das laufende Jahr");
                System.out.println("[0] HAUPTMENUE");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': createEmployee();
                        break;
                    case '2': showEmployeeList();
                        break;
                    case '3': searchEmployee();
                        break;
                    case '4': changeEmployee();
                        break;
                    case '5': deleteEmployee();
                        break;
                    case '6': salesForDay();
                        break;
                    case '7': salesForWeek();
                        break;
                    case '8': salesForMonth();
                        break;
                    case '9': salesForYear();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void kundenMenue() {
        char eingabe;
        try {
            boolean menuewechsel = false;
            do {
                System.out.println("KUNDENMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Kunde anlegen");    // Legt einen neuen Kunden an
                System.out.println("[2] Kunden anzeigen");  // Zeigt alle Kunden an
                System.out.println("[3] Kunde suchen");     // sucht einen Kunden (Suche nach Nachname)
                System.out.println("[4] Kunde löschen");    // Löscht einen Kunden (Suche nach Nachname)
                System.out.println("[0] HAUPTMENUE");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': createCustomer();
                        break;
                    case '2': showCustomerList();
                        break;
                    case '3': searchCustomer();
                        break;
                    case '4': deleteCustomer();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void artikelMenue() {
        char eingabe;
        try {
            boolean menuewechsel = false;
            do {
                System.out.println("LAGERVERWALTUNG");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Artikel anlegen");      // Hose, Hemd oder Schuh
                System.out.println("[2] Atikel anzeigen");      // Anzeigen nach: Alle, nach Warengruppe, nach Marke
                System.out.println("[3] Artikel suchen");       // Suchen nach: Warengruppe, Marke, Farbe, Preis
                System.out.println("[4] Artikel verkaufen");    // Artikel wird von einem Mitarbeiter an einen Kunden verkaufen --> Rechnung erstellen
                System.out.println("[5] Artikel zurück");       // Kunde gibt einen Artikel zurück
                System.out.println("[6] Anzeigen aller Warengruppen");
                System.out.println("[0] HAUPTMENUE");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': createItem();
                        break;
                    case '2': showItemList();
                        break;
                    case '3': searchItem();
                        break;
                    case '4': sellItem();
                        break;
                    case '5': itemBack(); // Funktion funktioniert noch nicht
                        break;
                    case '6': showAllGroups();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void rechnungsMenue() {
        char eingabe;
        try {
            boolean menuewechsel = false;
            do {
                System.out.println("RECHNUNGSMENUE");
                System.out.println("------------------------------------------------------------");
                System.out.println("[1] Ausgabe aller Rechnungen für Heute");
                System.out.println("[2] Ausgabe aller Rechnungen für einen Monat");
                System.out.println("[3] Ausgabe aller Rechnungen für das aktuelle Jahr");
                System.out.println("[0] HAUPTMENUE");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': showInvoicesForToday();
                        break;
                    case '2': showInvoicesForWeek();
                        break;
                    case '3': showInvoicesForMonth();
                        break;
                    case '4': showInvoicesForYear();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void logout(){
        System.out.println("Sie haben sich erfolgreich ausgeloggt.");
        System.out.println("");
        loginMenue();
    }
    
/***************************************************************************************************************/
/**************************************Programmlogik (Hauptprogramm)********************************************/
/***************************************************************************************************************/  

/**************************************Mitarbeitermenue - Funktionen********************************************/
    private void createEmployee() {
        char eingabe;
        try {
            String vorname = Stdin.readlnString("Bitte geben Sie den Vornamen des Mitarbeiters ein:");
            String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Mitarbeiters ein:");
            int alter = Stdin.readInt("Bitte geben Sie das Alter des Mitarbeiters ein:");
            String user = Stdin.readlnString("Bitte geben Sie den Benutzernamen des Mitarbeiters ein:");
            String pw = Stdin.readlnString("Bitte geben Sie das Passwort des Mitarbeiters ein:");
            String home = Stdin.readlnString("Bitte geben Sie die Telefonnummer des Mitarbeiters ein:");
            String mobil = Stdin.readlnString("Bitte geben Sie die Handynummer des Mitarbeiters ein:");

            System.out.println("Bitte geben Sie die Rolle des Mitarbeiters ein:");
            System.out.println("[1] Kassierer");
            System.out.println("[2] Lagerverwalter");
            System.out.println("[3] Geschaeftsfuehrer");
            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe) {
                case '1': 
                    Mitarbeiter m1 = new Mitarbeiter(vorname, nachname, Rolle.KS, alter, user, pw, home, mobil);
                    mitarbeiterListe.add(m1);
                    break;
                case '2':
                    Mitarbeiter m2 = new Mitarbeiter(vorname, nachname, Rolle.LV, alter, user, pw, home, mobil);
                    mitarbeiterListe.add(m2);
                    break;
                case '3': 
                    Mitarbeiter m3 = new Mitarbeiter(vorname, nachname, Rolle.GF, alter, user, pw, home, mobil);
                    mitarbeiterListe.add(m3);
                    break;
                default: printEingabeFehler();
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void showEmployeeList() {
        String s;
        try {
            printZentriert("Mitarbeiter-ID");
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Rolle");
            printZentriert("Alter");
            printZentriert("Tel. privat");
            printZentriert("Tel. mobil");
            

            printLF();
            printLinieLF(7); // Trennlinie für 8 Felder anzeigen

            Iterator <Mitarbeiter>iter = mitarbeiterListe.iterator();
            while(iter.hasNext()) {
                Mitarbeiter i  =  iter.next();

                s = castInt2String(i.getMitarbeiterID());
                printZentriert(s);
                printLinksbuendig(i.getVorname());
                printLinksbuendig(i.getName());
                printLinksbuendig(i.getRolle().getTyp());
                s = castInt2String(i.getAlter());
                printZentriert(s);
                printLinksbuendig(i.getHomeTEL());
                printLinksbuendig(i.getMobilTEL());

                printLF();
            }
            printLF();
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void searchEmployee() {
        String s;
        try {
            boolean treffer = false;
            String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Mitarbeiters ein:");
        
            Iterator <Mitarbeiter>iter = mitarbeiterListe.iterator();
            while (iter.hasNext()) {
                Mitarbeiter m = iter.next();
                if (m.getName().equalsIgnoreCase(nachname)) {
                    treffer = true;
                }
            }
        
            if (!treffer) {
                System.out.println("Kein Mitarbeiter mit dem Namen " + nachname + " gefunden");
            } else {
                printZentriert("Vorname");
                printZentriert("Name");
                printZentriert("Rolle");
                printZentriert("Alter");
                printZentriert("Mitarbeiter-ID");
                printLF();
                printLinieLF(5); // Trennlinie für 6 Felder anzeigen 
            
                Iterator <Mitarbeiter>iter2 = mitarbeiterListe.iterator();
                while (iter2.hasNext()) {
                    Mitarbeiter e = iter2.next();
                
                    if (e.getName().equalsIgnoreCase(nachname)) {
                        printLinksbuendig(e.getVorname());
                        printLinksbuendig(e.getName());
                        printLinksbuendig(e.getRolle().getTyp());
                        s = castInt2String(e.getAlter());
                        printZentriert(s);
                        s = castInt2String(e.getMitarbeiterID());
                        printZentriert(s);  
                    }
                }
                printLF();
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }    
    
    public void changeEmployee() {
        try {
            boolean treffer = false;
            System.out.println("An welchem Mitarbeiter sollen Änderungen vorgenommen werden?");
            int mitarbeiterID = Stdin.readInt("Bitte geben Sie die Mitarbeiternummer ein:");
        
            Iterator <Mitarbeiter>iter = mitarbeiterListe.iterator();
            while (iter.hasNext()) {
                Mitarbeiter m = iter.next();
                if (m.getMitarbeiterID() == mitarbeiterID) {
                treffer = true;
                }
            }
        
            if (!treffer) {
                System.out.println("Kein Mitarbeiter mit der Nummer " + mitarbeiterID + " gefunden.");
            } else {
                Iterator <Mitarbeiter>iter2 = mitarbeiterListe.iterator();
                while (iter2.hasNext()) {
                    Mitarbeiter m = iter2.next();
                
                    if (m.getMitarbeiterID() == mitarbeiterID) {
                    char eingabe;
                    boolean menuewechsel = false;
                        do {
                            System.out.println("Welche Daten von " + m.getVorname() + " " + m.getName() + " möchten Sie ändern?"); 
                            System.out.println("[1] Rolle"); 
                            System.out.println("[2] Benutzername"); 
                            System.out.println("[3] Passwort"); 
                            System.out.println("[4] Telefonnummer");
                            System.out.println("[5] Mobiltelefonnummer");
                            System.out.println("[0] Mitarbeitermenue");

                            printAuswahlTreffen();
                            eingabe = Stdin.readlnChar();

                            switch (eingabe) {
                                case '0': menuewechsel = true;
                                    break;
                                case '1':
                                    System.out.println("Bitte geben Sie die neue Rolle des Mitarbeiters ein:");
                                    System.out.println("[1] Kassierer");
                                    System.out.println("[2] Lagerverwalter");
                                    System.out.println("[3] Geschaeftsfuehrer");
                                    System.out.println("[0] Mitarbeitermenue");
                                    printAuswahlTreffen();
                                    eingabe = Stdin.readlnChar();
                                    switch (eingabe) {
                                        case '0': menuewechsel = true;
                                            break;
                                        case '1':
                                            m.setRolle(Rolle.KS);
                                            break;
                                        case '2':
                                            m.setRolle(Rolle.LV);
                                            break;
                                        case '3':
                                            m.setRolle(Rolle.GF);
                                            break;
                                        default: printEingabeFehler();
                                    }   
                                    break;
                                case '2':
                                    String user = Stdin.readlnString("Bitte geben Sie einen neuen Benutzernamen ein: ");
                                    m.setUser(user);
                                    System.out.println("Benutzername wurde erfolgreich geändert");
                                    printLF();
                                    break;
                                case '3':
                                    String pw = Stdin.readlnString("Bitte geben Sie ein neues Passwort ein: ");
                                    m.setPW(pw);
                                    System.out.println("Passwort wurde erfolgreich geändert");
                                    printLF();
                                case '4':
                                    String home = Stdin.readlnString("Bitte geben Sie eine neue Telefonnummer ein: ");
                                    m.setHomeTEL(home);
                                    System.out.println("Telefonnummer wurde erfolgreich geändert");
                                    printLF();
                                case '5':
                                    String mobil = Stdin.readlnString("Bitte geben Sie eine neue Mobiltelefonnummer ein: ");
                                    m.setMobilTEL(mobil);
                                    System.out.println("Mobiltelefonnummer wurde erfolgreich geändert");
                                    printLF();
                                default:
                                    break;
                            }
                        } while (!menuewechsel);  
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void deleteEmployee() {
    try {
            boolean treffer = false;
            String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Mitarbeiters ein:");
        
            Iterator <Mitarbeiter>iter = mitarbeiterListe.iterator();
            while (iter.hasNext()) {
                Mitarbeiter m = iter.next();
                if (m.getName().equalsIgnoreCase(nachname)) {
                    treffer = true;
                }
            }
        
            if (!treffer) {
                System.out.println("Kein Mitarbeiter mit dem Namen " + nachname + " gefunden");
            } else {
                Iterator <Mitarbeiter>iter2 = mitarbeiterListe.iterator();
                while (iter2.hasNext()) {
                    Mitarbeiter e = iter2.next();
                
                    if (e.getName().equalsIgnoreCase(nachname)) {
                        String bestaetigung = Stdin.readlnString("Möchten Sie den Kunden " + e.getVorname() + " " + e.getName() + " wirklich löschen? [J/N]");
                        if(bestaetigung.equalsIgnoreCase("J")) {
                            iter2.remove(); // Löscht ein Objekt der Klasse Mitarbeiter
                        } else {
                            mitarbeiterMenue();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        } 
    }
   
    private void salesForDay() {
        String s;
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");            
        Iterator <Hitliste>iter = hitListe.iterator();
        while (iter.hasNext()) {
            Hitliste h = iter.next();
            Date past = h.getDatum();
            if (sdf.format(now).equals(sdf.format(past)) ) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("Am " + sdf.format(now) + " wurden noch keine Umsätze generiert.");
        } else {     
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Umsatz");
            printLF();
            printLinieLF(3); // Trennlinie für 6 Felder anzeigen 
            
            Iterator <Hitliste>iter2 = hitListe.iterator();
            while (iter2.hasNext()) {
                Hitliste i = iter2.next();
                Date past = i.getDatum();
                if (sdf.format(now).equals(sdf.format(past))) {
                    printLinksbuendig(i.getMitarbeiter().getVorname());
                    printLinksbuendig(i.getMitarbeiter().getName());
                    s = castDouble2String(i.getSumme());
                    printZentriert(s);
                }
                printLF();
            }
        }
        printLF();  
    }
    
    private void salesForWeek() {
        String s;
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("w.yyyy");
        Iterator <Hitliste>iter = hitListe.iterator();
        while (iter.hasNext()) {
            Hitliste h = iter.next();
            Date past = h.getDatum();
            if (sdf.format(past).equals(sdf.format(now))) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("In dieser Woche wurden noch keine Umsätze generiert!");
        } else {     
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Umsatz");
            printLF();
            printLinieLF(3); // Trennlinie für 6 Felder anzeigen 
            
            Iterator <Hitliste>iter2 = hitListe.iterator();
            while (iter2.hasNext()) {
                Hitliste i = iter2.next();
                Date past = i.getDatum(); 
                if (sdf.format(past).equals(sdf.format(now))) {
                    printLinksbuendig(i.getMitarbeiter().getVorname());
                    printLinksbuendig(i.getMitarbeiter().getName());
                    s = castDouble2String(i.getSumme());
                    printZentriert(s);
                }
                printLF();
            }
        }
        printLF();  
    }
    
    private void salesForMonth() {
        String s;
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM.yyyy");
        Iterator <Hitliste>iter = hitListe.iterator();
        while (iter.hasNext()) {
            Hitliste h = iter.next();
            Date past = h.getDatum();
            if (sdf.format(past).equals(sdf.format(now))) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("In diesem Monat wurden noch keine Umsätze generiert.");
        } else {     
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Umsatz");
            printLF();
            printLinieLF(3); // Trennlinie für 6 Felder anzeigen 
            
            Iterator <Hitliste>iter2 = hitListe.iterator();
            while (iter2.hasNext()) {
                Hitliste i = iter2.next();
                Date past = i.getDatum();
                if (sdf.format(past).equals(sdf.format(now))) {
                    printLinksbuendig(i.getMitarbeiter().getVorname());
                    printLinksbuendig(i.getMitarbeiter().getName());
                    s = castDouble2String(i.getSumme());
                    printZentriert(s);
                }
                printLF();
            }
        }
        printLF(); 
    }
    
    private void salesForYear() {
        String s;
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Iterator <Hitliste>iter = hitListe.iterator();
        while (iter.hasNext()) {
            Hitliste h = iter.next();
            Date past = h.getDatum();          
            if (sdf.format(past).equals(sdf.format(now))) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("In diesem Jahr wurden noch keine Umsätze generiert.");
        } else {     
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Umsatz");
            printLF();
            printLinieLF(3); // Trennlinie für 6 Felder anzeigen 
            
            Iterator <Hitliste>iter2 = hitListe.iterator();
            while (iter2.hasNext()) {
                Hitliste i = iter2.next();
                Date past = i.getDatum();
                if (sdf.format(past).equals(sdf.format(now))) {
                    printLinksbuendig(i.getMitarbeiter().getVorname());
                    printLinksbuendig(i.getMitarbeiter().getName());
                    s = castDouble2String(i.getSumme());
                    printZentriert(s);
                }
                printLF();
            }
        }
        printLF(); 
    }
    
/****************************************Kundenmenue - Funktionen**********************************************/
    private void createCustomer() {
        try {
            String vorname = Stdin.readlnString("Bitte geben Sie den Vornamen des Kunden ein:");
            String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Kunden ein:");
            int alter = Stdin.readInt("Bitte geben Sie das Alter des Kunden ein:");

            Kunde k1 = new Kunde(vorname, nachname, alter);
            kundenListe.add(k1);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    public void showCustomerList() {
        String s;

        printZentriert("Vorname");
        printZentriert("Name");
        printZentriert("Alter");
        printZentriert("Kunden-ID");
        printLF();
        printLinieLF(4); // Trennlinie für 6 Felder anzeigen
        
        Iterator <Kunde>iter = kundenListe.iterator();
        while(iter.hasNext()) {
            Kunde i  =  iter.next();

            printLinksbuendig(i.getVorname());
            printLinksbuendig(i.getName());
            s = castInt2String(i.getAlter());
            printZentriert(s);
            s = castInt2String(i.getKundenID());
            printZentriert(s);

            printLF();
        }
        printLF();
    }
    
    public void searchCustomer() {
        String s;
        boolean treffer = false;
        String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Kunden ein:");
        
        Iterator <Kunde>iter = kundenListe.iterator();
        while (iter.hasNext()) {
            Kunde k = iter.next();
            if (k.getName().equalsIgnoreCase(nachname)) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("Kein Kunde mit dem Namen " + nachname + " gefunden");
        } else {
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Alter");
            printZentriert("Kunden-ID");
            printLF();
            printLinieLF(4); // Trennlinie für 6 Felder anzeigen 
            
            Iterator <Kunde>iter2 = kundenListe.iterator();
            while (iter2.hasNext()) {
                Kunde e = iter2.next();
                
                if (e.getName().equalsIgnoreCase(nachname)) {
                    printLinksbuendig(e.getVorname());
                    printLinksbuendig(e.getName());
                    s = castInt2String(e.getAlter());
                    printZentriert(s);
                    s = castInt2String(e.getKundenID());
                    printZentriert(s); 
                    System.out.println();
                }
            }
        }
    }  
    
    public void deleteCustomer() {
        boolean treffer = false;
        String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Kundens ein:");
        
        Iterator <Kunde>iter = kundenListe.iterator();
        while (iter.hasNext()) {
            Kunde k = iter.next();
            if (k.getName().equalsIgnoreCase(nachname)) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("Kein Kunde mit dem Namen " + nachname + " gefunden");
        } else {
            Iterator <Kunde>iter2 = kundenListe.iterator();
            while (iter2.hasNext()) {
                Kunde e = iter2.next();
                
                if (e.getName().equalsIgnoreCase(nachname)) {
                    String bestaetigung = Stdin.readlnString("Möchten Sie den Kunden " + e.getVorname() + " " + e.getName() + " wirklich löschen? [J/N]");
                    if(bestaetigung.equalsIgnoreCase("J")) {
                        iter2.remove(); // Löscht ein Objekt der Klasse Kunde
                    } else {
                        kundenMenue();
                    }
                }
            }
        } 
    }

/****************************************Artikelmenue - Funktionen**********************************************/
    private void createItem() {
        char eingabe;
        try {
            boolean menuewechsel = false;
            do {
                System.out.println("Welchen Artikel möchten Sie anlegen?"); 
                System.out.println("[1] Hose"); 
                System.out.println("[2] Hemd"); 
                System.out.println("[3] Schuh"); 
                System.out.println("[0] zurück zur Lagerverwaltung");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': createItemHose();
                        break;
                    case '2': createItemHemd();
                        break;
                    case '3': createItemSchuh();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void createItemHose() {
        char eingabe;
        try {
            String marke = Stdin.readlnString("Bitte geben Sie die Marke der Hose ein:");
            String farbe = Stdin.readlnString("Bitte geben Sie die Farbe der Hose ein:");
            String geschlecht = Stdin.readlnString("männlich/weiblich:");
            double preis = Stdin.readlnDouble("Bitte geben Sie den Preis der Hose ein:");
            double rabatt = Stdin.readlnDouble("Bitte geben Sie den Rabatt der Hose ein (%):");
            int anzahl = Stdin.readlnInt("Bitte geben Sie die Anzahl an:");
            double weite = Stdin.readlnDouble("Bitte geben Sie die Weite der Hose ein:");
            double laenge = Stdin.readlnDouble("Bitte geben Sie die Laenge der Hose ein:");

            System.out.println("Bitte geben Sie die Warengruppe der Hose ein:");
            System.out.println("[1] Jeans");
            System.out.println("[2] Hosen");
            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe) {
                case '1': 
                    Hose h1 = new Hose(Warengruppe.JE, marke, farbe, geschlecht, preis, rabatt, anzahl, weite, laenge);
                    artikelListe.add(h1);
                    break;
                case '2':
                    Hose h2 = new Hose(Warengruppe.HO, marke, farbe, geschlecht, preis, rabatt, anzahl, weite, laenge);
                    artikelListe.add(h2);
                    break;
                default: printEingabeFehler();
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void createItemHemd() {
        char eingabe;
        try {
            String marke = Stdin.readlnString("Bitte geben Sie die Marke des Hemdes ein:");
            String farbe = Stdin.readlnString("Bitte geben Sie die Farbe des Hemdes ein:");
            String geschlecht = Stdin.readlnString("männlich/weiblich:");
            double preis = Stdin.readlnDouble("Bitte geben Sie den Preis des Hemdes ein:");
            double rabatt = Stdin.readlnDouble("Bitte geben Sie den Rabatt des Hemdes ein (%):");
            int anzahl = Stdin.readlnInt("Bitte geben Sie die Menge an:");
            String groesse = Stdin.readlnString("Bitte geben Sie die Groesse des Hemdes ein:");

            System.out.println("Bitte geben Sie die Warengruppe des Hemdes ein:");
            System.out.println("[1] Shirt");
            System.out.println("[2] Top");
            System.out.println("[3] Bluse");
            System.out.println("[4] Pullover");
            System.out.println("[5] Hemd");
            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe) {
                case '1': 
                    Hemd h1 = new Hemd(Warengruppe.SH, marke, farbe, geschlecht, preis, rabatt, anzahl, groesse);
                    artikelListe.add(h1);
                    break;
                case '2':
                    Hemd h2 = new Hemd(Warengruppe.TO, marke, farbe, geschlecht, preis, rabatt, anzahl, groesse);
                    artikelListe.add(h2);
                    break;
                case '3':
                    Hemd h3 = new Hemd(Warengruppe.BL, marke, farbe, geschlecht, preis, rabatt, anzahl, groesse);
                    artikelListe.add(h3);
                    break;
                case '4':
                    Hemd h4 = new Hemd(Warengruppe.PU, marke, farbe, geschlecht, preis, rabatt, anzahl, groesse);
                    artikelListe.add(h4);
                    break;
                case '5':
                    Hemd h5 = new Hemd(Warengruppe.HE, marke, farbe, geschlecht, preis, rabatt, anzahl, groesse);
                    artikelListe.add(h5);
                    break;
                default: printEingabeFehler();
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void createItemSchuh() {
        try {
            String marke = Stdin.readlnString("Bitte geben Sie die Marke des Schuhs ein:");
            String farbe = Stdin.readlnString("Bitte geben Sie die Farbe des Schuhs ein:");
            String geschlecht = Stdin.readlnString("männlich/weiblich:");
            double preis = Stdin.readlnDouble("Bitte geben Sie den Preis des Schuhs ein:");
            double rabatt = Stdin.readlnDouble("Bitte geben Sie den Rabatt des Schuhs ein (%):");
            int anzahl = Stdin.readlnInt("Bitte geben Sie die Anzahl an:");
            int schuhgroesse = Stdin.readlnInt("Bitte geben Sie die Groesse des Schuhs ein:");

            Schuh s1 = new Schuh(Warengruppe.SC, marke, farbe, geschlecht, preis, rabatt, anzahl, schuhgroesse);
            artikelListe.add(s1);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void showItemList() {
        char eingabe;
        boolean menuewechsel = false;
        try {
            do {
                System.out.println("[1] Ausgabe des gesamten Lagerbestandes"); 
                System.out.println("[2] Ausgabe des Lagerbestandes nach Warengruppe"); 
                System.out.println("[3] Ausgabe des Lagerbestandes nach Marke"); 
                System.out.println("[0] zurück zur Lagerverwaltung");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': showTotalItemList();
                        break;
                    case '2': showItemListPerGroup();
                        break;
                    case '3': showItemListPerBrand();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void showTotalItemList() {
        String s;
        printZentriert("Aritkel ID");
        printZentriert("Warengruppe");
        printZentriert("Marke");
        printZentriert("Farbe");
        printZentriert("Geschlecht");
        printZentriert("Preis");
        printZentriert("Rabatt");
        printZentriert("Anzahl");
        printZentriert("Weite");
        printZentriert("Länge");
        printLF();
        printLinieLF(10); // Trennlinie für 11 Felder anzeigen

        Iterator <Artikel>iter = artikelListe.iterator();
        while(iter.hasNext())
        {
            Artikel i  =  iter.next();
            
            s = castInt2String(i.getArtikelID());
            printZentriert(s);
            printLinksbuendig(i.getWarengruppe().getTyp());
            printLinksbuendig(i.getMarke());
            printLinksbuendig(i.getFarbe());
            printZentriert(i.getGeschlecht());
            s = castDouble2String(i.getPreis());
            printZentriert(s);
            s = castDouble2String(i.getRabatt());
            printZentriert(s);
            s = castInt2String(i.getAnzahl());
            printZentriert(s);

            if (i instanceof Hose) { // wenn der Artikel ein Exemplar der Klasse Hose ist
                Hose hose = (Hose)i;
                s = castDouble2String(hose.getWeite());
                printZentriert(s);
                s = castDouble2String(hose.getLaenge());
                printZentriert(s);
            }
            if (i instanceof Hemd) { // wenn der Artikel ein Exemplar der Klasse Hemd ist
                Hemd hemd = (Hemd)i;
                printZentriert(hemd.getGroesse());
            }
            if (i instanceof Schuh) { // wenn der Artikel ein Exemplar der Klasse Schuh ist
                Schuh schuh = (Schuh)i;
                s = castInt2String(schuh.getSchuhGroesse());
                printZentriert(s);
            }
            printLF();
        }
    }
    
    private void showItemListPerGroup() {
        String s;
        try {
            String warengruppe = Stdin.readlnString("Geben Sie die Warengruppe ein:");

            printZentriert("Artikel ID");
            printZentriert("Warengruppe");
            printZentriert("Marke");
            printZentriert("Farbe");
            printZentriert("Geschlecht");
            printZentriert("Preis");
            printZentriert("Rabatt");
            printZentriert("Anzahl");

            printLF();
            printLinieLF(8); // Trennlinie für 8 Felder anzeigen

            Iterator <Artikel>iter = artikelListe.iterator();
            while(iter.hasNext()) {
                Artikel a  =  iter.next();
                   if(a.getWarengruppe().getTyp().equals(warengruppe)) {
                        s = castInt2String(a.getArtikelID());
                        printZentriert(s);
                        printLinksbuendig(a.getWarengruppe().getTyp());
                        printLinksbuendig(a.getMarke());
                        printLinksbuendig(a.getFarbe());
                        printLinksbuendig(a.getGeschlecht());
                        s = castDouble2String(a.getPreis());
                        printZentriert(s);
                        s = castDouble2String(a.getRabatt());
                        printZentriert(s);
                        s = castInt2String(a.getAnzahl());
                        printZentriert(s);
                        
                        printLF();
                   }
            }
            printLF();
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void showItemListPerBrand() {
        String s;
        try {
            String marke = Stdin.readlnString("Geben Sie die Marke ein:");

            printZentriert("Artikel ID");
            printZentriert("Warengruppe");
            printZentriert("Marke");
            printZentriert("Farbe");
            printZentriert("Geschlecht");
            printZentriert("Preis");
            printZentriert("Rabatt");
            printZentriert("Anzahl");

            printLF();
            printLinieLF(7); // Trennlinie für 7 Felder anzeigen

            Iterator <Artikel>iter = artikelListe.iterator();
            while(iter.hasNext()) {
                Artikel a  =  iter.next();
                   if(a.getMarke().equalsIgnoreCase(marke)) {
                        s = castInt2String(a.getArtikelID());
                        printZentriert(s);
                        printLinksbuendig(a.getWarengruppe().getTyp());
                        printLinksbuendig(a.getMarke());
                        printLinksbuendig(a.getFarbe());
                        printLinksbuendig(a.getGeschlecht());
                        s = castDouble2String(a.getPreis());
                        printZentriert(s);
                        s = castDouble2String(a.getRabatt());
                        printZentriert(s);
                        s = castInt2String(a.getAnzahl());
                        printZentriert(s);
                        
                        printLF();
                   }
            }
            printLF();
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void searchItem() {
        char eingabe;
        boolean menuewechsel = false;
        try {
            do {
                System.out.println("Wie möchten Sie nach dem Artikel suchen?"); 
                System.out.println("[1] Warengruppe"); 
                System.out.println("[2] Marke"); 
                System.out.println("[3] Farbe"); 
                System.out.println("[4] Preis"); 
                System.out.println("[0] zurück zur Lagerverwaltung");

                printAuswahlTreffen();
                eingabe = Stdin.readlnChar();

                switch (eingabe) {
                    case '0': menuewechsel = true;
                        break;
                    case '1': searchItemForGroup();
                        break;
                    case '2': searchItemForBrand();
                        break;
                    case '3': searchItemForColor();
                        break;
                    case '4': searchItemForPrice();
                        break;
                    default: printEingabeFehler();
                }
            } while (!menuewechsel);
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void searchItemForBrand() {
        String s;
        boolean treffer = false;
        try {
            String marke = Stdin.readlnString("Bitte geben Sie die Marke ein:");
            
            Iterator <Artikel>iter = artikelListe.iterator();
            while (iter.hasNext()) {
                Artikel a = iter.next();
                if (a.getMarke().equalsIgnoreCase(marke)) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println("Kein Artikel mit der Marke " + marke + " gefunden");
            } else {
                printZentriert("Artikel ID");
                printZentriert("Marke");
                printZentriert("Typ");
                printZentriert("Farbe");
                printZentriert("Geschlecht");
                printZentriert("Preis");
                printLF();
                printLinieLF(6); // Trennlinie für 6 Felder anzeigen

                Iterator <Artikel>iter2 = artikelListe.iterator();
                while(iter2.hasNext()) {
                    Artikel a  =  iter2.next();
                       if(a.getMarke().equalsIgnoreCase(marke)) {
                            s = castInt2String(a.getArtikelID());
                            printZentriert(s);
                            printLinksbuendig(a.getMarke());
                            printLinksbuendig(a.getWarengruppe().getTyp());
                            printLinksbuendig(a.getFarbe());
                            printLinksbuendig(a.getGeschlecht());
                            s = castDouble2String(a.getPreis());
                            printZentriert(s);

                            printLF();
                       }

                }
                printLF();
            }   
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void searchItemForColor() {
        String s;
        boolean treffer = false;
        try {
            String farbe = Stdin.readlnString("Bitte geben Sie die Farbe ein:");

            Iterator <Artikel>iter = artikelListe.iterator();
            while (iter.hasNext()) {
                Artikel a = iter.next();
                if (a.getFarbe().equalsIgnoreCase(farbe)) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println("Kein Artikel mit der Farbe " + farbe + " gefunden");
            } else {
                printZentriert("Artikel ID");
                printZentriert("Marke");
                printZentriert("Typ");
                printZentriert("Farbe");
                printZentriert("Geschlecht");
                printZentriert("Preis");

                printLF();
                printLinieLF(6); // Trennlinie für 6 Felder anzeigen

                Iterator <Artikel>iter2 = artikelListe.iterator();
                while(iter2.hasNext()) {
                    Artikel a  =  iter2.next();
                       if(a.getFarbe().equalsIgnoreCase(farbe)) {
                            s = castInt2String(a.getArtikelID());
                            printZentriert(s);
                            printLinksbuendig(a.getMarke());
                            printLinksbuendig(a.getWarengruppe().getTyp());
                            printLinksbuendig(a.getFarbe());
                            printLinksbuendig(a.getGeschlecht());
                            s = castDouble2String(a.getPreis());
                            printZentriert(s);

                            printLF();
                       }
                }
                printLF();
            }  
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void searchItemForPrice() {
        String s;
        boolean treffer = false;
        try {
            double preis = Stdin.readDouble("Bitte geben Sie den Preis ein:");

            Iterator <Artikel>iter = artikelListe.iterator();
            while (iter.hasNext()) {
                Artikel a = iter.next();
                if (a.getPreis() == preis) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println("Kein Artikel mit dem Preis " + preis + " gefunden");
            } else {
                printZentriert("Artikel ID");
                printZentriert("Marke");
                printZentriert("Typ");
                printZentriert("Farbe");
                printZentriert("Geschlecht");
                printZentriert("Preis");

                printLF();
                printLinieLF(6); // Trennlinie für 6 Felder anzeigen

                Iterator <Artikel>iter2 = artikelListe.iterator();
                while(iter2.hasNext()) {
                    Artikel a  =  iter2.next();
                       if(a.getPreis() == preis) {
                            s = castInt2String(a.getArtikelID());
                            printZentriert(s);
                            printLinksbuendig(a.getMarke());
                            printLinksbuendig(a.getWarengruppe().getTyp());
                            printLinksbuendig(a.getFarbe());
                            printLinksbuendig(a.getGeschlecht());
                            s = castDouble2String(a.getPreis());
                            printZentriert(s);

                            printLF();
                       }
                }
                printLF();
            } 
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void searchItemForGroup() {
        String s;
        boolean treffer = false;
        try {
            String warengruppe = Stdin.readString("Bitte geben Sie die Warengruppe ein:");

            Iterator <Artikel>iter = artikelListe.iterator();
            while (iter.hasNext()) {
                Artikel a = iter.next();
                if (a.getWarengruppe().getTyp().equalsIgnoreCase(warengruppe)) {
                    treffer = true;
                }
            }

            if (!treffer) {
                System.out.println("Kein Artikel aus der Warengruppe:  " + warengruppe + " gefunden");
            } else {
                printZentriert("Artikel ID");
                printZentriert("Marke");
                printZentriert("Typ");
                printZentriert("Farbe");
                printZentriert("Geschlecht");
                printZentriert("Preis");

                printLF();
                printLinieLF(6); // Trennlinie für 6 Felder anzeigen

                Iterator <Artikel>iter2 = artikelListe.iterator();
                while(iter2.hasNext()) {
                    Artikel a  =  iter2.next();
                       if(a.getWarengruppe().getTyp().equalsIgnoreCase(warengruppe)) {
                            s = castInt2String(a.getArtikelID());
                            printZentriert(s);
                            printLinksbuendig(a.getMarke());
                            printLinksbuendig(a.getWarengruppe().getTyp());
                            printLinksbuendig(a.getFarbe());
                            printLinksbuendig(a.getGeschlecht());
                            s = castDouble2String(a.getPreis());
                            printZentriert(s);

                            printLF();
                       }
                }
                printLF();
            }   
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void sellItem() {
        try {
            System.out.println("Welcher Kunde möchte etwas kaufen?");
            int kundenID = Stdin.readlnInt("Bitte geben Sie die Kundennummer ein:");
            if(pruefeKundennummer(kundenID) != kundenID) {
                System.out.println("Kein Kunde mit der Kundennummer " + kundenID + " vorhanden.");
                artikelMenue();
            } else {
                System.out.println("Welcher Artikel soll verkauft werden?");
                int aritkelID = Stdin.readlnInt("Bitte geben Sie die Artikelnummer an:");
                if (pruefeArtikelnummer(aritkelID) != aritkelID) {
                    System.out.println("Kein Artikel mit der Artikelnummer" + aritkelID + " vorhanden.");
                    artikelMenue();
                } else {
                    Artikel a = sucheArtikelzuArtikelnummer(aritkelID);
                    Kunde k = sucheKundezuKundennummer(kundenID);
                    if(a.getAnzahl() == 0) {
                        printLF();
                        System.out.println("Der Artikel ist leider nicht mehr vorhanden.");
                        printLF();
                    } else if(a.getAnzahl() > 0) {
                        int anzahl = a.getAnzahl();
                        anzahl--;
                        a.setAnzahl(anzahl);

                        int index = artikelListe.indexOf(a);
                        artikelListe.set(index, a);

                        Date now = new Date();

                        Kunde k1 = new Kunde(k.getName(), k.getVorname(), k.getAlter());
                        Artikel a1 = new Artikel(a.getWarengruppe(), a.getMarke(), a.getFarbe(), a.getGeschlecht(), a.getPreis(), a.getRabatt(), a.getAnzahl());

                        boolean treffer = false;
                        Iterator <Mitarbeiter>iter = mitarbeiterListe.iterator();
                        while (iter.hasNext()) {
                            Mitarbeiter m = iter.next();
                            if (m.getName().equalsIgnoreCase(rememberLoginName) && m.getVorname().equalsIgnoreCase(rememberLoginPrename)) {
                                treffer = true;
                            }
                        }

                        if (!treffer) {
                            System.out.println("Fehler beim Anlegen der Rechnung.");
                        } else {
                            Iterator <Mitarbeiter>iter2 = mitarbeiterListe.iterator();
                            while (iter2.hasNext()) {
                                Mitarbeiter e = iter2.next();

                                if (e.getName().equalsIgnoreCase(rememberLoginName) && e.getVorname().equalsIgnoreCase(rememberLoginPrename)) {
                                    Mitarbeiter m1 = new Mitarbeiter(e.getName(), e.getVorname(), e.getRolle(), e.getAlter(), e.getUser(), e.getPW(), e.getHomeTEL(), e.getMobilTEL());
                                    Rechnungsposition rp1 = new Rechnungsposition(a1, a.getAnzahl(), 0);
                                    rechnungspositionsListe.add(rp1);
                                    Rechnung r1 = new Rechnung(k1, m1, rp1, now);
                                    rechnungsListe.add(r1);
                                    Hitliste h1 = new Hitliste(m1, a.getPreis(), now);
                                    hitListe.add(h1);
                                    save();

                                    printLF();
                                    System.out.println(k.getVorname() + " " + k.getName() + " hat folgenden Artikel gekauft: " + a.getWarengruppe().getTyp() + " von " + a.getMarke() + " für " + a.getPreis() + "€ mit der ArtikelID " + a.getArtikelID());
                                    printLF();
                                    System.out.println("Rechung mit der ID: " + r1.getRechnungsID() + " wurde erfolgreich angelegt!");
                                    printLF();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }
    }
    
    private void itemBack() {
        try {
            System.out.println("Welcher Kunde möchte einen Artikel zurück geben?");
            int kundenID = Stdin.readlnInt("Bitte geben Sie die Kundennummer ein:");
            if(pruefeKundennummer(kundenID) != kundenID) {
                System.out.println("Kein Kunde mit der Kundennummer " + kundenID + " vorhanden.");
                printLF();
                artikelMenue();
            } else {
                int rechnungsID = Stdin.readlnInt("Wie lautet die Rechnungsnummer?");
                if (pruefeRechnungsnummer(rechnungsID) != rechnungsID) {
                    System.out.println("Keine Rechnung mit der Rechnungsnummer " + rechnungsID + " vorhanden.");
                    System.out.println("Der Artikel kann ohne Rechnung nicht zurück gebracht werden!");
                    printLF();
                    artikelMenue();
                } else {
                    Artikel a = sucheArtikelzuArtikelnummer(rechnungsID);
                    Rechnung r = sucheRechnungzuRechnungsnummer(rechnungsID);
                    Kunde k = sucheKundezuKundennummer(kundenID);
                    
                    int anzahl = a.getAnzahl();
                    anzahl++;
                    a.setAnzahl(anzahl);
                    int index = artikelListe.indexOf(a);
                    artikelListe.set(index, a);

                    Date now = new Date();

                    Kunde k1 = new Kunde(k.getName(), k.getVorname(), k.getAlter());
                    Artikel a1 = new Artikel(a.getWarengruppe(), a.getMarke(), a.getFarbe(), a.getGeschlecht(), a.getPreis(), a.getRabatt(), a.getAnzahl());
                    Rechnung r1 = new Rechnung(r.getKunde(), r.getMitarbeiter(), r.getRechnungsposition(), now);

                    Iterator <Mitarbeiter>iter2 = mitarbeiterListe.iterator();
                    while (iter2.hasNext()) {
                        Mitarbeiter e = iter2.next();

                        if (e.getName().equalsIgnoreCase(r.getMitarbeiter().getName()) && e.getVorname().equalsIgnoreCase(r.getMitarbeiter().getVorname())) {
                            Mitarbeiter m1 = new Mitarbeiter(e.getName(), e.getVorname(), e.getRolle(), e.getAlter(), e.getUser(), e.getPW(), e.getHomeTEL(), e.getMobilTEL());

                            Iterator <Hitliste>iter3 = hitListe.iterator();
                            while (iter3.hasNext()) {
                                Hitliste h = iter3.next();

                                if(h.getMitarbeiter().getName().equalsIgnoreCase(r.getMitarbeiter().getName()) && h.getMitarbeiter().getVorname().equalsIgnoreCase(r.getMitarbeiter().getVorname())) {
                                    iter3.remove();
                                }
                            }

                            System.out.println("");
                            System.out.println("Stornierung");
                            System.out.println("Für " + r.getKunde().getVorname() + " " + r.getKunde().getName());
                            System.out.println("");
                            System.out.println("Rechnungsnummer: " + r.getRechnungsID());
                            System.out.println("-------------------------------------------");
                            System.out.println("Folgender Artikel wurde zurückgegeben");
                            System.out.println(r.getRechnungsposition().getArtikel().getWarengruppe() + " von " + r.getRechnungsposition().getArtikel().getMarke() + "                     EUR " + r.getRechnungsposition().getArtikel().getPreis());
                            System.out.println("");
                            System.out.println("Sie wurden beraten von: " + r.getMitarbeiter().getVorname() + " " + r.getMitarbeiter().getName());
                            
                            save();
                        }
                    }
                }
            } 
        } catch (Exception e) {
            System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        }  
    }
    
    private Kunde sucheKundezuKundennummer(int kundenID)  {
        Iterator <Kunde>iter = kundenListe.iterator(); //Iterator zum Durchsuchen von kundenListe starten
        while(iter.hasNext()) {
            Kunde j  =  iter.next();
            if(j.getKundenID() == kundenID){
                return j;   //gibt ein Objekt Kunde zurück
            }
        }
        return null; //Hier nÃ¶tig, da sonst Fehlermeldung. Wird aber nie erreicht, da PrÃ¼fung ob Kunde mit Kundennummer kundenID existiert bereits durchlaufen ist
    }
    
    private Artikel sucheArtikelzuArtikelnummer(int artikelID)  {
        Iterator <Artikel>iter = artikelListe.iterator(); //Iterator zum Durchsuchen von artikelListe starten
        while(iter.hasNext()) {
            Artikel i  =  iter.next();
            if(i.getArtikelID() == artikelID){
                return i;   //gibt ein Objekt Artikel zurück
            }
        }
        return null; 
    }
    
    private Rechnung sucheRechnungzuRechnungsnummer(int rechnungsID)  {
        Iterator <Rechnung>iter = rechnungsListe.iterator(); //Iterator zum Durchsuchen von artikelListe starten
        while(iter.hasNext()) {
            Rechnung r  =  iter.next();
            if(r.getRechnungsID() == rechnungsID){
                return r;   //gibt ein Objekt Rechnung zurück
            }
        }
        return null; 
    }
    
    private int pruefeKundennummer(int kundenID) {
        Iterator <Kunde>iter = kundenListe.iterator(); //Iterator zum Durchsuchen von kundenListe starten
        while(iter.hasNext()) {
            Kunde k  =  iter.next();
            if(k.getKundenID() == kundenID) {
                return k.getKundenID();
            }
        }
        return 0;
    }
    
    private int pruefeArtikelnummer(int artikelID) {
        Iterator <Artikel>iter = artikelListe.iterator(); //Iterator zum Durchsuchen von artikelListe starten
        while(iter.hasNext()) {
            Artikel a  =  iter.next();
            if(a.getArtikelID() == artikelID) {
                return a.getArtikelID();
            }
        }
        return 0;
    }
    
    private int pruefeRechnungsnummer(int rechnungsID) {
        Iterator <Rechnung>iter = rechnungsListe.iterator(); //Iterator zum Durchsuchen von rechnungsListe starten
        while(iter.hasNext()) {
            Rechnung r  =  iter.next();
            if(r.getRechnungsID() == rechnungsID) {
                return r.getRechnungsID();
            }
        }
        return 0;
    }
    
    private void showAllGroups() {
        for (Warengruppe warengruppe : Warengruppe.values()) {
            System.out.println(warengruppe.getTyp());
        }
        
    }
    
/****************************************Rechnungsmenue - Funktionen********************************************/
    public void showInvoicesForToday() {
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Iterator <Rechnung>iter = rechnungsListe.iterator();
        while (iter.hasNext()) {
            Rechnung r = iter.next();
            Date past = r.getDatum();
            if (sdf.format(past).equals(sdf.format(now))) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("Am " + sdf.format(now) + " wurden noch keine Rechnungen angelegt.");
        } else {       
            Iterator <Rechnung>iter2 = rechnungsListe.iterator();
            while (iter2.hasNext()) {
                Rechnung i = iter2.next();
                Date past = i.getDatum();

                if (sdf.format(past).equals(sdf.format(now))) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Rechnungsbeleg");
                    System.out.println("Für " + i.getKunde().getVorname() + " " + i.getKunde().getName());
                    System.out.println("Rechnungsnummer: " + i.getRechnungsID());
                    System.out.println(i.getRechnungsposition().getArtikel().getWarengruppe().getTyp() + " von " + i.getRechnungsposition().getArtikel().getMarke() + "                     EUR " + i.getRechnungsposition().getArtikel().getPreis());
                    System.out.println("");
                    System.out.println("Sie wurden beraten von: " + i.getMitarbeiter().getVorname() + " " + i.getMitarbeiter().getName());
                    System.out.println("-------------------------------------------");
                    System.out.println("");
                }
            }
        }
        printLF(); 
    }
    
    public void showInvoicesForWeek() {
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("w.yyyy");            
        Iterator <Rechnung>iter = rechnungsListe.iterator();
        while (iter.hasNext()) {
            Rechnung r = iter.next();
            Date past = r.getDatum();

            if (sdf.format(past).equals(sdf.format(now))) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("In diesem Monat wurden noch keine Rechnungen angelegt.");
        } else {       
            Iterator <Rechnung>iter2 = rechnungsListe.iterator();
            while (iter2.hasNext()) {
                Rechnung i = iter2.next();
                Date past = i.getDatum();

                if (sdf.format(past).equals(sdf.format(now))) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Rechnungsbeleg");
                    System.out.println("Für " + i.getKunde().getVorname() + " " + i.getKunde().getName());
                    System.out.println("Rechnungsnummer: " + i.getRechnungsID());
                    System.out.println(i.getRechnungsposition().getArtikel().getWarengruppe().getTyp() + " von " + i.getRechnungsposition().getArtikel().getMarke() + "                     EUR " + i.getRechnungsposition().getArtikel().getPreis());
                    System.out.println("");
                    System.out.println("Sie wurden beraten von: " + i.getMitarbeiter().getVorname() + " " + i.getMitarbeiter().getName());
                    System.out.println("-------------------------------------------");
                    System.out.println("");
                }
            }
        }
        printLF();   
    }
    
    public void showInvoicesForMonth() {
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM.yyyy");            
        Iterator <Rechnung>iter = rechnungsListe.iterator();
        while (iter.hasNext()) {
            Rechnung r = iter.next();
            Date past = r.getDatum();
            if (sdf.format(past).equals(sdf.format(now))) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("In diesem Monat wurden noch keine Rechnungen angelegt.");
        } else {       
            Iterator <Rechnung>iter2 = rechnungsListe.iterator();
            while (iter2.hasNext()) {
                Rechnung i = iter2.next();
                Date past = i.getDatum();
                if (sdf.format(past).equals(sdf.format(now))) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Rechnungsbeleg");
                    System.out.println("Für " + i.getKunde().getVorname() + " " + i.getKunde().getName());
                    System.out.println("");
                    System.out.println("Rechnungsnummer: " + i.getRechnungsID());
                    System.out.println(i.getRechnungsposition().getArtikel().getWarengruppe().getTyp() + " von " + i.getRechnungsposition().getArtikel().getMarke() + "                     EUR " + i.getRechnungsposition().getArtikel().getPreis());
                    System.out.println("");
                    System.out.println("Sie wurden beraten von: " + i.getMitarbeiter().getVorname() + " " + i.getMitarbeiter().getName());
                    System.out.println("-------------------------------------------");
                    System.out.println("");
                }
            }
        }
        printLF(); 
    }
    
    public void showInvoicesForYear() {
        boolean treffer = false;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Iterator <Rechnung>iter = rechnungsListe.iterator();
        while (iter.hasNext()) {
            Rechnung r = iter.next();
            Date past = r.getDatum();
            if (sdf.format(past).equals(sdf.format(now))) {
                treffer = true;
            }
        }
        
        if (!treffer) {
            System.out.println("In diesem Jahr wurden noch keine Rechnungen angelegt!");
        } else {       
            Iterator <Rechnung>iter2 = rechnungsListe.iterator();
            while (iter2.hasNext()) {
                Rechnung i = iter2.next();
                Date past = i.getDatum();
                if (sdf.format(past).equals(sdf.format(now))) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Rechnungsbeleg");
                    System.out.println("Für " + i.getKunde().getVorname() + " " + i.getKunde().getName());
                    System.out.println("");
                    System.out.println("Rechnungsnummer: " + i.getRechnungsID());
                    System.out.println(i.getRechnungsposition().getArtikel().getWarengruppe().getTyp() + " von " + i.getRechnungsposition().getArtikel().getMarke() + "                     EUR " + i.getRechnungsposition().getArtikel().getPreis());
                    System.out.println("");
                    System.out.println("Sie wurden beraten von: " + i.getMitarbeiter().getVorname() + " " + i.getMitarbeiter().getName());
                    System.out.println("-------------------------------------------");
                    System.out.println("");
                }
            }
        }
        printLF(); 
    }
    
    
/***************************************************************************************************************/
/**********************************Funktionen zur Darstellung des Menüs*****************************************/
/***************************************************************************************************************/
    private String castInt2String(int meinInt) {
        return Integer.toString(meinInt);
        // die obige Zeile ist von der Funktion identisch zu
        // Integer i = new Integer(meinInt);
        // return i.toString();
    }

    private String castDouble2String(double meinDouble) {
        // hier nutzen wir die Format-Anweisung der Klasse String um die Nachkommastellen zu bestimmen etc.
        return String.format("%,8.2f", meinDouble);
    }

    private void printLF() {
        System.out.println();
    }

    private void printZentriert(String s) {
        System.out.print(baueZentriertenString(s, FELDLAENGE));
    }

    private void printLinksbuendig(String s) {
        System.out.print(baueLinksbuendigenString(s, FELDLAENGE));
    }

    private void printRechtsbuendig(String s) {
        System.out.print(baueRechtsbuendigenString(s, FELDLAENGE));
    }

    private void printLinieLF(int anzahlFelder) {
        /* Besonderheit: hier Nutzung des StringBuilders statt direkt mit String zu arbeiten.
         * Ist sparsamer im Umgang mit Speicher.
         */
        StringBuilder s = new StringBuilder();
        int laenge = anzahlFelder*(FELDLAENGE+3);
        for (int i=1;i<=laenge;i++) {
            s=s.append("-");
        }
        System.out.println(s);
    }

    private String baueZentriertenString(String s, int laenge) {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge) {
            s.substring(0, laenge);
        } else {
            int differenzLinks = (laenge - s.length())/2;
            for (int i=1;i<=differenzLinks;i++) s=" "+s+" ";
            if (s.length()<laenge) s=s+" ";
        }
        return s+" | ";
    }

    private String baueRechtsbuendigenString(String s, int laenge) {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge) {
            s.substring(0, laenge);
        } else {
            int differenzLinks = (laenge - s.length());
            for (int i=1;i<=differenzLinks;i++) s=" "+s;
        }
        return s+" | ";
    }

    private String baueLinksbuendigenString(String s, int laenge) {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge) {
            s.substring(0, laenge);
        } else {
            int differenz = (laenge - s.length());
            for (int i=1;i<=differenz;i++) s=s+" ";
        }
        return s+" | ";
    }

    private void printEingabeFehler() {
        System.out.print("Ihre Eingabe wurde nicht erkannt.\n");
    }

    private void printAuswahlTreffen() {
        System.out.print("Bitte treffen Sie eine Auswahl ...\n");
    }

    private void printProgrammInfo() {
        System.out.println("************************************************************");
        System.out.println("* POS-System by      Thomas Ehrhardt, Eric Grünemeier      *");
        System.out.println("*      Kati Kiefer, Natalie Rauber, Nomin Naranbaatar      *");
        System.out.println("************************************************************");
    }

// Hier wird das Programm gestartet
    public static void main(String[] args) throws ParseException {
        Verwaltung v = new Verwaltung();
        
        v.erzeugeStartDaten();
        v.loginMenue();
    }
}