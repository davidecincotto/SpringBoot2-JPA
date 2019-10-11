package dev.cincotto.site.repository;


import dev.cincotto.site.entity.Prodotto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends CrudRepository<Prodotto, Integer> {
 //metodi implementati in background grazie ad annotazione.
}
