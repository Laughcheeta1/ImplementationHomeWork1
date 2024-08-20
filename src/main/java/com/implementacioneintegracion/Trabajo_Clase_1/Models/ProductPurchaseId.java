package com.implementacioneintegracion.Trabajo_Clase_1.Models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class ProductPurchaseId implements Serializable {
    private Long purchaseId;
    private Long productId;

    // Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.implementacioneintegracion.Trabajo_Clase_1.Models.ProductPurchaseId that = (com.implementacioneintegracion.Trabajo_Clase_1.Models.ProductPurchaseId) o;
        return Objects.equals(purchaseId, that.purchaseId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, productId);
    }
}
