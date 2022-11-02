package com.example.glsib.Controller;

import com.example.glsib.Entite.Customer;
import com.example.glsib.Entite.Provider;
import com.example.glsib.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/provider")
@RestController
public class ProviderController {
@Autowired
    ProviderService providerService;

    @PostMapping("/add-provider")
    public Provider addprovider(@RequestBody @Validated Provider A1) {
        return providerService.addProvider(A1);
    }

    @GetMapping("/list-provider")
    public List<Provider> ListProvider() {
        return providerService.getAllProvider();
    }

    @DeleteMapping("/delete-provider/{idProvider}")
    public void deletepProvider(@PathVariable("idLevel") Long idProvider) {
        providerService.deleteProvider(idProvider);
    }
}
