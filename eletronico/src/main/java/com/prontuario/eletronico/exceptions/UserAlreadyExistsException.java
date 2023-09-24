package com.prontuario.eletronico.exceptions;

public class UserAlreadyExistsException extends Exception {

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "User Already Exists";
    }
    
}
