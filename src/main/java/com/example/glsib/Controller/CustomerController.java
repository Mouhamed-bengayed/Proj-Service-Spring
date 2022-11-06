package com.example.glsib.Controller;

import com.example.glsib.Entite.Comment;
import com.example.glsib.Entite.Customer;
import com.example.glsib.Entite.Provider;
import com.example.glsib.Service.CustomerService;
import com.example.glsib.dtos.JwtResponse;
import com.example.glsib.dtos.SignIn;
import com.example.glsib.security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtil tokenUtil;

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

    @PutMapping("/validate-customer/{idcustomer}")
    public void validInscription(@PathVariable("idcustomer") Long idcustomer) {
        customerService.validInscription(idcustomer);
    }

    @PostMapping(value = {"", "/"})
    public JwtResponse signIn(@RequestBody SignIn signIn) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = customerService.loadUserByUsername(signIn.getEmail());
        String token = tokenUtil.generateToken(userDetails);

        JwtResponse response = new JwtResponse(token);
        return response;


    }
}