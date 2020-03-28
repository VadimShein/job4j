package ru.job4j.tracker;

import java.util.Random;
import java.util.Arrays;


public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[position];
        int size = 0;
        for (int index =  0; index < position; index++) {
            if (items[index].getName() != null) {
                namesWithoutNull[size++] = items[index];
            }
        }
        return Arrays.copyOf(namesWithoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] foundNames = new Item[position];
        int size = 0;
        for (int index =  0; index < position; index++) {
           if (items[index].getName().equals(key)) {
               foundNames[size++] = items[index];
           }
        }
        return Arrays.copyOf(foundNames, size);
    }

    public Item findById(String id) {
        Item foundId = new Item(null);
        for (int index =  0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                foundId = items[index];
                break;
            }
        }
        return foundId;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}