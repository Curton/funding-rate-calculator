package com.liukedun.okex.fundingratecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FundingRateCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundingRateCalculatorApplication.class, args);
    }

}
