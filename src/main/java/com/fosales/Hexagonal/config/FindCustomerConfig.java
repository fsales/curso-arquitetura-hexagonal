package com.fosales.Hexagonal.config;

import com.fosales.Hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.fosales.Hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerUseCase(
            FindCustomerByIdAdapter findAddressByZipCodeAdpter
    ) {

        return new FindCustomerByIdUseCase(
                findAddressByZipCodeAdpter
        );
    }
}
