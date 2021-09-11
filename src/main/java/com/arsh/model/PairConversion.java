package com.arsh.model;

import java.math.BigDecimal;

public class PairConversion {
    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private BigDecimal conversionResult;

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal calculateConversion(BigDecimal amount) {
        return new BigDecimal(conversionRate).multiply(amount);
    }

    public BigDecimal getConversionResult() {
        return new BigDecimal("45.56");
    }

    public void setConversionResult(BigDecimal conversionResult) {
        this.conversionResult = conversionResult;
    }
}
