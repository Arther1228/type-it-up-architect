package com.yang.algorithm.demo.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeMapExample {

    public static void main(String[] args) {
        // 示例HashMap
        HashMap<String, Integer> timeMap = new HashMap<>();

        timeMap.put("2023-12-14 06:30:00", 4);
        timeMap.put("2023-12-14 07:00:00", 4);
        timeMap.put("2023-12-14 11:30:00", 4);
        timeMap.put("2023-12-14 08:00:00", 4);
//        timeMap.put("2023-12-14 08:30:00", 4);
//        timeMap.put("2023-12-14 09:00:00", 4);
//        timeMap.put("2023-12-14 09:30:00", 4);

        timeMap.put("2023-12-14 03:00:00", 1);
        timeMap.put("2023-12-14 03:30:00", 2);
        timeMap.put("2023-12-14 04:00:00", 2);
//        timeMap.put("2023-12-14 04:30:00", 3);
        timeMap.put("2023-12-14 05:00:00", 3);

        timeMap.put("2023-12-14 10:00:00", 4);
        timeMap.put("2023-12-14 10:30:00", 4);

        int maxConsecutiveHalfHour = calculateMaxConsecutiveHalfHour(timeMap);

        System.out.println("最长连续半小时时长为: " + maxConsecutiveHalfHour);
    }

    private static int calculateMaxConsecutiveHalfHour(HashMap<String, Integer> timeMap) {
        // 将HashMap按照时间戳升序排序
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(timeMap.entrySet());
        sortedEntries.sort(Comparator.comparing(entry -> entry.getKey()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 初始化开始时间和最大时长
        int maxConsecutiveHalfHour = 0;
        int consecutiveHalfHour = 1;
        long currentTimestamp = 0;
        boolean firstIteration = true;

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            try {
                long timestamp = sdf.parse(entry.getKey()).getTime();

                if (firstIteration) {
                    // 第一次迭代，初始化当前时间戳
                    currentTimestamp = timestamp;
                    firstIteration = false;
                } else {
                    // 检查时间戳是否连续
                    if (timestamp == currentTimestamp + 30 * 60 * 1000) {
                        consecutiveHalfHour++;
                    } else {
                        // 不连续时更新最大时长
                        maxConsecutiveHalfHour = Math.max(maxConsecutiveHalfHour, consecutiveHalfHour);
                        consecutiveHalfHour = 1; // 重新开始计数
                    }

                    currentTimestamp = timestamp;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // 处理最后一段时长
        maxConsecutiveHalfHour = Math.max(maxConsecutiveHalfHour, consecutiveHalfHour);

        return maxConsecutiveHalfHour;
    }
}
