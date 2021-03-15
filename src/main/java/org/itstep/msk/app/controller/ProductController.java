package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.service.ServiceFindByIdImpl;
import org.itstep.msk.app.service.ServiceProdFindAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

    @Autowired
    private ServiceProdFindAll serviceProdFindAll;

    @Autowired
    private ServiceFindByIdImpl serviceFindById;



    @GetMapping(value = "/all")
    public void giveAllProduct(){
        serviceProdFindAll.searchAllProduct();
    }

    @GetMapping("/product{id}")
    public void getMeOneProductByName(@RequestBody Product product,@PathVariable Integer id){
        serviceFindById.findById();

    }
    
}
