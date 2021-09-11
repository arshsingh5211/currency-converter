package com.arsh.service;

import com.arsh.model.ExchangeRates;
import org.springframework.web.client.RestTemplate;

public class ExchangeService {

    private String BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public ExchangeService(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public ExchangeRates getExchangeRates(String base) {
        return restTemplate.getForObject(BASE_URL + base, ExchangeRates.class);
    }

}
