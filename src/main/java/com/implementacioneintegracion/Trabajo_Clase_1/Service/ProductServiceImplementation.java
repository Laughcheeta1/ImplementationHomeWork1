package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ProductDao;
import com.implementacioneintegracion.Trabajo_Clase_1.Exceptions.CustomExceptions.ProductNotFoundException;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImplementation implements ProductService{
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImplementation(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product getProductByName(String name) {
        return productDao.findByName(name).orElseThrow(() -> new ProductNotFoundException(name));
    }

    @Override
    public int getStockQuantityProduct(Long id) {
        return productDao.findStockById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product productInDb = productDao.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        productInDb.setName(product.getName());
        productInDb.setDescription(product.getDescription());
        productInDb.setPrice(product.getPrice());
        productInDb.setStockQuantity(product.getStockQuantity());
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }
}
