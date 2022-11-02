package com.example.glsib.Service;

import com.example.glsib.Entite.Customer;
import com.example.glsib.Entite.Provider;
import com.example.glsib.Service.MailSenderService;
import com.example.glsib.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService  {


@Autowired
    ProviderRepository providerRepository;
@Autowired
MailSenderService mailSenderService;

    public Provider addProvider(Provider a1){
        Provider savedprovider=   providerRepository.save(a1);
        return savedprovider;
    }
    public Provider deleteProvider(Long id){
        Optional<Provider> provider = providerRepository.findById(id);
        if(provider.isPresent()){
            return provider.get();
        }else
        {
            return null;
        }
    }
    public List<Provider> getAllProvider(){
        providerRepository.findAll();
        return getAllProvider();
    }





}
