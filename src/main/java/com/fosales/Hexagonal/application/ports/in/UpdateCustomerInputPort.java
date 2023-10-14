package com.fosales.Hexagonal.application.ports.in;

import com.fosales.Hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(
            Customer customer,
            String zipCode
    );
}
