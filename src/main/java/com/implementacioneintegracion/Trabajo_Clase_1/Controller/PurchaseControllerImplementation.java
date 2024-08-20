package com.implementacioneintegracion.Trabajo_Clase_1.Controller;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.ItemCountDTO;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Purchase;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.PurchaseRequest;
import com.implementacioneintegracion.Trabajo_Clase_1.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseControllerImplementation implements PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseControllerImplementation(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<String> savePurchase(PurchaseRequest purchaseRequest) throws Exception {
        purchaseService.savePurchase(purchaseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Purchase successfully saved");
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.getPurchaseById(id));
    }

    @Override
    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getPurchaseByClientId(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.getPurchaseByClientId(id));
    }

    @Override
    @GetMapping("/product/{id}")
    public ResponseEntity<List<Purchase>> getPurchaseByProductId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.getPurchaseByProductId(id));
    }

    @Override
    @GetMapping("/items/{id}")
    public ResponseEntity<List<ItemCountDTO>> getItemsFromPurchase(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.getItemsFromPurchase(id));
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable("id") Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.status(HttpStatus.OK).body("Purchase successfully deleted");
    }
}
