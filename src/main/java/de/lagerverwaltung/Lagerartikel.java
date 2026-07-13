package de.lagerverwaltung;

public class Lagerartikel {

    private String
            name,
            artikelNummer;
    private int
            bestand,
            mindestbestand;
    private double einkaufsPreis;
    private  boolean istLieferbar;

    /**
     * Erzeugt einen neuen Lagerartike mit allen Pflichtangaben
     *
     * @param name  Artikelbezeichnung
     * @param artikelNummer eindeutige Artikelnummer (z.B ART-0042)
     * @param bestand   aktueller Lagerbestand in Stück
     * @param mindestbestand Mindestbestand laut Lagervorgabe
     * @param einkaufsPreis    Einkaufspreis pro Stück in Euro
     * @param istLieferbar  ob der Artikel beim Lieferanten verfügbar ist
     *
     */
    public  Lagerartikel(String name,
                         String artikelNummer,
                         int bestand,
                         int mindestbestand,
                         double einkaufsPreis,
                         boolean istLieferbar
    ){
        this.name = name;
        this.artikelNummer = artikelNummer;
        this.bestand = bestand;
        this.mindestbestand = mindestbestand;
        this.einkaufsPreis = einkaufsPreis;
        this.istLieferbar = istLieferbar;

    }

    /**
     * Berechnet den Lagerwert dieses Artikels.
     *  Lagerwert = aktueller Bestand * Einkaufspreis
     * @return lagerwert in Euro
     */
    public  double lagerwertBerechnen()
    {
        return bestand * einkaufsPreis;
    }

    /**
     * Berechnet die Fehlmenge bis zum Mindestbestand
     * Gibt 0 zurück, wenn der Bestand ausreichend ist.
     * @return Fehlmenge in Stück, mindesten 0
     */
    public int fehlmengeBerechnen()
    {
        int fehlmenge = mindestbestand - bestand;
        if(fehlmenge <0){
            fehlmenge = 0;
        }
        return fehlmenge;

    }
    /**
     * Bestimmt den Bestandsstatus dieses Artikels.
     * Kritisch(Bestand 0) -> Unterbestand -> OK
     * @return Status-Text für die Ausgabe
     */

    public String bestandsStatusBerechnen()
    {
        if(bestand == 0){
            return "kritisch";
        } else if (bestand < mindestbestand){
            return "Unterbestand";
        }else{
            return "OK";
        }
    }

    /**
     * Prüft, ob eine Nachbestellung empfohlen wird.
     * Bedingung: unter Mindestbestand UND Artikel lieferbar
     *
     * @return true wenn Nachbestellung empfohlen wird
     */
    public boolean istNachbestellung(){
        return bestand < mindestbestand && istLieferbar;
    }

    public  String getName()
    {
        return name;
    }

    public  String getArtikelNummer()
    {
        return artikelNummer;
    }

    public int getBestand(){
        return bestand;
    }

    public int getMindestbestand()
    {
        return  mindestbestand;
    }
    public double getEinkaufsPreis()
    {
        return einkaufsPreis;
    }
    public boolean istLieferbar(){
        return istLieferbar;
    }

    /**
     * setzt den aktuellen Bestand
     * Negativer Bestand wird abgeleh - Bestand bleibt unverändert.
     *
     * @param neuerBestand neuer Lagerbestand in Stück
     */

    public void setBestand(int neuerBestand){
        if(neuerBestand >=0){
            this.bestand = neuerBestand;
        }
        // Ungültige Werte werden ignoriert.
    }

    /**
     * Setzt den Lieferstatus des Artikels.
     *
     * @param istLieferbar true wenn der Artikel lieferbar ist
     */
    public  void setIstLieferbar(boolean istLieferbar){
        this.istLieferbar = istLieferbar;
    }

    @Override
    public String toString()
    {
        return  "[" + artikelNummer + "]" +
                                    name  +
                "| Bestand: " + bestand   +
                "| Status: " + bestandsStatusBerechnen();
    }



    public  static  void  main(String[] args)
    {
        Lagerartikel stuhl = new Lagerartikel(
                "Bürostuhl Comfort 3000",
                "ART-0042",
                3,
                10,
                89.90,
                true
        );
        System.out.println(stuhl);

        System.out.println("Lagerwert: " + stuhl.lagerwertBerechnen() + " €");
        System.out.println("Fehlmenge: " + stuhl.fehlmengeBerechnen() + " Stk");
        System.out.println("Status: " + stuhl.bestandsStatusBerechnen());
        System.out.println("Nachbestellen: "+ stuhl.istNachbestellung());

        stuhl.setBestand(15);
        System.out.println("\nNach Wareneingang(15 Stück):");
        System.out.println(stuhl);

        stuhl.setBestand(-5);
        System.out.println("\nNach ungültigem Sett (-5): ");
        System.out.println("Bestand: " + stuhl.getBestand());

    }








}
