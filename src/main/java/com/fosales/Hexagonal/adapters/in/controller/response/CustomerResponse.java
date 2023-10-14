package com.fosales.Hexagonal.adapters.in.controller.response;


public record CustomerResponse(
        String name,

        AddressResponse address,

        String cpf,

        Boolean isValidCpf
) {
}
