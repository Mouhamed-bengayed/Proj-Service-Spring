package com.example.glsib.Service;
import com.example.glsib.Entite.Customer;
import com.example.glsib.Repository.CustomerRepository;
import com.example.glsib.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;
@Service

public class CustomerService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MailSenderService mailSenderService;


    public Customer addCustomer(Customer a1) {
        a1.setValid(false);
        Customer savedcustomer = customerRepository.save(a1);
        return savedcustomer;
    }

    public Customer deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    public List<Customer> getAllCustomer() {
        customerRepository.findAll();
        return getAllCustomer();
    }

    public void validInscription(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer customer1 = customer.get();
            customer1.setValid(true);
            this.customerRepository.save(customer1);
            try {
                this.mailSenderService.send(customer.get().getEmail(), "Votre compte a été activé  ", "merci pour votre inscription");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       // return new Customer("khalid" ,passwordEncoder().encode("password) AuthorityUtils.N0_AUTHORITIES"));
        Customer  customer= customerRepository.findByEmail(username);
        if (customer == null) {
            throw new NotFoundException("User not found");

    }
        return customer;
    }
    @Bean
    private PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

