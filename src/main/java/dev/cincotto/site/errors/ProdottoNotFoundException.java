package dev.cincotto.site.errors;

public class ProdottoNotFoundException extends RuntimeException{

    public ProdottoNotFoundException(){

        this("Prodotto non presente"); //richiama costruttore sotto
    }

    public ProdottoNotFoundException(String message){

        super(message); //richiama costruttore di RuntimeException e imposta messaggio da stampare nel caso in cui si vogliano info sull'eccezione

    }



}
