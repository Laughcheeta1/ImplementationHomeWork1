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
        return new ResponseEntity<String>("Purchase successfully saved", HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<Purchase>(purchaseService.getPurchaseById(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getPurchaseByClientId(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<List<Purchase>>(purchaseService.getPurchaseByClientId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/product/{id}")
    public ResponseEntity<List<Purchase>> getPurchaseByProductId(@PathVariable("id") Long id) {
        return new ResponseEntity<List<Purchase>>(purchaseService.getPurchaseByProductId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/items/{id}")
    public ResponseEntity<List<ItemCountDTO>> getItemsFromPurchase(@PathVariable("id") Long id) {
        return new ResponseEntity<List<ItemCountDTO>>(purchaseService.getItemsFromPurchase(id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable("id") Long id) {
        purchaseService.deletePurchase(id);
        return new ResponseEntity<String>("Purchase successfully deleted", HttpStatus.OK);
    }
}
