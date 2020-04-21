package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Tracker {

    private final List<Item> items = new ArrayList<Item>();

    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> foundNames = new ArrayList<Item>();
        for (int index =  0; index < items.size(); index++) {
           if (items.get(index).getName().equals(key)) {
               foundNames.add(items.get(index));
           }
        }
        return foundNames;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int rsl = -1;
        int index = indexOf(id);
        if (index != -1) {
            items.set(index, item);
            item.setId(id);
            rsl = index;
        }
        return rsl != -1;
    }

    public boolean delete(String id) {
        int rsl = -1;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rsl = index;
        }
        return rsl != -1;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}