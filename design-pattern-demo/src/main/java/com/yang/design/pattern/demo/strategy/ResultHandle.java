package com.yang.design.pattern.demo.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang
 * @description
 * @date 2020/12/7
 * @desc:不是必须的
 **/

public class ResultHandle {

    private static Map<String, ZhxqAlarmService> mapStrategy = new HashMap<>();

    static {
        mapStrategy.put("1", new ZhxqSjzdAlarmService());
        mapStrategy.put("2", new ZhxqSjycAlarmService());
        mapStrategy.put("3", new ZhxqTpwtAlarmService());
    }

    private StrategyContext strategyContext;

    public Integer handleStrategyContext(String type) {
        strategyContext = new StrategyContext(mapStrategy.get(type));
        return strategyContext.executeStrategy(type);
    }

}
