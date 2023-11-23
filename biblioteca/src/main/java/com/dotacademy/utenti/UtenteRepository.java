package com.dotacademy.utenti;

import com.dotacademy.libri.Libro;
import com.dotacademy.utenti.Utente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends MongoRepository<Utente, String> {

}
