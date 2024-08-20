package com.implementacioneintegracion.Trabajo_Clase_1.Controller;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Product;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {
    ResponseEntity<String> saveProduct(Product product);

    ResponseEntity<List<Product>> getAllProducts();

    ResponseEntity<Product> getProductById(Long Id) throws Exception;

    ResponseEntity<Product> getProductByName(String name) throws Exception;

    ResponseEntity<Integer> getStockQuantityProduct(Long id) throws Exception;

    ResponseEntity<String> updateProduct(Product product) throws Exception;

    ResponseEntity<String> deleteProduct(Long id);
}
