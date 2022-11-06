package com.example.glsib.Repository;

import com.example.glsib.Entite.Comment;
import com.example.glsib.Entite.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(String username);
}
