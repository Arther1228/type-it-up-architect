package com.yang.design.pattern.demo.flyweight;

import lombok.Getter;

import java.util.List;

@Getter
public class CountryList {
    // 内部状态
    private final List<Country> allCountry;
    // 外部状态
    private List<Country> commonCountry;
    private Country currentCountry;

    // 内部状态，创建对象时设置
    public CountryList(List<Country> allCountry) {
        this.allCountry = allCountry;
    }
    
    public void setCommonCountry(List<Country> commonCountry) {
        this.commonCountry = commonCountry;
    }

    public void setCurrentCountry(Country currentCountry) {
        this.currentCountry = currentCountry;
    }
}