package com.moto.spring_demo.controller.web;

import com.moto.spring_demo.domain.Company;
import com.moto.spring_demo.domain.User;
import com.moto.spring_demo.repository.CompanyRepository;
import com.moto.spring_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class CompanyWebController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/company/index")
    public String index(Model model){

        model.addAttribute("allCompanies", companyRepository.findAll());
        return "company/index";
    }

    @GetMapping("/company/create")
    public String createCompany(Model model) {

        model.addAttribute("company", new Company());
        return "company/create";
    }

    @PostMapping("/company/save")
    public String saveCompany(@ModelAttribute Company company) {

        companyRepository.save(company);
        return "redirect:/company/index";
    }

    @GetMapping("company/adduser")
    public String addUserToCompany(Model model){

        return "company/add_user_to_company";
    }
}
