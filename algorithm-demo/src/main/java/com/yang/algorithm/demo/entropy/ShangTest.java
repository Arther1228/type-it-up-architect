package com.yang.algorithm.demo.entropy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.hutool.core.util.NumberUtil;

public class ShangTest {

    public static void main(String[] args) {
        List<List<Double>> dataList = readyData();
        ShangFactory shangFactory = new ShangFactory(dataList);
        List<Double> weightList = shangFactory.listWeight();

        // 获取权重
        System.err.println("权重:" + weightList);
        for (Double double1 : weightList) {
            System.out.println(double1);
        }
    }

    private static List<List<Double>> readyData() {
//        String dataStr = "[218.0665, 67.0348, 0.0, 21.8, 27.0], [113.0034, 106.0446, 0.0, 10.8, 5.0], [107.0231, 106.0178, 0.0, 7.7, 3.0], [107.0195, 103.0299, 0.0, 13.3, 5.0], [144.0514, 131.0709, 0.0, 16.4, 9.0], [127.077, 108.0171, 0.0, 15.5, 16.0]";
        String dataStr = "[100.0, 83.33, 75.0], [83.33, 72.86, 70.0], [85.0, 66.0, 64.53, 5.0], [99.0, 55.0, 40.0, 17.17], [75.0, 65.53, 52.18], [70.0, 64.53, 33.0, 23.19], [75.0, 70.53, 28.99], [85.0, 83.33], [75.0, 64.53, 28.13], [75.0, 66.53], [75.0, 57.97], [83.33, 25.0], [100.0], [64.53, 34.38], [66.67, 31.25], [66.67, 25.0], [85.71], [83.33], [83.33], [83.33], [75.0], [75.0], [75.0], [75.0], [71.43], [65.53], [65.53], [64.53], [34.38]";
        List<List<Double>> dataList = new ArrayList<List<Double>>();
        List<String> list = Arrays.asList(dataStr.split("],"));
        List<Double> dataNumList;
        for (String string : list) {
            string = string.replace("[", "");
            string = string.replace("]", "");
            dataNumList = new ArrayList<Double>();
            List<String> numList = Arrays.asList(string.split(","));
            for (String numStr : numList) {
                dataNumList.add(NumberUtil.parseNumber(numStr.trim()).doubleValue());
            }
            dataList.add(dataNumList);
        }
        return dataList;
    }


}