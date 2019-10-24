package dev.cincotto.site.errors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //dice che in caso di eccezioni Spring deve cercare comportamenti "ad hoc" per eccezioni qui specificate
public class RestExceptionHandler {

    @ExceptionHandler({ProdottoNotFoundException.class}) //.class gli indica che ProdottoNotFoundException è l'oggetto che deve cercare. ExceptionHandler fa si che spring sappia che eccezione è mappata da quersto metodo. Se voglio gestire più eccezioni in modo uguale scrivo più di una eccezione. Però se lo faccio il metodo deve avere in ingresso un generico padre di tutte le eccezioni per recuperare il messaggio relativo ad ognuna.
    public ResponseEntity proottoNotFoundHandler(ProdottoNotFoundException ex){
        //new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND); //è errore 404
        //se non specifico body è come se La response avesse un contenuto nullo e quindi ho errore 404 da browser
        return new CustomeResponseException( ex.getMessage(),HttpStatus.NOT_FOUND).getResponse(); //HTTP status serve per far capire al client quale è stato l'errore che ha portato la richiesta ad interruzione. In questo caso not found significa che la risorsa che è stata richiesta (il prodotto) non è stata trovata.
    }
}


class CustomeResponseException {  //creo una classe che mi permetta di fornire una risposta standardidzzata e completa in tutto il programma.

    Object data;
    LocalDateTime date;
    String message;
    String status;
    HttpStatus code;

    public CustomeResponseException(String messaggio, HttpStatus code ){
        this(null, messaggio, code);
    }//costruttore

    public CustomeResponseException(Object data, String messaggio, HttpStatus code ){ //costruttore

        this.data = data;
        date = LocalDateTime.now();
        this.message = messaggio;
        this.code = code;
        status=""+code.value(); //uso "" per convertire in String il codice dell'errore numerico.
    }

    public ResponseEntity getResponse() { //quando converte mappa in JSON ho stringa con tutte le info e le voci della mappa.
        Map<Object, Object> items = new HashMap<>();
        items.put("status",status);
        items.put("date",date.format(DateTimeFormatter.ISO_DATE_TIME));
        items.put("message",message);
        items.put("data", data);

        return new ResponseEntity(items,code);
    }
}