package com.yang.design.pattern.demo.flyweight;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author yangliangchuang 2022/12/5 13:09
 */

@SpringBootTest(classes = {CountryListFactory.class, CountryClient.class})
public class CountryListTest {

    @Autowired
    private CountryListFactory countryListFactory;

    @Test
    public void testFactory() {
        final CountryList cl = CountryListFactory.getDefaultCl();
        assertNotNull(cl);
    }
}
