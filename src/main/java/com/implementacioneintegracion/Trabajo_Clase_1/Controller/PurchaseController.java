package com.implementacioneintegracion.Trabajo_Clase_1.Controller;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.ItemCountDTO;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Purchase;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.PurchaseRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PurchaseController {
    ResponseEntity<String> savePurchase(PurchaseRequest purchaseRequest) throws Exception;

    ResponseEntity<Purchase> getPurchaseById(Long id) throws Exception;

    ResponseEntity<List<Purchase>> getPurchaseByClientId(Long id) throws Exception;

    ResponseEntity<List<Purchase>> getPurchaseByProductId(Long id);

    ResponseEntity<List<ItemCountDTO>> getItemsFromPurchase(Long id);

    ResponseEntity<String> deletePurchase(Long id);
}
