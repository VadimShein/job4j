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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item replace(String id, Item item) {
        int index = indexOf(id);
        items[index].setName(item.getName());
        return items[index];
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        items[index].setName(null);
        items[index].setId(null);
        System.arraycopy(items, index + 1, items, index, position - index);
        items[position - 1] = null;
        position--;
        return true;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}