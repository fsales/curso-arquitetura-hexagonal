package com.fosales.Hexagonal.config;

import com.fosales.Hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.fosales.Hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.fosales.Hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {

        return new DeleteCustomerByIdUseCase(
                findCustomerByIdUseCase,
                deleteCustomerByIdAdapter
        );
    }
}
