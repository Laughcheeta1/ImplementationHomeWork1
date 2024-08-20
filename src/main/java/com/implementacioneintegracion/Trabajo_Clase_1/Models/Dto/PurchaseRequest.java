package com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.InsideItem;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseRequest {
    private Long clientId;
    private List<InsideItem> items;
}
