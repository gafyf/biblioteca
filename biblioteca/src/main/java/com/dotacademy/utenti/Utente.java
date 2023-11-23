package com.dotacademy.utenti;

import com.dotacademy.libri.Libro;

import java.util.List;

public class Utente {

	private String id;
	private String nome;
	private String cognome;
	private List<Libro> libri;

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Utente{" +
				"id='" + id + '\'' +
				", nome='" + nome + '\'' +
				", cognome='" + cognome + '\'' +
				", libri=" + libri +
				'}';
	}
}
