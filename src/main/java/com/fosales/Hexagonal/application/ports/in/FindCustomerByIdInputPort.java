package com.fosales.Hexagonal.application.ports.in;

import com.fosales.Hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(final String id);
}
