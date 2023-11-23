package com.dotacademy.utenti;

import com.dotacademy.libri.Libro;
import com.dotacademy.libri.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository ut;
    @Autowired
    private LibroService libroService;

    /**
     *
     * Scenario: arriva mario e chiede in prestito il libro di harry potter
     *
     * 1. controllare che il libro sia ancora disponibile -> true
     * 2. affidare il libro a Mario
     * 3. segnare che il numero di copie disponibili diminuisce di uno
     *
     * */

    public Optional<Utente> findByUtente(String id){
        return ut.findById(id) ;
    }

    public void creaUtente(Utente utente) {
        ut.save(utente);
    }

    public List<Libro> affittaLibro(String idUtente, String titoloLibro) throws Exception {
        Libro libroRichiesto = libroService.findByTitolo(titoloLibro)
                .orElseThrow(() -> new IllegalArgumentException("Il libro non è presente in catalogo"));

        if(libroRichiesto.getNumCopieDisponibili() == 0){
           throw new IllegalArgumentException("tutte le copie sono fuori");
        }

        Utente utente = findByUtente(idUtente)
                .orElseThrow(() -> new IllegalArgumentException("Utente non registrato"));


        List<Libro> libriAffittati = new ArrayList<>();

        if(utente.getLibri() != null) {
            libriAffittati.addAll(utente.getLibri());
        }
        libriAffittati.add(libroRichiesto);

        utente.setLibri(libriAffittati);
        libroRichiesto.setNumCopieDisponibili(libroRichiesto.getNumCopieDisponibili() - 1);

        libroService.update(libroRichiesto);
        update(utente);
        return utente.getLibri();
    }

    public List<Libro> ritornoLibro(String idUtente, String titoloLibro) throws Exception {
        Libro ritornoRichiesto = libroService.findByTitolo(titoloLibro)
                .orElseThrow(() -> new IllegalArgumentException("Il libro non è presente in catalogo"));



        Utente utente = findByUtente(idUtente)
                .orElseThrow(() -> new IllegalArgumentException("Utente non registrato"));


        List<Libro> libriAffittati = new ArrayList<>();

        if(utente.getLibri() != null) {
            libriAffittati.addAll(utente.getLibri());
        }
        libriAffittati.remove(ritornoRichiesto);

        utente.setLibri(libriAffittati);
        ritornoRichiesto.setNumCopieDisponibili(ritornoRichiesto.getNumCopieDisponibili() + 1);

        libroService.update(ritornoRichiesto);
        update(utente);
        return utente.getLibri();
    }


    public void ordinaLibro(Libro libro) throws Exception {
        if(libroService.isExistsByTitolo(libro.getTitolo()) && libro.getStato().equals("ordinato")) {
            libro.setNumCopieDisponibili(libro.getNumCopieDisponibili() + 1);
        }
        libro.setStato("ordinato");
        libroService.creaLibro(libro);
    }

    public List<Utente> findAll(){
        return ut.findAll();
    }
    public void update(Utente utente){
        ut.save(utente);
    }
}
