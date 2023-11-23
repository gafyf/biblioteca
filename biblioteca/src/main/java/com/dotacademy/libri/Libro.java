package com.dotacademy.libri;

public class Libro {

	private String id;
	private String titolo;
	private String autore;
	private String pubblicazione;
	private boolean disponibilita;
	private String stato;
	private int numCopie;
	private int numCopieDisponibili;
	private String codiceScaffale;

	
	public String getCodiceScaffale() {
		return codiceScaffale;
	}
	public void setCodiceScaffale(String codiceScaffale) {
		this.codiceScaffale = codiceScaffale;
	}
	public int getNumCopie() {
		return numCopie;
	}
	public void setNumCopie(int numCopie) {
		this.numCopie = numCopie;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getPubblicazione() {
		return pubblicazione;
	}
	public void setPubblicazione(String pubblicazione) {
		this.pubblicazione = pubblicazione;
	}
	public boolean isDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}
	public int getNumCopieDisponibili() {
		return numCopieDisponibili;
	}

	public void setNumCopieDisponibili(int numCopieDisponibili) throws Exception {
		if(this.numCopieDisponibili < 0){
			throw new Exception("Non ci sono più copie disponibili");
		}
		this.numCopieDisponibili = numCopieDisponibili;
	}


	@Override
	public String toString() {
		return "Libro{" +
				"id='" + id + '\'' +
				", titolo='" + titolo + '\'' +
				", autore='" + autore + '\'' +
				", pubblicazione='" + pubblicazione + '\'' +
				", disponibilita=" + disponibilita +
				", stato='" + stato + '\'' +
				", numCopie=" + numCopie +
				", numPrestate=" + numCopieDisponibili +
				", codiceScaffale='" + codiceScaffale + '\'' +
				'}';
	}
}
