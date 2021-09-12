package com.arsh.model;

import java.util.Map;

public class ExchangeRates {
    private String base;
    private String date;
    private String timeLastUpdated;
    private Map<String, Double> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeLastUpdated() {
        return timeLastUpdated;
    }

    public void setTimeLastUpdated(String timeLastUpdated) {
        this.timeLastUpdated = timeLastUpdated;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
