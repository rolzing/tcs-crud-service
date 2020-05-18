package com.tcs.richard.CrudService.exceptions;

public class ServerErrorException extends Throwable {
    public ServerErrorException(String message) {
        super(message);
    }
}
