package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ProductDao;
import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ProductPurchaseDao;
import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.PurchaseDao;
import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ClientDao;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.*;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.ItemCountDTO;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.PurchaseRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PurchaseServiceImplementation implements PurchaseService {
    private final PurchaseDao purchaseDao;
    private final ProductPurchaseDao productPurchaseDao;
    private final ClientDao clientDao;
    private final ProductDao productDao;

    @Autowired
    public PurchaseServiceImplementation(
            PurchaseDao purchaseDao,
            ProductPurchaseDao productPurchaseDao,
            ClientDao clientDao,
            ProductDao productDao
    ) {
        this.purchaseDao = purchaseDao;
        this.productPurchaseDao = productPurchaseDao;
        this.clientDao = clientDao;
        this.productDao = productDao;
    }

    @Transactional
    @Override
    public void savePurchase(PurchaseRequest purchaseRequest) throws Exception {
        Client client = clientDao.findById(purchaseRequest.getClientId()).orElseThrow(() -> new Exception("Customer not found"));

        Purchase purchase = new Purchase();
        purchase.setClient(client);
        purchase.setPurchaseDate(new Date());
        purchaseDao.save(purchase);

        List<ProductPurchase> items = new ArrayList<>();
        purchaseRequest.getItems().forEach((item) -> {
            ProductPurchase p = new ProductPurchase();
            p.setPurchase(purchase);
            p.setProduct(productDao.findById(item.productId()).orElseThrow(() -> new RuntimeException("Item not found")));
            items.add(p);
        } );

        productPurchaseDao.saveAll(items);
    }

    @Override
    public Purchase getPurchaseById(Long id) throws Exception {
        return purchaseDao.findById(id).orElseThrow(() -> new Exception("Purchase not found"));
    }

    @Override
    public List<Purchase> getPurchaseByClientId(Long id) throws Exception {
        return purchaseDao.findByClientId(id).orElseThrow(() -> new Exception("Purchase not found"));
    }

    @Override
    public List<Purchase> getPurchaseByProductId(Long id) {
        return productPurchaseDao.getPurchasesFromProductId(id);
    }

    @Override
    public List<ItemCountDTO> getItemsFromPurchase(Long id) {
        return productPurchaseDao.getItems(id);
    }

    @Override
    public void deletePurchase(Long id) {
        productPurchaseDao.deleteAllByPurchaseId(id);
        purchaseDao.deleteById(id);
    }
}
