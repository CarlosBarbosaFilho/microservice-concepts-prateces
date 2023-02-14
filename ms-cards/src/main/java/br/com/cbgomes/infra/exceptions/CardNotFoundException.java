package br.com.cbgomes.infra.exceptions;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String msg){
        super(msg);
    }
}
