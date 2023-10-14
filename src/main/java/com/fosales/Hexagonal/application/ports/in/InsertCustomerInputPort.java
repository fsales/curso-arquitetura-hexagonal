package com.fosales.Hexagonal.application.ports.in;

import com.fosales.Hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(
            Customer customer,
            String zipCode
    );
}
