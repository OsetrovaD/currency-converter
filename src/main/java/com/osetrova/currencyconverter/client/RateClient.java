package com.osetrova.currencyconverter.client;

import com.osetrova.currencyconverter.model.Rate;
import feign.Param;
import feign.RequestLine;

public interface RateClient {

    @RequestLine("GET /{abbreviation}?ParamMode=2")
    Rate findByAbbreviation(@Param("abbreviation") String abbreviation);
}
