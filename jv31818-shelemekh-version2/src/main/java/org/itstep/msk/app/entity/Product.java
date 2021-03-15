package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;

    @Column( name = "name_product" ,nullable = false)
    private String name;

    @Column(name = "final_price")
    private double totalPrice;


    @OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id"  ,insertable = false ,
            updatable = true,referencedColumnName ="id",nullable = true)
    private Set<Customer> customer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.totalPrice, totalPrice) == 0 &&
                id.equals(product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(customer, product.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public Product() {
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }




    public Integer getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



}