package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registerNavigation")
    public String registerNavigation() {
        return "registerNavigation";
    }

    @GetMapping("/userRegistration")
    public String userRegistration() {
        return "/userRegistration";
    }

    @GetMapping("/customerRegistration")
    public String customerRegistration() {
        return "/customerRegistration";
    }

    @GetMapping("/managerRegistration")
    public String managerRegistration() {
        return "/managerRegistration";
    }

    @GetMapping("/managerCustomerRegistration")
    public String managerCustomerRegistration() {
        return "/managerCustomerRegistration";
    }
}
