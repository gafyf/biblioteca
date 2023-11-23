package com.dotacademy.utenti;

import com.dotacademy.libri.Libro;
import com.dotacademy.libri.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente/api/v1")
public class UtenteController {

    @Autowired
    private UtenteService us;

    @PostMapping("/add")
    public ResponseEntity<?> creaUtente(@RequestBody Utente utente){
        try {
            us.creaUtente(utente);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException i) {
            return new ResponseEntity<>(i.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public List<Utente> findAll(){
        return us.findAll();
    }

    @GetMapping("/affitta-libro")
    public ResponseEntity<?> affittaLibro(@RequestParam String id, @RequestParam String titolo) throws Exception {
        try {
            return new ResponseEntity<>(us.affittaLibro(id, titolo), HttpStatus.OK);
        }
        catch (IllegalArgumentException i) {
            return new ResponseEntity<>(i.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/ordina")
    public ResponseEntity<?> ordinaLibro (@RequestBody Libro libro) {
      try {
          us.ordinaLibro(libro);
          return new ResponseEntity<>(HttpStatus.OK);
      }
      catch (Exception i) {
          return new ResponseEntity<>(i.getMessage(), HttpStatus.BAD_REQUEST);
      }
    }
}
