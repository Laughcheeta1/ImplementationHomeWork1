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
        return new ResponseEntity<String>("Product successfully created", HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) throws Exception {
        return new ResponseEntity<Product>(productService.getProductByName(name), HttpStatus.OK);
    }

    @Override
    @GetMapping("/stock/{id}")
    public ResponseEntity<Integer> getStockQuantityProduct(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<Integer>(productService.getStockQuantityProduct(id), HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) throws Exception {
        productService.updateProduct(product.getId(), product);
        return new ResponseEntity<String>("Product Updated Successfully", HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }
}
