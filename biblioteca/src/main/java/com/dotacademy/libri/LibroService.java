package com.dotacademy.libri;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

	@Autowired
	private LibroRepository lb;
	
	public List<Libro> findByAutore(String autore){
		return lb.findByAutore(autore);
	}

	public Optional<Libro> findByTitolo(String titolo){
		return lb.findByTitolo(titolo);
	}

	public Optional<Libro> findByStato(String titolo, String stato) { return lb.findByStato(titolo, stato); }

	public void creaLibro(Libro libro) {
		if(isExistsByTitolo(libro.getTitolo())) {
			throw new IllegalArgumentException("Il libro con il titolo " + libro.getTitolo() + " esiste gia");
		}
		lb.save(libro);
	}

	public boolean isExistsByTitolo(String titolo) {
		return lb.existsByTitolo(titolo);
	}

	public void deleteById(String id) {
		lb.deleteById(id);
	}
	
	public List<Libro> findAll(){
		return lb.findAll();
	}

	public void update(Libro libro){
		lb.save(libro);
	}
}
