package com.fosales.Hexagonal.config;

import com.fosales.Hexagonal.adapters.out.FindAddressByZipCodeAdpter;
import com.fosales.Hexagonal.adapters.out.UpdateCustomerAdapter;
import com.fosales.Hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.fosales.Hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustumerConfig {

    @Bean
    public UpdateCustomerUseCase UpdateCustumerUseCase(
            FindCustomerByIdUseCase findCustomerByIdAdapter,
            FindAddressByZipCodeAdpter findAddressByZipCodeAdpter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {

        return new UpdateCustomerUseCase(
                findCustomerByIdAdapter,
                findAddressByZipCodeAdpter,
                updateCustomerAdapter

        );
    }
}
