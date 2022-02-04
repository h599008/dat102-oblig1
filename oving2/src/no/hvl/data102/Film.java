package no.hvl.data102;


public class Film {
	private int filmNr;
	private String produsent;
	private String tittel;
	private int pub_dato;
	private Sjanger sjanger;
	private String selskap;
	
	public Film() {	
		// Oppretter et tomt objekt.
	}
	
	// Oppretter et objekt med objektvariablene gitt ved parametere. 
	public Film(int filmNr, String produsent, String tittel, int pub_dato, Sjanger sjanger, String selskap) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.pub_dato = pub_dato;
		this.sjanger = sjanger;
		this.selskap = selskap;
	}

	// Setters
	
	public void setFilmnr(int filmNr) {
		this.filmNr = filmNr;
	}
	
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public void setPubDato(int pub_dato) {
		this.pub_dato = pub_dato;
	}
	
	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	// Getters
	
	public int getFilmNr() {
		return this.filmNr;
	}
	
	public String getProdusent() {
		return this.produsent;
	}
	
	public String getTittel() {
		return this.tittel;
	}
	
	public int getPubDato() {
		return this.pub_dato;
	}
	
	public String getSelskap() {
		return this.selskap;
	}
	
	public Sjanger getSjanger() {
		return this.sjanger;
	}
	
		
	// Denne må kalles fra et film objekt og sammenlignes med et annet. 
	@Override
	public boolean equals(Object a) {
		boolean result = false;
		
		if (a instanceof Film) {
			Film film = (Film) a;
			if (this.filmNr == film.getFilmNr()) {
				result = true;
			} 
		}
	
		return result;
	}
	
	@Override
	public int hashCode() {
		Integer temp = this.filmNr;
		return temp.hashCode();
		
	}
	
	public String toString() {
		String result = ("Filmnummer: " + this.filmNr + "\n" + "Produsent: " + this.produsent + "\n" + "tittel: " + this.tittel + "\n" + "Dato: " + this.pub_dato + "\n" + "Sjanger: " + this.sjanger + "\n" + "Selskap: " + this.selskap);
		return result;
	}



}
