package dev.cincotto.site.repository;

import dev.cincotto.site.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface PersonaRepository extends CrudRepository<Persona, Integer> { //dovrei implementare i metodi di crudrepository, ma userò Autoweired


    List<Persona> findAll();
    //per nomeclatura per scrivere metodi che mi interessano devo cercare

}
