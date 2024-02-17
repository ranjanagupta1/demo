package com.basic.demo.controllers.customers;


import com.basic.demo.DTO.Cust;
import com.basic.demo.services.customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class Customer {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Cust getCustomer(@PathVariable("id") Integer id) {
        return customerService.findById(id);
    }

    @GetMapping()
    public List<Cust> getAllCustomers(@RequestParam(value = "limit", required = false) Integer limit) {
        if (limit != null)
            return customerService.listCustomers(limit);
        return customerService.listCustomers();
    }


}
