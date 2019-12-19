package com.example.demo.web;

import com.example.demo.po.User;
import com.example.demo.service.UserService;
import com.example.demo.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

@Controller
public class RegisController {
    @Resource
    private EntityManager entityManager;

    @Autowired
    private UserService userService;

    @GetMapping("/registerNavigation")
    public String registerNavigation() {
        return "registerNavigation";
    }

    @GetMapping("/userRegistration")
    public String userRegistrationPage() {
        return "/userRegistration";
    }

    @PostMapping("/userRegistration")
    public String userRegistration(@RequestParam String firstname,
                                   @RequestParam String lastname,
                                   @RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String confirmpassword,
                                   RedirectAttributes attributes) {

        // check whether password matches confirm-password
        if (!password.equals(confirmpassword)) {
            attributes.addFlashAttribute("message", "Password does not match the confirmation password.");
            return "redirect:/userRegistration";
        }

        // check whether the user already exists or not
        if (userService.checkUserExist(username) != null) {
            attributes.addFlashAttribute("message", "User already exists.");
            return "redirect:/userRegistration";
        }

        User u = new User();
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setUsername(username);
        u.setPassword(MD5Utils.code(password));
        System.out.println(u.toString());

        u = userService.saveUser(u);

        if (u != null) {
            attributes.addFlashAttribute("message", "User registered successfully.");
        } else {
            attributes.addFlashAttribute("message", "User registration failed.");
        }
        return "redirect:/userRegistration";
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
