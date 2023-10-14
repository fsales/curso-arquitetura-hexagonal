package com.fosales.Hexagonal.adapters.in.consumer;

import com.fosales.Hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.fosales.Hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.fosales.Hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(
                customer,
                customerMessage.getZipCode()
        );
    }
}
