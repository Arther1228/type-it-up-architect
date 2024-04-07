package com.yang.regular.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPPortTest {
    public static void main(String[] args) {

        String url = "http://192.168.0.1:8080";
        Pattern pattern = Pattern.compile("http://(\\d+\\.\\d+\\.\\d+\\.\\d+):(\\d+)/?");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String ip = matcher.group(1);
            String port = matcher.group(2);
            System.out.println("IP: " + ip);
            System.out.println("Port: " + port);
        }
    }
}
