package com.fosales.Hexagonal.adapters.in.controller.mapper;

import com.fosales.Hexagonal.adapters.in.controller.request.CustomerRequest;
import com.fosales.Hexagonal.adapters.in.controller.response.CustomerResponse;
import com.fosales.Hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "address", ignore = true)
//    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);
}
