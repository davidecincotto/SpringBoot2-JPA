package dev.cincotto.site.controller;


import dev.cincotto.site.entity.Prodotto;
import dev.cincotto.site.service.ProdottoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/prodotto")

public class ProdottoController {

    @Autowired
    ProdottoServiceImpl prodottoService;


    @GetMapping
    public List<Prodotto> getProdotti() {

        List<Prodotto> tmp = prodottoService.getAll();
        return tmp;
    }

    @GetMapping("/{id}") /* passo id prodotto direttament nell'url e lo recupero con @PathVariable */
    public Prodotto getProdotto(@PathVariable("id") int codiceProdotto) { //la pathvariable cerca la pathvariable che si chiama id e la mette in codiceprodotto

        Prodotto tmp = prodottoService.getOneById(codiceProdotto);
        return tmp;
    }


    @PostMapping //crea un metodo richiamato da chiamata post da client. Noi lo simuliamo con postman per ora.
    public Prodotto addProdotto(@RequestBody Prodotto p) {

        System.out.println(p);
        return p;
    }
}
