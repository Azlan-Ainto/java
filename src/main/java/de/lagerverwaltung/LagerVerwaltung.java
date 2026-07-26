package de.lagerverwaltung;

public class LagerVerwaltung
{
    public static  void main(String[] args)
    {
        Lagerartikel[] lager = {
                new Lagerartikel("Bürostuhl Comfort 300", "ART-0042",15,5,89.90, true),
                new Lagerartikel("Schreibtisch Profi", "ART-0017", 3,10,249.00, true),
                new Lagerartikel("Drucerpatrone Schwarz XL", "ART-0099",0,20,12.50, true),
                new Lagerartikel("Notizbuch A4 kariert", "ART-0213", 42,10,3.20, false),
                new Lagerartikel("Heftklammern 1000er Pack", "ART-0008", 8,25,1.80, true)
        };

        int anzahlNachbestellung = 0;
        double gesamterLagerwert = 0.0;
        System.out.println("===============================================");
        System.out.println("LAGERBESTAND - TAGESAUSWERTUNG");
        System.out.println("================================================");
        System.out.println();

        for (int i=0; i<lager.length; i++){
            Lagerartikel artikel = lager[i];
            double lagerwert = artikel.lagerwertBerechnen();
            int fehlmenge = artikel.fehlmengeBerechnen();
            String status = artikel.bestandsStatusBerechnen();
            boolean bestellen = artikel.istNachbestellung();
            gesamterLagerwert += lagerwert;
            if(bestellen){
                anzahlNachbestellung ++;
            }
            /*
                Ausgabe
             */
            System.out.println("Artiel " + (i+1)+ ": " + artikel.getName() + "(" + artikel.getArtikelNummer() + ")");
            System.out.println("Bestand: " + artikel.getBestand() + " / " + artikel.getMindestbestand() + " Stück(Mindest)");
            System.out.println("Lagerwert: " + lagerwert + " EUR");
            System.out.println("Status: " + status);
            System.out.println("Fehlmenge: "+ fehlmenge + "Stk");
            System.out.println("Bestellen: " + (bestellen ? "JA": "nein"));
            System.out.println();

            /*
                Zusammenfassung
             */

        }
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("ZUSAMMENFASSUNG");
        System.out.println("Artikel gesamt:        " + lager.length);
        System.out.println("Nachbestellung nötig:  " + anzahlNachbestellung);
        System.out.println("Gesamter Lagerwert:    " + gesamterLagerwert + " €");
        System.out.println("══════════════════════════════════════════════════");

        /*
            Wareneingang simulieren - Setter- Methoden verwenden
            Fachlich: 20 Stk Druckerpatrone geliefert
         */

        System.out.println();
        System.out.println("--- Wareneingang Druckerpatrone + 20 Stk ---");
        lager[2].setBestand(lager[2].getBestand() + 20);
        System.out.println(lager[2]);


    }

}
