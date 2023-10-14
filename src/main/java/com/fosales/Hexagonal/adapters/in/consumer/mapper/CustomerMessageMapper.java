package com.fosales.Hexagonal.adapters.in.consumer.mapper;

import com.fosales.Hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.fosales.Hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    //@Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
