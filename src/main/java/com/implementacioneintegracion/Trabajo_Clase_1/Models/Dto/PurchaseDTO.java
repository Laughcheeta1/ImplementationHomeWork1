package com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class PurchaseDTO {
    private Long id;
    private Date purchaseDate;
    private Long clientId;
}
