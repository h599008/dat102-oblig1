package no.hvl.data102.klient;
import no.hvl.data102.adt.*;
import no.hvl.data102.*;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
		this.tekstgr = new Tekstgrensesnitt();
		
		// Lager en ny film basert på input fra brukeren.
		Film filmFraInput = tekstgr.lesFilm();
		
		// Legger til filmen som nettopp ble opprettet inn i filmarkiv.
		this.filmarkiv.leggTilFilm(filmFraInput);	
		
		// Skriver ut filmen som nettopp ble satt inn av bruker.
		System.out.println("Film lagt inn av bruker:");
		tekstgr.visFilm(filmFraInput);
		System.out.println();
		
	}
	
	public void start() {
		// Lager noen filmer og legger de til i filmarkiv objektet vi opprettet i konstruktøren.
		Film film2 = new Film(2, "Tom Hanks", "Hanks's film", 1995, Sjanger.HISTORY, "Universial Films");
		Film film3 = new Film(3, "Aksel Hennie", "UNO", 2005, Sjanger.ACTION, "Norsk Film");
		Film film4 = new Film(4, "George Lucas", "Star Wars episode 1", 2007, Sjanger.ACTION, "Universial Films");
		
		this.filmarkiv.leggTilFilm(film2);
		this.filmarkiv.leggTilFilm(film3);
		this.filmarkiv.leggTilFilm(film4);
				
		// Skriver ut filmstatistikk.
		System.out.println("Filmstatistikk:");
		this.tekstgr.skrivUtStatistikk(this.filmarkiv);
		
		System.out.println();
		
		// Skriver ut filmer med produsent gitt som parameter.
		tekstgr.skrivUtFilmProdusent(filmarkiv, "Tom Hanks");
		System.out.println();
}
}
