package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepoFindAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceProdFindAll {

    private ProductRepoFindAll productRepoFindAll;

    @Autowired
    public ServiceProdFindAll(ProductRepoFindAll productRepoFindAll) {
        this.productRepoFindAll = productRepoFindAll;
    }

    @Query("select (*count) from product")
    public void  searchAllProduct(){
      productRepoFindAll.findAllProduct();

    }

}
