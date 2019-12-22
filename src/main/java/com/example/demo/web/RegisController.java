package com.example.demo.web;

import com.example.demo.po.Creditcard;
import com.example.demo.po.Customer;
import com.example.demo.po.User;
import com.example.demo.service.CreditcardService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisController {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CreditcardService creditcardService;

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

        User u = userService.saveUser(username, firstname, lastname, password);

        if (u != null) {
            attributes.addFlashAttribute("message", "User registered successfully.");
        } else {
            attributes.addFlashAttribute("message", "User registration failed.");
        }
        return "redirect:/userRegistration";
    }

    @GetMapping("/customerRegistration")
    public String customerRegistrationPage() {
        return "/customerRegistration";
    }

    @PostMapping("/customerRegistration")
    public String customerRegistration(@RequestParam String firstname,
                                       @RequestParam String lastname,
                                       @RequestParam String username,
                                       @RequestParam String password,
                                       @RequestParam String confirmpassword,
                                       @RequestParam String creditcardnum,
                                       RedirectAttributes attributes) {

        // check whether password matches confirm-password
        if (!password.equals(confirmpassword)) {
            attributes.addFlashAttribute("message", "Password does not match the confirmation password.");
            return "redirect:/customerRegistration";
        }

        // check whether the user already exists or not
        if (userService.checkUserExist(username) != null) {
            attributes.addFlashAttribute("message", "User already exists.");
            return "redirect:/customerRegistration";
        }

        // check whether the customer already exists or not
        if (customerService.checkCustomerExist(username) != null) {
            attributes.addFlashAttribute("message", "Customer already exists.");
            return "redirect:/customerRegistration";
        }

        // check whether the creditcardnum already exists or not
        if (creditcardService.checkCreditcardnum(creditcardnum) != null) {
            attributes.addFlashAttribute("message", "Creditcard already exists.");
            return "redirect:/customerRegistration";
        }

        userService.saveUser(username, firstname, lastname, password);
        Customer customer = customerService.saveCustomer(username);
        Creditcard creditcard = creditcardService.saveCreditcard(creditcardnum, username);

        if (customer != null && creditcard != null) {
            attributes.addFlashAttribute("message", "Customer registered successfully.");
        } else {
            // delete partial result
            attributes.addFlashAttribute("message", "Customer registration failed.");
        }

        return "redirect:/customerRegistration";
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
