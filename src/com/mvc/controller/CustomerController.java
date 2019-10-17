package com.mvc.controller;

import com.mvc.dao.CustomerDAO;
import com.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // ned to inject the customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        // get and add customers to the model
        model.addAttribute("customers", customerService.getCustomers());
        return "list-customers";
    }
}
