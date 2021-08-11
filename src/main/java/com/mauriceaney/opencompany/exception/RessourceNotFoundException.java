package com.mauriceaney.opencompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Maurice Aney
 * @date 04/08/2021 11:48
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public RessourceNotFoundException(String message){
        super(message);
    }

}
