package com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions;

public class PurchaseNotFoundException extends RuntimeException {
    public PurchaseNotFoundException(Long id) {
        super("Could not find purchase " + id);
    }
}
