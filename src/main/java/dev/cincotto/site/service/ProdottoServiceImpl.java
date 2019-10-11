package dev.cincotto.site.service;


import dev.cincotto.site.entity.Prodotto;
import dev.cincotto.site.errors.ProdottoNotFoundException;
import dev.cincotto.site.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoServiceImpl {

    @Autowired
    ProdottoRepository prodottoRepository;

    public Prodotto save(Prodotto p) {
        return prodottoRepository.save(p);

    }

    public Prodotto getOneById( int id){

       return prodottoRepository.findById(id).orElseThrow(ProdottoNotFoundException::new); //vado a richiamare metodo repository che però ritorna un Optional. Quindi usando "OrElsoThrow" sistemo la cosa lanciando una eccezione nel caso l'optional non contenga un prodotto. L'eccezione la istanzio e lancio con sintassi abbreviata lambda.

    }

}
