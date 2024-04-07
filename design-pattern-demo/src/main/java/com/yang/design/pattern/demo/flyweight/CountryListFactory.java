package com.yang.design.pattern.demo.flyweight;

import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class CountryListFactory {
    private static final String DEFAULT = "DEFAULT";
    private static final Map<String, CountryList> CL_MAP = Maps.newHashMap();

    @Autowired
    private final CountryClient countryClient;

    @PostConstruct
    public void init() {
        final List<Country> countryList = countryClient.getCountryList();
        CL_MAP.put(DEFAULT, new CountryList(countryList));
    }

    public static CountryList getDefaultCl() {
        return CL_MAP.get(DEFAULT);
    }
}