package org.itstep.msk.app.service;


import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class AdminServiceImp {


        private  final ProductRepository productRepository;
         private final CustomRepository customRepository;

            @Autowired
            public AdminServiceImp(ProductRepository productRepository, CustomRepository customRepository) {
                this.productRepository = productRepository;
                this.customRepository = customRepository;
            }

        public  String updateProduct(String  name){
          Product product = new Product();
            productRepository.findById(product.getId());
           productRepository.save(product);
           return name;


        }

        public void deleteCustomerOnDate(){
            Customer customer = new Customer();
            if( customer.getName()!= null){
                customRepository.delete(customer);


            }

        }

        public void findAllCustomer(){
         customRepository.findAll()
                .stream().filter(customer -> customer.getId()==null);
        }
    }
