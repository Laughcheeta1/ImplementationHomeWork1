package com.implementacioneintegracion.Trabajo_Clase_1.Controller;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Product;
import com.implementacioneintegracion.Trabajo_Clase_1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllerImplementation implements ProductController{
    private final ProductService productService;

    @Autowired
    public ProductControllerImplementation(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<String> saveProduct(@RequestBody   Product product) {
        productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product successfully created");
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }

    @Override
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) throws Exception {;
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByName(name));
    }

    @Override
    @GetMapping("/stock/{id}")
    public ResponseEntity<Integer> getStockQuantityProduct(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getStockQuantityProduct(id));
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) throws Exception {
        productService.updateProduct(product.getId(), product);
        return ResponseEntity.status(HttpStatus.OK).body("Product Updated Successfully");
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product Deleted Successfully");
    }
}
