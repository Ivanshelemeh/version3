package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceProductImp {


    private ProductRepository productRepository;

        @Autowired
    public ServiceProductImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProductFromBucket(){
            Optional<Product> productOptional = Optional.of(new Product());
            productRepository.deleteById(productOptional.get().getId());
        }






    }

