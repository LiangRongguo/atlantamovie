package com.example.demo.web;

import com.example.demo.po.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "/login";
    }

    @PostMapping("/login")
    public  String login(@RequestParam String username,
                         @RequestParam String password,
                         HttpSession session,
                         RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        //User user = new User();
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "/index";
        }
        else {
            attributes.addFlashAttribute("message","Username/ password is wrong");
            return "redirect:";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "/index";
    }
}
