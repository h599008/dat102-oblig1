package no.hvl.data102.klient;
import no.hvl.data102.Filmarkiv;
import no.hvl.data102.Filmarkiv2;
import no.hvl.data102.adt.FilmarkivADT;

public class KlientFilmarkiv {
	public static void main(String[] args) {
		// Filmarkiv
//		FilmarkivADT filma = new Filmarkiv(10);
//		Meny meny = new Meny(filma);
//		meny.start();

		
		// Filmarkiv 2
		FilmarkivADT filma2 = new Filmarkiv2();
		Meny meny2 = new Meny(filma2);
		meny2.start();
	}
}
