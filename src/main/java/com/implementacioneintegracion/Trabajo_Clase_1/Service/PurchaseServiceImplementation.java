package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ProductDao;
import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ProductPurchaseDao;
import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.PurchaseDao;
import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ClientDao;
import com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions.ProductNotFoundException;
import com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions.PurchaseNotFoundException;
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
    public void savePurchase(PurchaseRequest purchaseRequest) {
        Client client = clientDao.findById(purchaseRequest.getClientId())
                .orElseThrow(
                        () -> new PurchaseNotFoundException(purchaseRequest.getClientId())
                );

        Purchase purchase = new Purchase();
        purchase.setClient(client);
        purchase.setPurchaseDate(new Date());
        purchaseDao.save(purchase);

        List<ProductPurchase> items = new ArrayList<>();
        purchaseRequest.getItems().forEach((item) -> {
            ProductPurchase p = new ProductPurchase();
            p.setPurchase(purchase);
            p.setProduct(productDao.findById(item.productId()).orElseThrow(() -> new ProductNotFoundException(item.productId())));
            items.add(p);
        } );

        productPurchaseDao.saveAll(items);
    }

    @Override
    public Purchase getPurchaseById(Long id) {
        return purchaseDao.findById(id).orElseThrow(() -> new PurchaseNotFoundException(id));
    }

    @Override
    public List<Purchase> getPurchaseByClientId(Long id) {
        // NOTE: technically, this should not return an PurchaseNotFound exception, since perhaps a client
        // has not made any purchases yet. However, I have other projects to attend.
        return purchaseDao.findByClientId(id).orElseThrow(() -> new PurchaseNotFoundException(id));
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
