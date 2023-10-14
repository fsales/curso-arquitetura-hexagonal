package com.fosales.Hexagonal.config;

import com.fosales.Hexagonal.adapters.out.FindAddressByZipCodeAdpter;
import com.fosales.Hexagonal.adapters.out.InsertCustumerAdapter;
import com.fosales.Hexagonal.adapters.out.SendCpfValidationAdapter;
import com.fosales.Hexagonal.application.core.usecase.InsertCustumerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustumerConfig {

    @Bean
    public InsertCustumerUseCase insertCustumerUseCase(
            FindAddressByZipCodeAdpter findAddressByZipCodeAdpter,
            InsertCustumerAdapter insertCustumerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {

        return new InsertCustumerUseCase(
                findAddressByZipCodeAdpter,
                insertCustumerAdapter,
                sendCpfValidationAdapter
        );
    }
}
