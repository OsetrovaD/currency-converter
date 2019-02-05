package com.osetrova.currencyconverter.service;

import com.osetrova.currencyconverter.model.ConversionResult;
import com.osetrova.currencyconverter.model.Rate;
import com.osetrova.currencyconverter.util.CurrencyConversionUtil;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {

    public ConversionResult convert(Rate from, Rate to, Double amount) {
        return ConversionResult.builder()
                .resultAmount(CurrencyConversionUtil.convert(from, to, amount).doubleValue())
                .currencyAbbreviation(to.getCur_Abbreviation())
                .build();
    }
}
