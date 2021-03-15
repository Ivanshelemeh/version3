package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepoFindAll extends JpaRepository<Product,Integer> {
    public void  findAllProduct();
}
