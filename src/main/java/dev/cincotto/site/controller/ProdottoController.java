package dev.cincotto.site.controller;


import dev.cincotto.site.entity.Prodotto;
import dev.cincotto.site.service.ProdottoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/prodotto")

public class ProdottoController {

    @Autowired
    ProdottoServiceImpl prodottoService;

    @GetMapping("/{id}") /* passo id prodotto direttament nell'url e lo recupero con @PathVariable */
    public Prodotto getProdotto(@PathVariable("id") int codiceProdotto){ //la pathvariable cerca la pathvariable che si chiama id e la mette in codiceprodotto

        Prodotto tmp = prodottoService.getOneById(codiceProdotto);
        return  tmp;
    }


}
