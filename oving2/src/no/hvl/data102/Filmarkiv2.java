package no.hvl.data102;
import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		this.antall = 0;
	}
	
	public Film visFilm(int nr) {
		LinearNode<Film> film = null;
		LinearNode<Film> current = start;
		boolean funnet = false;
		
		for (int i=0; i < this.antall && !funnet; i++) {
			if (current.getElement().getFilmNr() == nr) {
				funnet = true;
				film = current;
			} else {
				current = current.getNeste();
			}
		}
		
		return film.getElement();
	}
	
	public void leggTilFilm(Film film) {
		LinearNode<Film> node = new LinearNode<Film>(film);
		node.setNeste(start);
		start = node;
		antall++;
	}
	
	public boolean slettFilm(int nr) {
		boolean result = false;
		LinearNode<Film> current = start;
		
		for (int i=0; i < antall; i++) {
			if (current.getElement().getFilmNr() == nr) {
				current = current.getNeste();
				result = true;
				antall--;
			} else {
				current = current.getNeste();
			}
		}
		return result;
	}
	
	public Film[] sokTittel(String streng) {
		
		LinearNode<Film> current = start;
		Film[] result = new Film[antall];
		int index = 0;
		
		for (int i=0; i < antall; i++) {
			if (current.getElement().getTittel().contains(streng)) {
				result[i] = current.getElement();
				index++;
			} else {
				current = current.getNeste();
			}
		}
		// Returnerer liste med Film-objekter etter trim-metoden har fjernet alle 'null' verdier.
		return(trim(result, index));
	}
	
	
	private Film[] trim(Film[] filmTabell, int index) {
		// Loop på nytt med tabell kun plass til antall filmer i tabellen i param.
		Film[] nyTabell = new Film[index];
		for (int i=0; i < filmTabell.length; i++) {
			nyTabell[i] = filmTabell[i];
		}
		return nyTabell;
		
	}
	
	public int antall() {
		return this.antall;
	}
	
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		
		LinearNode<Film> current = start;
		
		for (int i=0; i < antall; i++) {
			if (current.getElement().getSjanger() == sjanger) {
				antallSjanger++;
			}
			current = current.getNeste();
		}

		return antallSjanger;
	}
	
	
	// La til denne fordi fikk ikke til skrivUtFilmProdusent() i TekstGrensessnitt uten.
	public Film[] avProdusent(String produsent) {
		LinearNode<Film> current = start;
		Film[] filmer = new Film[antall];
		// Teller index for parameter til trim() metoden.
		int index = 0;
		for (int i=0; i < antall; i++) {
			if (current.getElement().getProdusent().equals(produsent)) {
				filmer[i] = current.getElement();
				index++;
			}
			
			current = current.getNeste();
		}
	
		return filmer;		
	} 






}
