package dev.cincotto.site.service;

import dev.cincotto.site.entity.Persona;
import dev.cincotto.site.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoneServiceImpl {

    @Autowired
    PersonaRepository personaRepository; /*non istanziono PersonaRepository ma lo dichiaro e basta perchè così sarà spring a istanziarloe  implementarlo in automatico. Se lo implementassi io dovrei occuparmi di tutti i metodi ereditati dall'interfaccia che devono essere implementati. Grazie alla reflection spring capisce in automatico come devono essere implementati questi metodi. Per farglielo cercare uso annotazione autoweired*/

    public List<Persona> getAll() {
        return personaRepository.findAll(); //chiama il repository che va a leggere su db.
    }

    public Persona save(Persona p) {

        //Svolgo controlli su persona passata come parametro. Controllo da info più generica a più specifica per evitare NullPointerException.
        if (p == null || p.getCognome().length() < 1 || p.getCognome().length() < 1 || p.getNome() == null || p.getCognome() == null) {
            throw new RuntimeException("La persona inserita non è valida");
        }

        return personaRepository.save(p); //il metodo save() di CrudeRepository ritorna in automatico la persona salvata. Ricordo che in PersonaRepository non ho riscritto metodo in quanto usando annotazione @Repository ciò viene fatto in automatico da Spring.
    }

}
