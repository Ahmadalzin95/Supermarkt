package serie4;

import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		Supermarkt supermarkt = new Supermarkt();

		int kundenId = 0;
		Kunde kim = new Kunde(kundenId++,21,"Kim");
		Kunde timmy = new Kunde(kundenId++,14,"Timmy");
		Kunde hansPeter = new Kunde(kundenId++,21,"Hans-Peter");

		supermarkt.addKunde(kim);
		supermarkt.addKunde(timmy);
		supermarkt.addKunde(hansPeter);

		System.out.println("Erwachsene Kunden:");
		Set<Kunde> erwachsene = supermarkt.filtereErwachsene();
		System.out.println(erwachsene);

		int artikelId = 0;
		Video drama = new Video(artikelId++,0.59,"Drama",false);
		Video horrorfilm = new Video(artikelId++,1.39,"Horrorfilm",true);
		Artikel sandwich = new Artikel(artikelId++,3.49,"Sandwich");
		Artikel burger = new Artikel(artikelId++,3.49,"Burger");


		supermarkt.aktualisiereArtikel(drama, 7);
		supermarkt.aktualisiereArtikel(horrorfilm, 13);
		supermarkt.aktualisiereArtikel(sandwich, 5);
		supermarkt.aktualisiereArtikel(burger, 1);

		kim.setEinkaufsliste(new TreeMap<Artikel, Integer>() {{ put(drama, 6); }});
		timmy.setEinkaufsliste(new TreeMap<Artikel, Integer>() {{ put(horrorfilm, 1); }});
		hansPeter.setEinkaufsliste(new TreeMap<Artikel, Integer>() {{ put(sandwich, 6);  }});

		System.out.println("\nEinkaufsvalidierung, erwartet wird true, false (alterscheck), false (unzureichendes sortiment):");
		System.out.println(supermarkt.istValiderEinkauf(kim.getId()));
		System.out.println(supermarkt.istValiderEinkauf(timmy.getId()));
		System.out.println(supermarkt.istValiderEinkauf(hansPeter.getId()));

		System.out.println("\nArtikel mit Kosten von 0.59 bis 1.39, erwarte Drama und Horrofilm:");
		System.out.println(supermarkt.filterePreis(.59, 1.39));
		System.out.println("\nArtikel mit Kosten von 0.00 bis 0.58, erwarte leere Liste:");
		System.out.println(supermarkt.filterePreis(.00, .58));

		supermarkt.aktualisiereArtikel(horrorfilm, 0);
		System.out.println("\nArtikel mit Kosten von 0.59 bis 1.39 nachdem Horrorfilm entfernt wurde:");
		System.out.println(supermarkt.filterePreis(.59, 1.39));

		System.out.println("\nSortiertes Sortiment:");
		System.out.println(supermarkt.sortiereArtikel(true));
		System.out.println(supermarkt.sortiereArtikel(false));



	}

}
