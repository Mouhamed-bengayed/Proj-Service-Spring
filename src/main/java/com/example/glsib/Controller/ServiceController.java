package com.example.glsib.Controller;

import com.example.glsib.Entite.Service;
import com.example.glsib.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    public Service addService(Service s1){
        Service savedArticle = serviceRepository.save(s1);
        return savedArticle;
    }
    public Service deleteService(Long id){
        Optional<Service>  service = serviceRepository.findById(id);
        if(service.isPresent()){
            return service.get();
        }else
        {
            return null;
        }
    }
    public List<Service> gettAllService(){
        serviceRepository.findAll();
        return gettAllService();
    }

}
