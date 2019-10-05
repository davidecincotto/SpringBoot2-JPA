package dev.cincotto.site.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prodotti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String nome;
    String descrizione;
    Double prezzo;
    @ManyToMany( mappedBy = "listaprodotti", cascade = CascadeType.ALL)
    List<Persona> listapersone;
}