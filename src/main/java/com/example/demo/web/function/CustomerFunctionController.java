package com.example.demo.web.function;

import com.example.demo.po.Creditcard;
import com.example.demo.po.User;
import com.example.demo.service.*;
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
public class CustomerFunctionController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private CreditcardService creditcardService;

    @Autowired
    private UsedService usedService;

    @GetMapping("customerFunctionality")
    public String userFunc() {
        return "function/customerFunctionality";
    }

    @GetMapping("/exploreTheater_Customer")
    public String exploreTheaterPage(@PageableDefault(size = 10) Pageable pageable, Model model, TheaterQuery theaterQuery) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, theaterQuery));
        return "function/exploreTheater_Customer";
    }

    @PostMapping("/exploreTheater_Customer")
    public String exploreTheater(@PageableDefault(size = 10) Pageable pageable, Model model,
                                 @RequestParam String theater,
                                 @RequestParam String company,
                                 @RequestParam String city,
                                 @RequestParam String state) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page_theater", theaterService.listTheater(pageable));
        model.addAttribute("page", theaterService.filterTheater(pageable, new TheaterQuery(company, theater, city, state)));
        return "function/exploreTheater_Customer";
    }

    @GetMapping("/visitHistory_Customer")
    public String visitHistoryPage(@PageableDefault(size = 10) Pageable pageable, Model model, VisitQuery visitQuery, HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, visitQuery, session));
        return "function/visitHistory_Customer";
    }

    @PostMapping("/visitHistory_Customer")
    public String visitHistory(@PageableDefault(size = 10) Pageable pageable, Model model,
                               @RequestParam String company,
                               @RequestParam String beginDate,
                               @RequestParam String endDate,
                               HttpSession session) {
        model.addAttribute("page_company", companyService.listCompany(pageable));
        model.addAttribute("page", visitService.filterVisit(pageable, new VisitQuery(company, beginDate, endDate), session));
        return "function/visitHistory_Customer";
    }

    @GetMapping("addCreditcard_Customer")
    public String addCreditcard_CustomerPage() {
        return "function/addCreditcard_Customer";
    }

    @PostMapping("addCreditcard_Customer")
    public String addCreditcard_Customer(@RequestParam String creditcardnum,
                                         RedirectAttributes attributes,
                                         HttpSession session) {
        Creditcard creditcard = creditcardService.checkCreditcardnum(creditcardnum);
        if (creditcard != null) {
            attributes.addFlashAttribute("message", "Creditcard Number already existed");
            return "redirect:addCreditcard_Customer";
        }
        User user = (User) session.getAttribute("user");
        int num = creditcardService.findNumberOfCreditcard(user.getUsername());
        if (num >= 5) {
            attributes.addFlashAttribute("message", "Each customer can only have 5 creditcard at most.");
            return "redirect:addCreditcard_Customer";
        }
        creditcardService.saveCreditcard(creditcardnum, user.getUsername());
        attributes.addFlashAttribute("message", "Creditcard added successfully.");
        return "redirect:addCreditcard_Customer";
    }

    @GetMapping("viewHistory_Customer")
    public String viewHistory_Customer(@PageableDefault(size = 10) Pageable pageable, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        model.addAttribute("page", usedService.filterUsed(pageable, username));
        return "function/viewHistory_Customer";
    }

    @PostMapping("/logVisit_Customer")
    public String logVisit_User(@PageableDefault(size = 10) Pageable pageable, Model model, TheaterQuery theaterQuery,
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
            return "redirect:exploreTheater_Customer";

        User user = (User) session.getAttribute("user");
        assert user != null;
        visitService.saveVisit(visitdate, user.getUsername(), visit_theatername, visit_companyname);
        attributes.addFlashAttribute("message", "Visit record logged successfully.");
        return "redirect:exploreTheater_Customer";
    }
}
