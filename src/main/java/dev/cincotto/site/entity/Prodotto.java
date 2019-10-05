package dev.cincotto.site.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    Integer id;

    String nome;
    String descrizione;
    Double prezzo;
    @JsonBackReference
    @ManyToMany( mappedBy = "listaprodotti", cascade = CascadeType.ALL)
    List<Persona> listapersone;
}