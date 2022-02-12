package com.mavericsystems.customer.controller;

import com.mavericsystems.customer.model.Customer;
import com.mavericsystems.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CustomerCreation")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }



   @GetMapping("/customerdetails/{id}")
    public Customer getCustomerDetails(@PathVariable("id") Integer id){
        return customerService.getCostumerDetails(id);
   }
}
