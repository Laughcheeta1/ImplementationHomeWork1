package com.implementacioneintegracion.Trabajo_Clase_1.Service;

import com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer.ProductDao;
import com.implementacioneintegracion.Trabajo_Clase_1.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
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
    public Product getProductById(Long id) throws Exception {
        return productDao.findById(id).orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public Product getProductByName(String name) throws Exception {
        return productDao.findByName(name).orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public int getStockQuantityProduct(Long id) throws Exception {
        return productDao.findStockById(id).orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public void updateProduct(Long id, Product product) throws Exception {
        Product productInDb = productDao.findById(id).orElseThrow(() -> new Exception("product not found"));

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
