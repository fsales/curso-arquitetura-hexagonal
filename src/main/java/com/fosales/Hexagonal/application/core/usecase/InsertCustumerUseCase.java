package com.fosales.Hexagonal.application.core.usecase;

import com.fosales.Hexagonal.application.core.domain.Customer;
import com.fosales.Hexagonal.application.ports.in.InsertCustomerInputPort;
import com.fosales.Hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.fosales.Hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.fosales.Hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustumerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustumerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }


    @Override
    public void insert(
            final Customer customer,
            final String zipCode
    ) {
        var address = findAddressByZipCodeOutputPort.find(
                zipCode
        );
        customer.setAddres(
                address
        );
        insertCustomerOutputPort.insert(
                customer
        );

        sendCpfForValidationOutputPort.send(
                customer.getCpf()
        );
    }
}
