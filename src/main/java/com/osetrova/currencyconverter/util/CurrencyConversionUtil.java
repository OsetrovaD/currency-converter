package com.osetrova.currencyconverter.util;

import com.osetrova.currencyconverter.model.Rate;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@UtilityClass
public class CurrencyConversionUtil {

    public BigDecimal convert(Rate from, Rate to, Double amount) {
        return getCurrenciesRate(from, to).multiply(BigDecimal.valueOf(amount)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCurrenciesRate(Rate from, Rate to) {
        return getAmountForOneRub(from).divide(getAmountForOneRub(to), new MathContext(10, RoundingMode.HALF_UP));
    }

    private BigDecimal getAmountForOneRub(Rate rate) {
        return BigDecimal.valueOf(rate.getCur_OfficialRate()).divide(BigDecimal.valueOf(rate.getCur_Scale()));
    }
}
