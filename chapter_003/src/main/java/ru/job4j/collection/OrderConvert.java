package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order value : orders) {
            map.put(value.getNumber(), value);
            System.out.println(value.getNumber() + " " + value);
        }
        return map;
    }
}