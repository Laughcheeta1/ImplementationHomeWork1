package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.ItemCountDTO;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Purchase;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.PurchaseRequest;

import java.util.List;


public interface PurchaseService {
    public void savePurchase(PurchaseRequest purchaseRequest);

    public Purchase getPurchaseById(Long id);

    public List<Purchase> getPurchaseByClientId(Long id) throws Exception;

    // Return all the purchases that contain a product with the given id
    public List<Purchase> getPurchaseByProductId(Long id);

    public List<ItemCountDTO> getItemsFromPurchase(Long id);

    public void deletePurchase(Long id);

}
