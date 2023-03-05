package com.simpliLearn.loginAuth.controller;

import com.simpliLearn.loginAuth.Domain.User;
import com.simpliLearn.loginAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    //Home page
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    //Register-SignUp
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    //Process Registration
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/searchFname")
    public String getUserByFname(@RequestParam
          (name="fName", required = false, defaultValue = "User2")
               String fName,Model model){
        System.out.println(" In searchFname ");
        List<User> listUsers = userRepo.findByFirstName(fName);
        model.addAttribute("listUsers", listUsers);
        System.out.println(" Before return ");
        return "search_user_list";
    }


}

