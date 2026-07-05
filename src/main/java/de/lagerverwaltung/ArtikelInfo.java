package de.lagerverwaltung;

public class ArtikelInfo
{
    public static void  main(String[] args)
    {
        //  ----- Artikeldaten -----
        // .......Artikel 1 ........
        String artikelName  ="Bürostuhl Comfort 3000";
        String artikelNummer = "ART-0042";
        int aktuellerBestand = 15;
        int mindestbestand = 5;
        double einkausPreis = 89.90;
        boolean istLieferbar = true;

        // ...... Zweiter Artikel 2 .........

        String artikelName2 = "Schreibtisch Profi";
        String artikelNummer2 = "ART-0017";
        int aktuellerBestand2 = 3;
        int mindestbestand2 = 5;
        double einkaufsPreis2 = 249.00;
        boolean istLieferbar2 = false;

        //  .... dritter Artiekl .............
        String artikelName3 = "Schreibtisch Profi";
        String artikelNummer3 = "ART-0019";
        int akutellerBestand3 = 2;
        int mindestbestand3 = 5;
        double einkaufsPreis3 = 350.35;
        boolean istLieferbar3 = false;


        // ....... Ausgabe Artikel 1...........
        System.out.println("\n======= Lagerartikel 1 ======");
        System.out.println("Name:           " + artikelName);
        System.out.println("Artikelnr.:     " + artikelNummer);
        System.out.println("Bestand:        " + aktuellerBestand);
        System.out.println("Mindestbest.:   "+ mindestbestand);
        System.out.println("Einkaufspreis:  " + einkausPreis);
        System.out.println("Lieferbar:      "+ istLieferbar);


        // ...... Ausgabe Artikel 2 .............
        System.out.println();
        System.out.println("======= Lagerartikel 2 ======");
        System.out.println("Name:           " + artikelName2);
        System.out.println("Artikelnr.:     " + artikelNummer2);
        System.out.println("Bestand:        " + aktuellerBestand2);
        System.out.println("Mindestbest.:   "+ mindestbestand2);
        System.out.println("Einkaufspreis:  " + einkaufsPreis2);
        System.out.println("Lieferbar:      "+ istLieferbar2);
        System.out.println();

        // ..... Ausgabe Artikel 3 ................
        System.out.println("======= Lagerartikel 3======");
        System.out.println("Name:           " + artikelName3);
        System.out.println("Artikelnr.:     " + artikelNummer3);
        System.out.println("Aktuellerbest.: " + akutellerBestand3);
        System.out.println("Mindestbest.:   "+ mindestbestand3);
        System.out.println("Einkaufspreis:  " + einkaufsPreis3);
        System.out.println("Lieferbar:      "+ istLieferbar3);


    }
}
