package com.photon.product_service.controller;

import com.photon.product_service.entity.Product;
import com.photon.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/products/")
public class ProductController {
    @Autowired
    private ProductService productService;

   private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        logger.info("getProductById :"+id);
       Optional<Product> product = productService.getProductById(id);
       if (product.isPresent()){
           logger.info("found the product by id "+id);
           logger.info("Product details "+product.get().toString());
           return new ResponseEntity<>(product.get(),HttpStatus.OK);
       }
       else {
           logger.info("product not found for id "+id);
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
}
