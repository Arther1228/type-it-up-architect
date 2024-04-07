package com.yang.design.pattern.demo.flyweight;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangliangchuang 2022/12/5 13:12
 */
@Data
@Component
public class CountryClient {
    private List<Country> countryList;
}
