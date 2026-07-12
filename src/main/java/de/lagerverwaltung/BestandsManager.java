package de.lagerverwaltung;
import static  java.lang.System.out;

/**
 * BestandsManager
 * vierte Ausbaustufe der Mini-Lagerverwaltung
 * Refactoring von BestandsListe: alle Berechnungen & Ausgaben
 * wurden in eingenständige, wiederverwendbare Methoden ausgelagert.
 * Prinzip: DRY - Don't Repeat Yourself
 * Eine Methode, eine klar benennbare Aufgabe.
 * Tag 4 Woche 1 - Methoden & Clean Code
 *
 */
public class BestandsManager
{
    public static  void main(String[] args)
    {
        // ---------------------------------------------
        // Artikeldaten - Parallele Arrays
        // ---------------------------------------------
        String[] artikelNamen = {
                "Bürostuhl Comfort 300",
                "Schreibtisch Profi",
                "Druckerpatrone Schwar XL",
                "Notizbuch A4 kariert",
                "Heftklammern 1000er Pack"
        };
        String[] artikelNummern = {
                "ART-0042",
                "ART-0017",
                "ART-0099",
                 "ART-0213",
                "ART-0008"
        };

        int[] bestaende         = {15, 3, 0, 42, 8};
        int[] mindestbestaende  = {5,10,20,10,25};
        double[] einkaufsPreise = {89.90, 249.00, 12.50, 3.20, 1.80};
        boolean[] lieferbar = {true, true, true, false, true};

        // ---------------------------------------------------------------
        // Auswertung
        // ---------------------------------------------------------------

        int anzahlNachbestellung = 0;
        double gesamterLagerwert = 0.0;

        kopfzeileAusgeben();

        for(int i =0; i<artikelNamen.length; i++)
        {
            double lagerwert = lagerwertBerechnen(bestaende[i], einkaufsPreise[i]);

            int fehlmenge = fehlmengeBerechnen(bestaende[i], mindestbestaende[i]);

            String status = bestandsStatusBerechnen(bestaende[i], mindestbestaende[i]);

            boolean bestellen = nachbestellungEmpfohlen(bestaende[i], mindestbestaende[i], lieferbar[i]);

            gesamterLagerwert += lagerwert;

            if(bestellen){
                anzahlNachbestellung++;
            }

            artikelAusgeben(
                    i+1,
                    artikelNamen[i],
                    artikelNummern[i],
                    bestaende[i],
                    mindestbestaende[i],
                    lagerwert,
                    status,
                    fehlmenge,
                    bestellen
            );
            zusammenfassungAusgeben(
                    artikelNamen.length,
                    anzahlNachbestellung,
                    gesamterLagerwert
            );
        }

    }

    /**
     * Berechnet der Lagerwert eines Artikels.
     * Lagerwert = aktueller Bestand x Einkaufspreis
     * @param bestand   aktueller Lagerbstand in Stück (Stk)
     * @param einkaufsPreis Einkaufspreis pro Stück in Euro
     * @return Lagerwert in Euro
     */

    private  static double lagerwertBerechnen(
            int bestand,
            double einkaufsPreis
    ){
        return  bestand * einkaufsPreis;
    }

    /**
     * Berechnet die Fehlmenge bis zum Mindestbesand
     * Gibt 0 zurück, wenn der Bestand bereits ausreichend ist.
     *
     * @param bestand aktueller Lagerbestand in Stück
     * @param mindestbestand Mindestbesand laut Lagervorgabe
     * @return fehlmenge in Stück, mindestens 0
     */

    private static int fehlmengeBerechnen(
            int bestand,
            int mindestbestand
    ){
        int fehlmenge = mindestbestand - bestand;
        if(fehlmenge < 0){
            fehlmenge = 0;
        }
        return  fehlmenge;
    }

    /**
     * Bestimmt den Bestandsstatus eines Artikels.
     * Dreistufen: Kritisch(Bestand 0) -> Unterbestand -> OK
     *
     * @param bestand   aktueller Lagerbestand in Stück
     * @param mindestbestand    Mindestbestand laut Lagervorgabe
     * @return Status-Text für die Ausgabe
     */

    private  static String bestandsStatusBerechnen(
            int bestand,
            int mindestbestand
    ){
        if(bestand == 0) {
            return "Kritisch";
        } else if (bestand < mindestbestand) {
            return "Unterbestand";
        }else {
            return "OK";
        }
    }

    /**
     * Prüft, ob für einen Artikel eine Nachbestellung empfohlen wird
     * Bedingung: Unter Mindestbestand UND Artikel ist lieferbar
     *
     * @param bestand aktueller Lagerbestand in Stück
     * @param mindestbestand Mindestbestand laut Lagervorgabe
     * @param istLieferbar  ob der Artikel beim Lieferanten verfügbar ist
     * @return true wenn Nachbestellung empfohlen wird
     */

    private static boolean nachbestellungEmpfohlen(
            int bestand,
            int mindestbestand,
            boolean istLieferbar
    ){
        return  bestand < mindestbestand && istLieferbar;
    }

    private static void kopfzeileAusgeben(){

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║          LAGERBESTAND – TAGESAUSWERTUNG          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();

    }

    /**
     * Gibt alle Informationen eines einzelnen Lagerartikels aus.
     *
     * @param position  Position in der Liste
     * @param name Artikelbezeichnung
     * @param nummer Artikelnummer
     * @param bestand aktueller Lagerbestand
     * @param mindestbestand Mindestbestand
     * @param lagerwert berechnter Lagerwert in Euro
     * @param status Bestandsstatus(Kritisch, Unterbestad, OK)
     * @param fehlmenge Fehlmenge bis Mindestbestand
     * @param bestellen Nachbestellunsempfehlung
     */

    private  static void artikelAusgeben(
            int position,
            String name,
            String nummer,
            int bestand,
            int mindestbestand,
            double lagerwert,
            String status,
            int fehlmenge,
            boolean bestellen
    ){
        out.println("Artikel " + position + ": " + name + "(" + nummer + ")");
        out.println("Status: " + status);
        out.print("Fehlmenge: " + fehlmenge + " Stück");
        out.println("Bestellen: " + (bestellen ? "JA": "NEIN"));
        out.println();

    }

    /**
     * Gibt die zusammenfassung der Gesamtauswertun aus.
     * @param artikelGesamt Gesamtzahl der Artikel
     * @param anzahlNachbestellung Anzahl der Artikel mit Nachbestellbedarf
     * @param gesamterLagerwert Gesamtwert des Lagers in Euro
     */

    private static void zusammenfassungAusgeben(
            int artikelGesamt,
            int anzahlNachbestellung,
            double gesamterLagerwert
    ){
        out.println("==============================================================");
        out.println("Zusammenfassung");
        out.println("Artikel gesamt: "+ artikelGesamt);
        out.println("Nachbestellung nötig: " + anzahlNachbestellung);
        out.println("Gesamter Lagerwert: " + gesamterLagerwert);
        out.println("================================================================");
    }

}
