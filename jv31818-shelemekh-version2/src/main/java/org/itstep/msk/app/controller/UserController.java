package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserController {

    private final CustomRepository repo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserController(CustomRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }
    //Get login page and fill it with credentials

    @GetMapping("/login")
    public String registerform(Model model){
        model.addAttribute("customer", new Customer());
        return "register";
    }

    /*
    Save in database customer with parameters  name , password
    return view of HTML
 */
    @PostMapping("/login")
    public String createCustomer( @Valid @ModelAttribute("customer") Customer customer,BindingResult result){
        if (result.hasErrors()) {
            return "register";
        }
        String name =customer.getName();
        String email= customer.getEmail();
        String pass = customer.getPassword();
        String  enc = encoder.encode(pass);
        repo.save(customer);
        return "registersuccess";
        
    }

    
}




