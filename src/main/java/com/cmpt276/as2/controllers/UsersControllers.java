package com.cmpt276.as2.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmpt276.as2.models.User;
import com.cmpt276.as2.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UsersControllers {

    @Autowired
    private UserRepository userRepo;

    // redirect to home
    @RequestMapping("/")
    public String home(){
        return "redirect:/users/view";
    }

    // view all page
    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    // add student
    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        try{
            String newName = newuser.get("name");
            int newWeight = Integer.parseInt(newuser.get("weight"));
            int newHeight = Integer.parseInt(newuser.get("height"));
            String newHair = newuser.get("hair");
            double newGpa = Double.parseDouble(newuser.get("gpa"));
            String newAlive = newuser.get("alive");
            userRepo.save(new User(newName, newWeight, newHeight, newHair, newGpa, newAlive));
            response.setStatus(201);
        }catch(Exception e){
            System.out.println("FORM NOT FILLED");
        }
        return "redirect:/users/view";
    }

    // edit form prefill
    @GetMapping("/users/edit")
    public String showEdit(@RequestParam("id") int id, Model model){
        System.out.println("Getting user " + id);
        User user = userRepo.getReferenceById(id);
        model.addAttribute("user", user);
        return "users/editForm";
    }
    // edit form
    @PostMapping("/users/edit")
    public String editUser(@ModelAttribute("user") User user, BindingResult result){
        if(!result.hasErrors()){
            System.out.println("Editing user");
            userRepo.save(user);
        }else{
            System.out.println("ERROR EDITING STUDENT");
        }
        return "redirect:/users/view";
    }

    // remove student
    @PostMapping("/users/remove")
    public String removeUser(@RequestParam("id") int id){
        System.out.println("REMOVE user " + id);
        userRepo.deleteById(id);
        return "redirect:/users/view";
    }

    // rectangle
    @GetMapping("/users/rectangle")
    public String getMethodName(Model model) {
        System.out.println("Getting all users");
        List<User> users = userRepo.findAll();
        model.addAttribute("us", users);
        return "users/rectangle";
    }
    
}
