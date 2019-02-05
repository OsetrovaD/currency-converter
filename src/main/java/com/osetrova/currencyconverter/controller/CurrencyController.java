package com.osetrova.currencyconverter.controller;

import com.osetrova.currencyconverter.client.FeignClientBuilder;
import com.osetrova.currencyconverter.client.RateClient;
import com.osetrova.currencyconverter.model.ConversionInfo;
import com.osetrova.currencyconverter.model.ConversionResult;
import com.osetrova.currencyconverter.model.Rate;
import com.osetrova.currencyconverter.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    private CurrencyConversionService service;
    private RateClient client = FeignClientBuilder.getFeignClient(RateClient.class, "http://www.nbrb.by/API/ExRates/Rates");

    @Autowired
    public CurrencyController(CurrencyConversionService service) {
        this.service = service;
    }

    @PostMapping(value = "/convert", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ConversionResult convert(@RequestBody ConversionInfo info) {
        return service.convert(getRate(info.getFrom()), getRate(info.getTo()), info.getAmount());
    }

    private Rate getRate(String abbreviation) {
        return client.findByAbbreviation(abbreviation);
    }
}
