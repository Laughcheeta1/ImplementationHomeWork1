package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import org.springframework.stereotype.Service;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Product;

import java.util.List;


public interface ProductService {
    public void saveProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public Product getProductByName(String name);

    public int getStockQuantityProduct(Long id);

    public void updateProduct(Long id, Product product);

    public void deleteProduct(Long id);

}
