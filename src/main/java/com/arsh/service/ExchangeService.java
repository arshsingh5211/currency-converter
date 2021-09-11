package com.arsh.service;

import com.arsh.model.ExchangeRates;
import com.arsh.model.PairConversion;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class ExchangeService {

    private String BASE_URL;
    private String PAIR_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public ExchangeService(String BASE_URL, String PAIR_URL) {
        this.BASE_URL = BASE_URL;
        this.PAIR_URL = PAIR_URL;
    }

    public ExchangeRates getExchangeRates(String base) {
        return restTemplate.getForObject(BASE_URL + base, ExchangeRates.class);
    }

    public PairConversion getPairConversion(String baseCode, String targetCode, BigDecimal amount) {
        return restTemplate.getForObject(PAIR_URL + baseCode + "/" + targetCode + "/" + amount, PairConversion.class);
    }

}
