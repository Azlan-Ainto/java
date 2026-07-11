package de.lagerverwaltung;

/**
 *  BestandsListe - dritte Ausbaustufe der Mini-Lagerverwaltung
 *  verwaltet mehrere Lagerartikel in parallelen Arrays
 *  und wertet den Gesamtgestand automatisch per Schleife aus.
 * Tag 3, Woche 1 - Arrays & und Schleifen
 *
 */

public class BestandsListe {

    public static  void  main(String... args)
    {

        //  ---------------------------------------------------
        //  ARTIKELDATEN - parallele Arrays
        //  Index i gehört in jedem Array zum selben Artikel.
        // -----------------------------------------------------

        String[] artikelNamen = {
                "Bürostuhl Comfort 3000",
                "Schreibtisch Profi",
                "Drucerpatrone Schwarz XL",
                "Notizbuch A4 kariert",
                "Heftklammern 1000er Pack"

        };

        String[] artikelNummer = {

                "ART-0042",
                "ART-0017",
                "ART-0099",
                "ART-0213",
                "ART-0008"
        };

        int[] bestaende = {15, 3,0, 42, 8};
        int[] mindestbestaende = {5,10,20,10,25};
        double[] einkaufsPreise = {89.90, 249.00, 12.50, 3.20, 1.80};
        boolean[] lieferbar = {true, true, true, false, true};

        // -----------------------------------------------------------
        // Gesamtauswertung per Schleife
        // -----------------------------------------------------------

        int anzahlNachbestellung = 0;
        double geamterLagerwert = 0.0;

        //...Linien, Ecken.....
        char TL = '\u2254';
        char TR = '\u2557';
        char BL = '\u255A';
        char BR = '\u2550';
        char H = '\u2550';
        char V = '\u2551';

        System.out.println(""+TL+ String.valueOf(H).repeat(50)+ TR);
        System.out.printf("%c%-45s%c%n",V,"\t\tLAGERBESTAND – TAGESAUSWERTUNG",V);
        System.out.println(""+BL+String.valueOf(H).repeat(50)+ BR);
        System.out.println();

        for(int i=0; i<artikelNamen.length; i++){

            // Lagerwert dieses Artikels
            double lagerwert = bestaende[i]*einkaufsPreise[i];
            geamterLagerwert +=lagerwert;
            // Fehlmenge
            int fehlmenge = mindestbestaende[i] - bestaende[i];

            if(fehlmenge <0){
                fehlmenge = 0;
            }

            String status;
            if(bestaende[i] == 0){
                status = "kritisch";
            } else  if (bestaende[i] < mindestbestaende[i]){
                status = "Unterbestand";

            }else {
                status = "OK";
            }
            // Nachbestellungsempfehlung
            boolean nachbestellung = bestaende[i] < mindestbestaende[i] && lieferbar[i];
            if(nachbestellung){
                anzahlNachbestellung++;
            }
            // Ausgabe dieses Artiekls
            System.out.println("Artikel" + (i+1) + ":" + artikelNamen[i] + "(" + artikelNummer[i] + ")");
            System.out.println("\tBestand: "+ bestaende[i] +"/"+ mindestbestaende[i]+ "Stk (Mindest)");
            System.out.println("\tStatus: "+lagerwert+ " €");
            System.out.println("\tStatus: "+status);
            System.out.println(("\tFehlmenge: "+ fehlmenge+ "Stk"));
            System.out.println(("\tBestellen: "+(nachbestellung ? "JA": "nein")));
            System.out.println();
        }

        System.out.println("===================================================");
        System.out.println("Zusammenfassung");
        System.out.println("Artikel gesamt "+ artikelNamen.length);
        System.out.println("Nachbestelung nötig: " + anzahlNachbestellung);
        System.out.println("Gesamter Lagerwert: " + geamterLagerwert + " €");

        // ---------------------------------------------------------------------
        // Teuerste Artikel finden

        int indexTeuerste = 0;
        double maxPreis = einkaufsPreise[0];
        int j = artikelNamen.length-1;

        while (j >= 0)
        {
            if(einkaufsPreise[j] > maxPreis)
            {
                maxPreis = einkaufsPreise[j];
                indexTeuerste = j;
            }
            j--;
        }
        System.out.println();
        System.out.println("Teuerster Artiek: " + artikelNamen[indexTeuerste] + "(" + einkaufsPreise[indexTeuerste] + "€");
        System.out.println();


    }
}
