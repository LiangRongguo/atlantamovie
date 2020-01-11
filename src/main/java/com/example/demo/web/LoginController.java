package com.example.demo.web;

import com.example.demo.po.Admin;
import com.example.demo.po.Customer;
import com.example.demo.po.Manager;
import com.example.demo.po.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ManagerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private AdminService adminService;


    @GetMapping
    public String Home() {
        return "/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login";
    }

    @PostMapping("/login")
    public  String login(@RequestParam String username,
                         @RequestParam String password,
                         HttpSession session,
                         RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);

        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);

            Customer customer = customerService.checkCustomerExist(username);
            Manager manager = managerService.checkManagerExist(username);
            Admin admin = adminService.checkAdminExist(username);

            if (admin != null) {
                if (customer != null) {
                    return "/function/adminAndCustomerFunctionality";
                }
                else {
                    return "/function/adminFunctionality";
                }
            }

            if (manager != null) {
                if (customer != null) {
                    return "/function/managerAndCustomerFunctionality";
                }
                else {
                    return "/function/managerFunctionality";
                }
            }
            else if (customer != null) {
                return "/function/customerFunctionality";
            }

            return "/function/userFunctionality";
        }
        else {
            attributes.addFlashAttribute("message","Username/password is wrong");
            return "redirect:";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:";
    }
}
