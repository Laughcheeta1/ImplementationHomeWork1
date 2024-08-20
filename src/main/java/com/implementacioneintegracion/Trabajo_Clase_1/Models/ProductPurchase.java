package com.implementacioneintegracion.Trabajo_Clase_1.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Product_Purchase")
@Data
public class ProductPurchase {
    @EmbeddedId
    private ProductPurchaseId id;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name="purchase_id", referencedColumnName="id")
    private Purchase purchase;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id", referencedColumnName="id")
    private Product product;

    @Column(name="quantity")
    private int quantity;
}
