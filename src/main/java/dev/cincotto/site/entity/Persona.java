package dev.cincotto.site.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {


    public Persona(String nome, String cognome, List<Prodotto> listaprodotto ) {
        this.nome = nome;
        this.cognome=cognome;
        this.listaprodotti=listaprodotto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @JsonIgnore  /*rimuove dal json questa proprietà sia mentre produce sia mentre riceve. */
            String nome;

    @JsonProperty("account")
    String cognome;

    @ManyToMany(cascade = CascadeType.ALL)  /*campo in relazione many to many con prodotti, quindi ad ogni persona corrisponde una lista di prodotti acquistati */
    @JoinTable(name = "rel_persona_prodotto",
            joinColumns = {
                @JoinColumn(name = "persona_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "prodotto_id")
    })
            @JsonManagedReference //indica che da questa entity verso l'altra si ha la relazione principlae, che viene quindi serializzata. L'output del JSON sarà che questa classe contiene 'altra/e come figlie.
    List<Prodotto> listaprodotti;
}



