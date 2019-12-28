package com.example.demo.web;

import com.example.demo.po.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private EmployeeService employeeService;

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
            userService.delete(username);
            attributes.addFlashAttribute("message", "User registration failed.");
        }
        return "redirect:/login";
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

        // check whether the creditcardnum already exists or not
        if (creditcardService.checkCreditcardnum(creditcardnum) != null) {
            attributes.addFlashAttribute("message", "Creditcard already exists.");
            return "redirect:/customerRegistration";
        }

        User user = userService.saveUser(username, firstname, lastname, password);
        Customer customer = customerService.saveCustomer(username);
        Creditcard creditcard = creditcardService.saveCreditcard(creditcardnum, username);
        attributes.addFlashAttribute("message", "Customer registered successfully.");

        return "redirect:/login";
    }

    @GetMapping("/managerRegistration")
    public String managerRegistrationPage(@PageableDefault(size = 10, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pageable, Model model) {
        model.addAttribute("page", companyService.listCompany(pageable));
        return "/managerRegistration";
    }

    @PostMapping("/managerRegistration")
    public String managerRegistration(@RequestParam String firstname,
                                      @RequestParam String lastname,
                                      @RequestParam String username,
                                      @RequestParam String company,
                                      @RequestParam String password,
                                      @RequestParam String confirmpassword,
                                      @RequestParam String street,
                                      @RequestParam String city,
                                      @RequestParam String state,
                                      @RequestParam String zipcode,
                                      RedirectAttributes attributes) {
        // check whether password matches confirm-password
        if (!password.equals(confirmpassword)) {
            attributes.addFlashAttribute("message", "Password does not match the confirmation password.");
            return "redirect:/managerRegistration";
        }

        // check whether the user already exists or not
        if (userService.checkUserExist(username) != null) {
            attributes.addFlashAttribute("message", "User already exists.");
            return "redirect:/managerRegistration";
        }

        // check whether the street address is unique
        if (managerService.checkStreetAddress(street, city, state, zipcode) != null) {
            attributes.addFlashAttribute("message", "Street address already been registered.");
            return "redirect:/managerRegistration";
        }

        User user = userService.saveUser(username, firstname, lastname, password);
        Employee employee = employeeService.saveEmployee(username);
        Manager manager = managerService.saveManager(username, company, street, city, state, zipcode);
        attributes.addFlashAttribute("message", "Manager registered successfully.");

        return "redirect:/login";
    }

    @GetMapping("/managerCustomerRegistration")
    public String managerCustomerRegistrationPage(@PageableDefault(size = 10, sort = {"name"}, direction = Sort.Direction.ASC)Pageable pageable, Model model) {
        model.addAttribute("page", companyService.listCompany(pageable));
        return "/managerCustomerRegistration";
    }

    @PostMapping("/managerCustomerRegistration")
    public String managerCustomerRegistration(@RequestParam String firstname,
                                              @RequestParam String lastname,
                                              @RequestParam String username,
                                              @RequestParam String company,
                                              @RequestParam String password,
                                              @RequestParam String confirmpassword,
                                              @RequestParam String street,
                                              @RequestParam String city,
                                              @RequestParam String state,
                                              @RequestParam String zipcode,
                                              @RequestParam String creditcardnum,
                                              RedirectAttributes attributes) {
        // check whether password matches confirm-password
        if (!password.equals(confirmpassword)) {
            attributes.addFlashAttribute("message", "Password does not match the confirmation password.");
            return "redirect:/managerCustomerRegistration";
        }

        // check whether the user already exists or not
        if (userService.checkUserExist(username) != null) {
            attributes.addFlashAttribute("message", "User already exists.");
            return "redirect:/managerCustomerRegistration";
        }

        // check whether the street address is unique
        if (managerService.checkStreetAddress(street, city, state, zipcode) != null) {
            attributes.addFlashAttribute("message", "Street address already been registered.");
            return "redirect:/managerCustomerRegistration";
        }

        // check whether the creditcardnum already exists or not
        if (creditcardService.checkCreditcardnum(creditcardnum) != null) {
            attributes.addFlashAttribute("message", "Creditcard already exists.");
            return "redirect:/managerCustomerRegistration";
        }

        User user = userService.saveUser(username, firstname, lastname, password);
        Employee employee = employeeService.saveEmployee(username);
        Manager manager = managerService.saveManager(username, company, street, city, state, zipcode);
        Customer customer = customerService.saveCustomer(username);
        Creditcard creditcard = creditcardService.saveCreditcard(creditcardnum, username);
        attributes.addFlashAttribute("message", "Manager&Customer registered successfully.");

        return "redirect:/login";
    }
}
