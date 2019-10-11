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

    public Prodotto(String nome, String descrizione, Double prezzo, List<Persona> listapersone) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.listapersone = listapersone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String nome;
    String descrizione;
    Double prezzo;
    @JsonBackReference //indica che questa è la entity secondaria della relazione, quindi non viene serializzata la relazione che va da questa entity all'altra.
    @ManyToMany( mappedBy = "listaprodotti", cascade = CascadeType.ALL)
    List<Persona> listapersone;
}