package com.liukedun.okex.fundingratecalculator;

import com.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.okcoin.commons.okex.open.api.service.GeneralAPIService;
import com.okcoin.commons.okex.open.api.service.futures.impl.GeneralAPIServiceImpl;
import com.okcoin.commons.okex.open.api.service.swap.SwapMarketAPIService;
import com.okcoin.commons.okex.open.api.service.swap.impl.SwapMarketAPIServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Covey Liu, covey@liukedun.com
 * Date: 2/27/2020 2:50 PM
 */
@Configuration
public class Config {

    @Value("${endpoint}")
    private String endpoint;

    @Value("${apiKey}")
    private String apiKey;

    @Value("${secretKey}")
    private String secretKey;

    @Value("${passphrase}")
    private String passphrase;

    @Value("${print:true}")
    private boolean print;

    @Bean
    public APIConfiguration OkexApiConfig() {
        APIConfiguration config = new APIConfiguration();
        config.setEndpoint(endpoint);
        config.setApiKey(apiKey);
        config.setSecretKey(secretKey);
        config.setPassphrase(passphrase);
        config.setPrint(print);
        return config;
    }

    @Bean
    public GeneralAPIService generalAPIService(APIConfiguration config) {
        return new GeneralAPIServiceImpl(config);
    }

    @Bean
    public SwapMarketAPIService swapMarketAPIService(APIConfiguration config) {
        return new SwapMarketAPIServiceImpl(config);
    }

}
