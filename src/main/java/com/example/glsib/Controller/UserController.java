package com.example.glsib.Controller;

import com.example.glsib.Entite.Comment;
import com.example.glsib.Entite.User;
import com.example.glsib.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RequestMapping("/api/user")
@RestController
public class UserController {
@Autowired
    UserService userService;




    @GetMapping("/list-User")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> ListUser() {return userService.getAllUser();}

}
