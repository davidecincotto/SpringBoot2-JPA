package dev.cincotto.site.service;


import dev.cincotto.site.entity.Prodotto;
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


}
