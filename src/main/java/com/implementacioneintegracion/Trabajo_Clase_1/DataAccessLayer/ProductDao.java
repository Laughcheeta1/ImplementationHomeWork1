package com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {
    public Optional<Product> findByName(String name);

    public Optional<Integer> findStockById(Long id);
}
