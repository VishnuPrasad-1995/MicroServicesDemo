package com.mavericsystems.customer.service;

import com.mavericsystems.customer.model.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    public Customer getCostumerDetails(Integer customerId);
}
