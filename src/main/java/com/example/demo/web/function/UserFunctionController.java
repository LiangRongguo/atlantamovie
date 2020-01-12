package com.example.demo.web.function;

import com.example.demo.po.User;
import com.example.demo.service.CompanyService;
import com.example.demo.service.TheaterService;
import com.example.demo.service.VisitService;
import com.example.demo.vo.TheaterQuery;
import com.example.demo.vo.VisitQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
public class UserFunctionController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private VisitService visitService;

    @GetMapping("userFunctionality")
    public String userFunc() {
        return "function/userFunctionality";
    }

    @GetMapping("/exploreTheater_User")
    public String exploreTheaterPage(@PageableDefault(size = 100) Pageable pageable, Model model, TheaterQuery theaterQuery) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, theaterQuery));
        return "function/exploreTheater_User";
    }

    @PostMapping("/exploreTheater_User")
    public String exploreTheater(@PageableDefault(size = 100) Pageable pageable, Model model,
                                 @RequestParam String theater,
                                 @RequestParam String company,
                                 @RequestParam String city,
                                 @RequestParam String state) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, new TheaterQuery(company, theater, city, state)));
        return "function/exploreTheater_User";
    }

    @GetMapping("/visitHistory_User")
    public String visitHistoryPage(@PageableDefault(size = 100) Pageable pageable, Model model, VisitQuery visitQuery, HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, visitQuery, session));
        return "function/visitHistory_User";
    }

    @PostMapping("/visitHistory_User")
    public String visitHistory(@PageableDefault(size = 100) Pageable pageable, Model model,
                               @RequestParam String company,
                               @RequestParam String beginDate,
                               @RequestParam String endDate,
                               HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, new VisitQuery(company, beginDate, endDate), session));
        return "function/visitHistory_User";
    }

    @PostMapping("/logVisit_User")
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
            return "redirect:exploreTheater_User";

        User user = (User) session.getAttribute("user");
        assert user != null;
        visitService.saveVisit(visitdate, user.getUsername(), visit_theatername, visit_companyname);
        attributes.addFlashAttribute("message", "Visit record logged successfully.");
        return "redirect:exploreTheater_User";
    }
}
