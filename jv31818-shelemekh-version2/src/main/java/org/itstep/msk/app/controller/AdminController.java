package org.itstep.msk.app.controller;


import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin", produces = "application/json")
public class AdminController {

    private   final AdminServiceImp adminServiceImp;

    @Autowired
    public AdminController(AdminServiceImp adminServiceImp) {
        this.adminServiceImp = adminServiceImp;
    }

    @GetMapping("/panel")
    @PreAuthorize("hasRole('ADMIN')")
    public String seachAllCustomer(@RequestBody Customer customer,@RequestParam String name, @RequestParam String password,
                                  Model model ){
    model.addAttribute("panel",customer);
    return "panel";


    }

    @PostMapping("/panel")
    public void enterInAdminka(@RequestBody Customer customer){
        adminServiceImp.findAllCustomer();



    }

    @PutMapping("/admin/update")
    public Product changeProduct(@RequestBody Product prod, @RequestParam  String name){
        adminServiceImp.updateProduct(name);
        return new Product();

    }


    @DeleteMapping("/admin/delete{id}")
    public Product deleteCustomer( @PathVariable Integer id){
        adminServiceImp.deleteCustomerOnDate();
        if (deleteCustomer(id) == null){
            adminServiceImp.findAllCustomer();

        }else {
            throw new RuntimeException("Customer not found");

        }
           return null;

    }






}
