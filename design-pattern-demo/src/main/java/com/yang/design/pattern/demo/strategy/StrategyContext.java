package com.yang.design.pattern.demo.strategy;


/**
 * @author wang
 * @description
 * @date 2020/12/7
 **/

public class StrategyContext {

    private ZhxqAlarmService zhxqAlarmService;

    public StrategyContext(ZhxqAlarmService zhxqAlarmService) {
        this.zhxqAlarmService = zhxqAlarmService;
    }

    public Integer executeStrategy(String type) {
        return zhxqAlarmService.insertAlarm(type);
    }

}
