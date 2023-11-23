package com.dotacademy.libri;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libro/api/v1")
public class LibroController {
	
	@Autowired
	private LibroService ls;

	@PostMapping("/create")
	public ResponseEntity<?> creaLibro(@RequestBody Libro libro){
		try {
			ls.creaLibro(libro);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (IllegalArgumentException i) {
			return new ResponseEntity<>(i.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deleteLibro(@PathVariable String id){
		ls.deleteById(id);
	}
	
	@GetMapping("/find-by-autore")
	public List<Libro> findByAutore(@RequestParam String autore){
		return ls.findByAutore(autore);
	}

	@GetMapping("/find-by-titolo")
	public Optional<Libro> findByTitolo(@RequestParam String titolo){
		return ls.findByTitolo(titolo);
	}

	@GetMapping("/find-by-stato")
	public Optional<Libro> findByStato(@RequestParam String titolo, @RequestParam String stato){
		return ls.findByStato(titolo, stato);
	}
	
	@GetMapping("/all")
	public List<Libro> findAll(){
		return ls.findAll();
	}
}
