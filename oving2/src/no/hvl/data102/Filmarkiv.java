package no.hvl.data102;
import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;

public class Filmarkiv implements FilmarkivADT {
	private Film[] arkiv;
	private int antall;
	private int gittStorrelse;
	
	public Filmarkiv(int storrelse) {
		this.arkiv = new Film[storrelse];
		this.antall = 0;
		this.gittStorrelse = storrelse; 
	}
	
	@Override
	public Film visFilm(int nr) {
		Film result = null;
		
		for (Film i : this.arkiv) {
			// La til denne fordi fikk feil når jeg kalte skrivUtFilmProdusent().
			if (i != null) {
				if (i.getFilmNr() == nr) {
					result = i;
					break;
				}
			}
		}
		return result;
	}
	
	@Override
	public void leggTilFilm(Film film) {
		if (this.antall < this.gittStorrelse) {
			this.arkiv[this.antall] = film;
			this.antall++;
		} else {
			utvid();
		}
		
	}

	private Film[] utvid() {
		Film[] nyTabell = new Film[this.antall*2];
		
		for (int i=0; i < this.antall; i++) {
			nyTabell[i] = this.arkiv[i];
		}
		
		return nyTabell;
		
	}
	
	@Override
	public boolean slettFilm(int nr) {
		boolean result = false;
		
		for (int i=0; i < this.antall; i++) {
			if (this.arkiv[i].getFilmNr() == nr) {
				// Flytter siste Film i listen til den vi fjerner.
				this.arkiv[i] = this.arkiv[this.antall];
				this.arkiv[this.antall] = null;
				result = true;
				this.antall--;
			}
		}
		return result;
	}
	
	public Film[] sokTittel(String streng) {
		Film[] nyListe = new Film[this.antall];
		int index = 0;
		for (int i=0; i < this.antall; i++) {
			if (this.arkiv[i].getTittel().contains(streng)) {
				nyListe[index] = this.arkiv[i];
				index++;
			}
		}
		
		this.arkiv = trim(nyListe, index);
		
		return this.arkiv;
	}
	
	private Film[] trim(Film[] filmTabell, int index) {
		// Loop pa nytt med tabell kun plass til antall filmer i tabellen i param.
		Film[] nyTabell = new Film[index];
		for (int i=0; i < filmTabell.length; i++) {
			nyTabell[i] = filmTabell[i];
		}
		return nyTabell;
		
	}
	
	@Override
	public int antall() {
		int antall = 0;
		
		for (Film i: this.arkiv) {
			if (i != null) {
				antall++;
			}
		}
		return antall;
	}
	
	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		for (Film i : this.arkiv) {
			if (i != null) {
				if (i.getSjanger() == sjanger) {
					antallSjanger++;
				}
			}
		}

		return antallSjanger;
	}	


	// La til denne fordi fikk ikke til skrivUtFilmProdusent() i TekstGrensessnitt uten.
	@Override
	public Film[] avProdusent(String produsent) {
		Film[] result = new Film[this.antall];
		
		for (int i=0; i < this.antall; i++) {
			if (this.arkiv[i] != null) {
				if (this.arkiv[i].getProdusent().equals(produsent)) {
					result[i] = this.arkiv[i];
				}
			}
		}
		
		return result;
	}



}






