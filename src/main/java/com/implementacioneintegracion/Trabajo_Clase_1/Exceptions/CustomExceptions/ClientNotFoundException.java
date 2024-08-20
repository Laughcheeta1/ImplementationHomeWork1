package com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("Could not find client " + id);
    }

    public ClientNotFoundException(String message) {
        super("Could not find client with " + message);
    }
}
