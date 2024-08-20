package com.implementacioneintegracion.Trabajo_Clase_1.Exceptions;

import com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions.ClientNotFoundException;
import com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions.ProductNotFoundException;
import com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions.PurchaseNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerImplementation {
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientNotFoundException(ClientNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(404);
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(404);
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(PurchaseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePurchaseNotFoundException(PurchaseNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(404);
        return ResponseEntity.status(404).body(errorResponse);
    }
}
