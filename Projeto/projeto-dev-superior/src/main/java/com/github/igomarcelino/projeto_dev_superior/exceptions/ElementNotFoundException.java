package com.github.igomarcelino.projeto_dev_superior.exceptions;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String message) {
        super(message);
    }

    public ElementNotFoundException(String message, Object ...params) {
        super(String.format(message,params));
    }
}
