package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceFindByIdImpl {

    private  final ProductRepository productRepository;

    @Autowired
    public ServiceFindByIdImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(){
        Optional<Product> optionalProduct = Optional.of(new Product());
            if (optionalProduct.isPresent()) {
                productRepository.findById(optionalProduct.get().getId());

            }
            Product product = new Product();
           return productRepository.save(product);

    }
}
