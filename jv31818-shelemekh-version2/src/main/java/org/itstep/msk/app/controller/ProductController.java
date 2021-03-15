package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.service.ServiceProductImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

    private final ServiceProductImp productImp;

    @Autowired
    public ProductController(ServiceProductImp productImp) {
        this.productImp = productImp;
    }

    @GetMapping(value = "/all")
    public void giveAllProduct(){
        productImp.findAllofProduct();
    }

    @GetMapping("/product{id}")
    public void getMeOneProductByName(@RequestBody Product product,@PathVariable Integer id){
        productImp.findbyNameProduct();

    }
    
}
