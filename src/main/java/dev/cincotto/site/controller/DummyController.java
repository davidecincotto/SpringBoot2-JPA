package dev.cincotto.site.controller;

import dev.cincotto.site.entity.Persona;
import dev.cincotto.site.entity.Prodotto;
import dev.cincotto.site.service.PersoneServiceImpl;
import dev.cincotto.site.service.ProdottoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/v1")
public class DummyController {

    @Autowired //da alla mia classe il riferim al service corrispondente. E' un attributo della classe. Qualcunque metodo io creo nella classe avra a disposizione ilriferimento a personaService.
            PersoneServiceImpl personeService;

    @Autowired
    ProdottoServiceImpl prodottoService;


    @GetMapping("/caricadatidemofix")
    public ResponseEntity caricaDatiFix() {  //Questo metodo carica dati fake su db

        Random r = new Random();
        List<Prodotto> listaprodotti = new ArrayList();

        //Salvo 10 prodotti generati grazie a Random() sul DB
        for (int i = 1; i <= 10; i++) {
            Prodotto p1 = new Prodotto( "Prodotto" + i, "Bel prodotto!", r.nextDouble() * 100, null); //id lo lascio null in quanto in prodotto ho specificato che id è gestito e assegnato in automatico, listapersone la lascio null perchè assegno dopo le persone ai prodotti.

            p1 = prodottoService.save(p1); //passo prodotto senza chiave che viene salvato su db, e mi viene ritornato l'oggetto su db aggiornato che quindi conterrà anche la chiave sul db. Per chiave intendo la chiave interna, cioè l'id.
            listaprodotti.add(p1);
        }

        List<Persona> listapersone = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            List<Prodotto> listarandom = new ArrayList<>();
            for (int k = 0; k < 4; k++) {
                if (r.nextBoolean()) //così se esce true aggiunge prodotto, se esce false no. Randomizzo la decisione di aggiungere o meno un prodotto quindi la lunghezza della lista
                    listarandom.add(listaprodotti.get(r.nextInt(listaprodotti.size())));
            }
            Persona tmp = new Persona( "Nome" + i, "Cognome" + i, listarandom);
            //se l'id della persona è nullo durante la creazione verrà valorizzato secondo la strategia scelta nell'entity, che nel mio caso è autoincrement, quindi valorizza in automatico. Qui è il punto in cui creo le persone da inserire a db.

            personeService.save(tmp); //chiama il Service della classe persona, che ho instanziato grazie a @Autoweired.
        }


        //la response entity è un oggetto che simula il ritorno di un oggetto http. In genere torna un Header e un Body che posso personalizzare.
        return new ResponseEntity("OK", HttpStatus.OK);
    }






    @GetMapping("/caricadatidemo")
    public ResponseEntity caricaDati() {

        Random r = new Random();
        List<Prodotto> listaprodotti = new ArrayList();
        for (int i = 1; i < 10; i++) {
            Prodotto p1 = new Prodotto("Prodotto" + i, "Bel prodotto!", r.nextDouble() * 100, null);
            listaprodotti.add(p1);
        }

        List<Persona> listapersone = new ArrayList<>();
        for (int i = 1; i < 10; i++) {

            List<Prodotto> listarandom = new ArrayList<>();
            for (int k = 0; k < 4; k++) {
                if (r.nextBoolean()) //così se esce true aggiunge prodotto, se esce false no. Randomizzo la decisione di aggiungere o meno un prodotto quindi la lunghezza della lista
                    listarandom.add(listaprodotti.get(r.nextInt(listaprodotti.size())));
            }
            Persona tmp = new Persona( "Nome" + i, "Cognome" + i, listarandom);
            //se l'id della persona è nullo durante la creazione verrà valorizzato secondo la strategia scelta nell'entity, che nel mio caso è autoincrement, quindi valorizza in automatico.

            personeService.save(tmp);
        }


        //la response entity è un oggetto che simula il ritorno di un oggetto http. In genere torna un Header e un Body che posso personalizzare.
        return new ResponseEntity("OK", HttpStatus.OK);
    }

}
