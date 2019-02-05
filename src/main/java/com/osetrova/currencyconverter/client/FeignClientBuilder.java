package com.osetrova.currencyconverter.client;

import feign.Feign;
import feign.gson.GsonDecoder;

public class FeignClientBuilder {

    public static  <T> T getFeignClient(Class<T> type, String uri) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(type, uri);
    }
}
