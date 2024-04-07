package com.yang.design.pattern.demo.strategy;



public interface ZhxqAlarmService {

    /**
     * 定时任务，插入报警信息
     */
    Integer insertAlarm(String type);
}

