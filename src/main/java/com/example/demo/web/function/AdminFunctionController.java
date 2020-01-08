package com.example.demo.web.function;

import com.example.demo.po.Movie;
import com.example.demo.service.*;
import com.example.demo.vo.CompanyQuery;
import com.example.demo.vo.TheaterQuery;
import com.example.demo.vo.UserQuery;
import com.example.demo.vo.VisitQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/func")
public class AdminFunctionController {
    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private MovieService movieService;

    @GetMapping("adminFunctionality")
    public String adminFunctionalityPage() {
        return "function/adminFunctionality";
    }

    @GetMapping("/createMovie_Admin")
    public String createMoviePage() {
        return "/function/createMovie_Admin";
    }

    @PostMapping("/createMovie_Admin")
    public String createMovie(@RequestParam String name,
                              @RequestParam Integer duration,
                              @RequestParam String releasedate,
                              RedirectAttributes attributes) {
        // check if movie already exist or not
        if (movieService.findMovie(name, releasedate) != null) {
            attributes.addFlashAttribute("message", "Movie already existed.");
            return "redirect:/func/createMovie_Admin";
        }

        Movie movie = movieService.saveMovie(name, duration, releasedate);
        attributes.addFlashAttribute("message", "Movie Created Successfully.");
        return "redirect:/func/createMovie_Admin";
    }

    @GetMapping("/exploreTheater_Admin")
    public String exploreTheaterPage(@PageableDefault(size = 10) Pageable pageable, Model model, TheaterQuery theaterQuery) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, theaterQuery));
        return "function/exploreTheater_Admin";
    }

    @PostMapping("/exploreTheater_Admin")
    public String exploreTheater(@PageableDefault(size = 10) Pageable pageable, Model model,
                                 @RequestParam String theater,
                                 @RequestParam String company,
                                 @RequestParam String city,
                                 @RequestParam String state) {
        TheaterQuery theaterQuery =  new TheaterQuery(company, theater, city, state);
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, new TheaterQuery(company, theater, city, state)));
        return "function/exploreTheater_Admin";
    }

    @GetMapping("/visitHistory_Admin")
    public String visitHistoryPage(@PageableDefault(size = 10) Pageable pageable, Model model, VisitQuery visitQuery, HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, visitQuery, session));
        return "function/visitHistory_Admin";
    }

    @PostMapping("/visitHistory_Admin")
    public String visitHistory(@PageableDefault(size = 10) Pageable pageable, Model model,
                               @RequestParam String company,
                               @RequestParam String beginDate,
                               @RequestParam String endDate,
                               HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, new VisitQuery(company, beginDate, endDate), session));
        return "function/visitHistory_Admin";
    }

    @GetMapping("/manageUser_Admin")
    public String manageUser_AdminPage(@PageableDefault(size = 10) Pageable pageable, Model model, UserQuery userQuery) {
        model.addAttribute("page_user", userService.filterUser(pageable, userQuery));
        return "function/manageUser_Admin";
    }

    @PostMapping("/manageUser_Admin")
    public String manageUser_Admin(@PageableDefault(size = 10, sort = {"username"},direction = Sort.Direction.ASC) Pageable pageable, Model model,
                                   @RequestParam String username,
                                   @RequestParam String status) {
        model.addAttribute("page_user", userService.filterUser(pageable, new UserQuery(username, status)));
        return "function/manageUser_Admin";
    }

    @GetMapping("/manageCompany_Admin")
    public String manageCompany_AdminPage(@PageableDefault(size = 10) Pageable pageable, Model model, CompanyQuery companyQuery) {
        model.addAttribute("page_company", companyService.filterCompany(pageable, companyQuery));
        return "function/manageCompany_Admin";
    }

    @PostMapping("/manageCompany_Admin")
    public String manageCompany_Admin(@PageableDefault(size = 10, sort = {"name"},direction = Sort.Direction.ASC) Pageable pageable, Model model,
                                      @RequestParam String name,
                                      @RequestParam String city_min,
                                      @RequestParam String city_max,
                                      @RequestParam String theater_min,
                                      @RequestParam String theater_max,
                                      @RequestParam String employee_min,
                                      @RequestParam String employee_max) {
        model.addAttribute("page_company", companyService.filterCompany(pageable, new CompanyQuery(name, city_min, city_max, theater_min, theater_max, employee_min, employee_max)));
        return "function/manageCompany_Admin";
    }
}
