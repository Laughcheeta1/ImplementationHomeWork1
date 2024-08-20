package com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Dto.ItemCountDTO;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.ProductPurchase;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.ProductPurchaseId;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductPurchaseDao extends JpaRepository<ProductPurchase, ProductPurchaseId> {
    @Query(value = "SELECT p FROM ProductPurchase pp INNER JOIN pp.purchase p WHERE pp.product.id = :productId")
    // I want to know why the bellow one does not work
//    @Query(value = "SELECT p.* FROM Product_Purchase AS pp INNER JOIN Purchase as P ON pp.purchase_id = p.id WHERE pp.product_id = :productId", nativeQuery = true)
    public List<Purchase> getPurchasesFromProductId(@Param("productId") Long productId);

    @Query(value = "SELECT pp.product, pp.quantity FROM ProductPurchase pp WHERE pp.purchase = :purchaseId")
    public List<ItemCountDTO> getItems(@Param("purchaseId") Long purchaseId);

    @Query(value = "DELETE FROM ProductPurchase pp WHERE pp.purchase = :purchaseId")
    public void deleteAllByPurchaseId(@Param("purchaseId") Long purchaseId);
}
