package com.fosales.Hexagonal.adapters.in.controller;

import com.fosales.Hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.fosales.Hexagonal.adapters.in.controller.request.CustomerRequest;
import com.fosales.Hexagonal.adapters.in.controller.response.CustomerResponse;
import com.fosales.Hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.fosales.Hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.fosales.Hexagonal.application.ports.in.InsertCustomerInputPort;
import com.fosales.Hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(
            @RequestBody @Valid final CustomerRequest request
    ) {
        var customer = customerMapper.toCustomer(request);
        insertCustomerInputPort.insert(
                customer,
                request.zipCode()
        );
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("id") final String id
    ) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity
                .ok()
                .body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable("id") final String id,
            @RequestBody @Valid final CustomerRequest request
    ) {
        var customer = customerMapper.toCustomer(request);
        customer.setId(id);

        updateCustomerInputPort.update(
                customer,
                request.zipCode()
        );

        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") final String id
    ) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
