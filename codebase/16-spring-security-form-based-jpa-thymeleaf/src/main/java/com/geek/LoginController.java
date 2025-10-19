package com.geek;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.geek.entity.User;
import com.geek.service.UserService;

@Controller //normal spring MVC for web apps
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";  //suffix .html (login.html)
    }
    
    @GetMapping("/other")
    public String otherpage() {
        return "other";  //other.html
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminPage( Principal p,Model model ) {
    	model.addAttribute("user", p.getName());
        return "admin"; //admin.html
    }
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userPage(Principal p, Model model) {
    	model.addAttribute("user", p.getName());
        return "user"; //user.html
    }
    
    @GetMapping("/home")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public String homePage() {
        return "home"; //home.html
    }
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.getUserByUserName(user.getUserName()) != null) {
            return ResponseEntity.badRequest().body("Username already exists. Please choose another one.");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }
}