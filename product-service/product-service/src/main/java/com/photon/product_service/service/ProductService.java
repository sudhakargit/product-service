package com.photon.product_service.service;

import com.photon.product_service.entity.Product;
import com.photon.product_service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static Logger logger = LoggerFactory.getLogger(ProductService.class);
    public List<Product> getAllProducts(){
        logger.info("get all products called");
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id){
        logger.info("get Product By Id : "+id);
        return productRepository.findById(id);
    }
}
