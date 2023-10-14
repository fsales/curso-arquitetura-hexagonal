package com.fosales.Hexagonal.application.ports.in;

public interface DeleteCustomerByIdInputPort {

    void delete(
            String id
    );
}
