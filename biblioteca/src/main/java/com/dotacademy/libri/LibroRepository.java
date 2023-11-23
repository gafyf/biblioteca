package com.dotacademy.libri;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibroRepository extends MongoRepository<Libro, String> {

	public List<Libro> findByAutore(String autore);

	public Optional<Libro> findByTitolo(String titolo);

	public boolean existsByTitolo (String titolo);

	public Optional<Libro> findByStato (String titolo, String stato);

}
