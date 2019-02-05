package com.osetrova.currencyconverter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rate {

    private Integer Cur_ID;
    private String Cur_Abbreviation;
    private Integer Cur_Scale;
    private Double Cur_OfficialRate;
}
