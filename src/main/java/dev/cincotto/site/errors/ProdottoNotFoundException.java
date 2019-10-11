package dev.cincotto.site.errors;

public class ProdottoNotFoundException extends RuntimeException{

    public ProdottoNotFoundException(){

        this("Prodotto non presente");
    }

    public ProdottoNotFoundException(String message){

        super(message);

    }



}
