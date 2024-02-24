package com.cmpt276.as2.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmpt276.as2.models.User;
import com.cmpt276.as2.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UsersControllers {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        String newHair = newuser.get("hair");
        double newGpa = Double.parseDouble(newuser.get("gpa"));
        String newAlive = newuser.get("alive");
        userRepo.save(new User(newName, newWeight, newHeight, newHair, newGpa, newAlive));
        response.setStatus(201);
        return "users/addedUser";
    }

    @PostMapping("/users/remove")
    public String removeUser(@RequestParam("id") int id){
        System.out.println("REMOVE user " + id);
        // Integer sid = Integer.valueOf(id);
        userRepo.deleteById(id);
        return "users/removedUser";
    }
}
