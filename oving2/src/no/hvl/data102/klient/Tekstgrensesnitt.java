package no.hvl.data102.klient;
import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.*;

import java.util.*;


public class Tekstgrensesnitt {
	
	public Film lesFilm() {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Fyll inn informasjon om film");
		
		System.out.println("Filmnummer: ");
		int filmNr = myScanner.nextInt();
		
		// Nødvendig pga nextInt() ikke fullfører new line.
		myScanner.nextLine();

		
		System.out.println("Produsent: ");
		String produsent = myScanner.nextLine();
		
		
		System.out.println("Tittel: ");
		String tittel = myScanner.nextLine();
		
		System.out.println("Dato: ");
		int pub_dato = myScanner.nextInt();
		
		System.out.println("Sjanger:\n1. Action\n2. Drama\n3. Historie\n4. Scifi");
		int sjangervalg = myScanner.nextInt();
		
		Sjanger sjanger = null;
		
		switch(sjangervalg) {
			case 1:
				sjanger = Sjanger.ACTION;
				break;
			case 2:
				sjanger = Sjanger.DRAMA;
				break;
			case 3:
				sjanger = Sjanger.HISTORY;
				break;
			case 4:
				sjanger = Sjanger.SCIFI;
				break;
			
		}
		
		// Nødvendig pga nextInt() ikke fullfører new line.
		myScanner.nextLine();
				
		System.out.println("Selskap: ");
		String selskap = myScanner.nextLine();
		
		Film film = new Film(filmNr, produsent, tittel, pub_dato, sjanger, selskap); 
		
		return film;
	}
	
	public void visFilm(Film film) {
		System.out.println("Filmnummer: " + film.getFilmNr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("Dato: " + film.getPubDato());
		System.out.println("Sjanger: " + film.getSjanger());
		System.out.println("Selskap: " + film.getSelskap());
	}
	
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] result = filma.sokTittel(delstreng);
		for (Film i : result) {
			System.out.println(i);
		}	
	}
	public void skrivUtFilmProdusent(FilmarkivADT filma, String produsent) {				
		// Fikk problemer med denne så la bare til en metode i Interfacet for å hente film basert på produsent. Ser ingen grunn til at den ikke kan være der.
				
		Film[] result = filma.avProdusent(produsent);
		for (Film i : result) {
			if (i != null) {
				System.out.println("Film av: " + produsent);
				System.out.println(i.toString());
				System.out.println();
			}
		}
	}
	
	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Totalt antall filmer: " + filma.antall());
		for (Sjanger i : Sjanger.values()) {
			System.out.println("Totalt antall filmer i kategorien, " + i.toString() + ": " + filma.antall(i));
		}
	}
}
