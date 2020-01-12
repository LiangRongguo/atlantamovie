package com.example.demo.web.function;

import com.example.demo.po.Movie;
import com.example.demo.po.MoviePlay;
import com.example.demo.po.Theater;
import com.example.demo.po.User;
import com.example.demo.service.*;
import com.example.demo.vo.MoviePlayQuery;
import com.example.demo.vo.TheaterQuery;
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
public class ManagerFunctionController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MoviePlayService moviePlayService;

    @GetMapping("managerFunctionality")
    public String managerFunc() {
        return "function/managerFunctionality";
    }

    @GetMapping("/exploreTheater_Manager")
    public String exploreTheaterPage(@PageableDefault(size = 100) Pageable pageable, Model model, TheaterQuery theaterQuery) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, theaterQuery));
        return "function/exploreTheater_Manager";
    }

    @PostMapping("/exploreTheater_Manager")
    public String exploreTheater(@PageableDefault(size = 100) Pageable pageable, Model model,
                                 @RequestParam String theater,
                                 @RequestParam String company,
                                 @RequestParam String city,
                                 @RequestParam String state) {
        TheaterQuery theaterQuery =  new TheaterQuery(company, theater, city, state);
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, new TheaterQuery(company, theater, city, state)));
        return "function/exploreTheater_Manager";
    }

    @GetMapping("/visitHistory_Manager")
    public String visitHistoryPage(@PageableDefault(size = 100) Pageable pageable, Model model, VisitQuery visitQuery, HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, visitQuery, session));
        return "function/visitHistory_Manager";
    }

    @PostMapping("/visitHistory_Manager")
    public String visitHistory(@PageableDefault(size = 100) Pageable pageable, Model model,
                               @RequestParam String company,
                               @RequestParam String beginDate,
                               @RequestParam String endDate,
                               HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, new VisitQuery(company, beginDate, endDate), session));
        return "function/visitHistory_Manager";
    }

    @GetMapping("/theaterOverview_Manager")
    public String theaterOverviewPage(@PageableDefault(size = 100) Pageable pageable, Model model, MoviePlayQuery moviePlayQuery, HttpSession session) {
        model.addAttribute("page_movieplay", moviePlayService.filterMoviePlay(pageable, moviePlayQuery));
        return "function/theaterOverview_Manager";
    }

    @PostMapping("/theaterOverview_Manager")
    public String theaterOverview(@PageableDefault(size = 100) Pageable pageable, Model model,
                                  @RequestParam String moviename,
                                  @RequestParam String duration_min,
                                  @RequestParam String duration_max,
                                  @RequestParam String release_min,
                                  @RequestParam String release_max,
                                  @RequestParam String playdate_min,
                                  @RequestParam String playdate_max,
                                  HttpSession session
                                  ) {
        User user = (User) session.getAttribute("user");
        Theater theater = theaterService.findByManager(user.getUsername());
        MoviePlayQuery moviePlayQuery = new MoviePlayQuery(moviename, duration_min, duration_max, release_min, release_max, playdate_min ,playdate_max, theater.getCompanyname(), theater.getTheatername());
        model.addAttribute("page_movieplay", moviePlayService.filterMoviePlay(pageable, moviePlayQuery));
        return "function/theaterOverview_Manager";
    }

    @GetMapping("/scheduleMovie_Manager")
    public String scheduleMovie_ManagerPage(@PageableDefault(size = 100) Pageable pageable, Model model) {
        model.addAttribute("page_movie", movieService.listMovie(pageable));
        return "function/scheduleMovie_Manager";
    }

    @PostMapping("/scheduleMovie_Manager")
    public String scheduleMovie_Manager(@PageableDefault(size = 100, sort = {"moviename"},direction = Sort.Direction.ASC) Pageable pageable, Model model,
                                        @RequestParam String moviename,
                                        @RequestParam String releasedate,
                                        @RequestParam String date,
                                        HttpSession session,
                                        RedirectAttributes attributes) {
        // first check if the combination of moviename and releasedate refers to an existed movie
        Movie movie = movieService.findMovie(moviename, releasedate);
        if (movie == null) {
            attributes.addFlashAttribute("message", "Movie not created. Please select an existed combination of movie name and release date.");
            return "redirect:/func/scheduleMovie_Manager";
        }

        // then check whether a valid play date
        if (date.compareTo(releasedate) < 0) {
            attributes.addFlashAttribute("message", "You can not schedule a movie before it is released.");
            return "redirect:/func/scheduleMovie_Manager";
        }

        User user = (User) session.getAttribute("user");
        Theater theater = theaterService.findByManager(user.getUsername());

        MoviePlay moviePlay = moviePlayService.checkMoviePlay(moviename, releasedate, theater.getCompanyname(), theater.getTheatername(), date);
        if (moviePlay != null) {
            attributes.addFlashAttribute("message", "This movie has already been scheduled.");
            return "redirect:/func/scheduleMovie_Manager";
        }

        MoviePlay moviePlay1 = moviePlayService.saveMoviePlay(moviename, releasedate, theater.getCompanyname(), theater.getTheatername(), date);
        attributes.addFlashAttribute("message_success", "Movie scheduled successfully.");
        model.addAttribute("page_movie", movieService.listMovie(pageable));


        return "redirect:/func/scheduleMovie_Manager";
    }

    @PostMapping("/logVisit_Manager")
    public String logVisit_User(@PageableDefault(size = 100) Pageable pageable, Model model, TheaterQuery theaterQuery,
                                @RequestParam String visitdate,
                                @RequestParam String visit_theatername,
                                @RequestParam String visit_companyname,
                                HttpSession session,
                                RedirectAttributes attributes) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, theaterQuery));
        boolean flag = false;
        if ("".equals(visitdate)) {
            attributes.addFlashAttribute("message_date", "Please input visit date(YYYY-MM-DD) to log a visit.");
            flag = true;
        }
        if ("".equals(visit_theatername) || "".equals(visit_companyname)) {
            attributes.addFlashAttribute("message_checkbox", "Please select a theater to log a visit.");
            flag = true;
        }

        if (flag)
            return "redirect:exploreTheater_Manager";

        User user = (User) session.getAttribute("user");
        assert user != null;
        visitService.saveVisit(visitdate, user.getUsername(), visit_theatername, visit_companyname);
        attributes.addFlashAttribute("message", "Visit record logged successfully.");
        return "redirect:exploreTheater_Manager";
    }
}
