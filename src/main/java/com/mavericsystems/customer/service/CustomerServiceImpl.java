package com.mavericsystems.customer.service;


import com.mavericsystems.customer.model.Customer;
import com.mavericsystems.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        Integer customerId = customer.getCustomerId();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Integer> httpEntity = new HttpEntity<>(customerId,header);
        Integer accId = restTemplate.postForObject("http://account/AccountCreation/addAccount",httpEntity,Integer.class);
        customer.setAccId(accId);
        if(accId!=null) {
            customer.setIsAccountCreated(true);
        }
        else customer.setIsAccountCreated(false);
       return customerRepo.save(new Customer(customer.getCustomerName(),customer.getCustomerId(),customer.getPhoneNumber(),customer.getIsAccountCreated(),customer.getAccId()));

    }




    @Override
    public Customer getCostumerDetails(Integer customerId) {
        Optional<Customer> customerData = customerRepo.findByCustomerId(customerId);
        if(customerData.isPresent()) {
            return customerData.get();
        }
        else return null;

    }


}
