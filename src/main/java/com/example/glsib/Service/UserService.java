package com.example.glsib.Service;

import com.example.glsib.Entite.User;
import com.example.glsib.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;




    public User deleteCustomer(Long id) {
        Optional<User> customer = userRepository.findById(id);
        if (((Optional<?>) customer).isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    public List<User> getAllUser() {
        userRepository.findAll();
        return getAllUser();
    }
}
