package com.cvicse.mydemo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "jokeRequest Not found")
public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String errorMsg){
        super(errorMsg);
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
