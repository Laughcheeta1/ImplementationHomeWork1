package com.implementacioneintegracion.Trabajo_Clase_1.Exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int status;
}
