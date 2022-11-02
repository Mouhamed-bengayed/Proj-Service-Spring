package com.example.glsib.Controller;

import com.example.glsib.Entite.Comment;
import com.example.glsib.Entite.Customer;
import com.example.glsib.Entite.Provider;
import com.example.glsib.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add-customer")
    public Customer addcustomer(@RequestBody @Validated Customer A1) {
        return customerService.addCustomer(A1);
    }
    @GetMapping("/list-customer")
    public List<Customer> ListComment() {
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/delete-customer/{idCustomer}")
    public void deletecustomer(@PathVariable("idLevel") Long idCustomer) {
        customerService.deleteCustomer(idCustomer);
    }


    @PutMapping("/validate-provider/{idcustomer}")
    public void validInscription(@PathVariable("idcustomer") Long idcustomer) {
        customerService.validInscription(idcustomer);
    }

}
