package dev.cincotto.site.controller;

import dev.cincotto.site.entity.Persona;
import dev.cincotto.site.service.PersoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/persone")
public class PersonaController {


    @Autowired
    PersoneServiceImpl personeService;

    @GetMapping("/") /* qui creo una lista all'indirizzo /persona/ che riempio con due elementi e la ritorno. Avendo annotato la classe come un rest controller la lista viene ritornata direttamente in formato JSON. Se uso Object o List come tipo di ritorno nella firma del metodo non cambia nulla */
    public Object getAll(){
        //List<Persona> elenco = new ArrayList<>();
       // elenco.add(new Persona(1, "Mario", "Rossi", null));
        //elenco.add(new Persona(2, "Pino", "Scotto", new ArrayList<>()));
        //return elenco;
        return personeService.getAll();  //la manda al service, che contatta repository, che va a leggere su db.
    }





}
