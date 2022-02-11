package com.mavericsystems.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String customerName;
    private Integer customerId;
    private Integer phoneNumber;
    private Boolean isAccountCreated;
    private Integer accId;

    public Customer(String customerName, Integer customerId, Integer phoneNumber, Boolean isAccountCreated, Integer accId) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.isAccountCreated = isAccountCreated;
        this.accId = accId;
    }
}
