package com.example.demo.web.function;

import com.example.demo.service.CompanyService;
import com.example.demo.service.TheaterService;
import com.example.demo.vo.TheaterQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/func")
public class UserFunctionController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private TheaterService theaterService;

    @GetMapping("userFunctionality")
    public String userFunc() {
        return "function/userFunctionality";
    }

    @GetMapping("/exploreTheater")
    public String exploreTheaterPage(@PageableDefault(size = 10) Pageable pageable, Model model, TheaterQuery theaterQuery) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, theaterQuery));
        return "/function/exploreTheater";
    }

    @PostMapping("/exploreTheater")
    public String exploreTheater(@PageableDefault(size = 10) Pageable pageable, Model model,
                                 @RequestParam String theater,
                                 @RequestParam String company,
                                 @RequestParam String city,
                                 @RequestParam String state) {
        TheaterQuery theaterQuery =  new TheaterQuery(company, theater, city, state);
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, new TheaterQuery(company, theater, city, state)));
        return "/function/exploreTheater";
    }

    @GetMapping("visitHistory")
    public String visitHistoryPage(@PageableDefault(size = 10) Pageable pageable, Model model) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, new TheaterQuery("", "", "", "")));
        return "/function/visitHistory";
    }
}
