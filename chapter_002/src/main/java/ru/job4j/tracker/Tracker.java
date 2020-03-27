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

    //получение списка всех заявок
    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[position];
        int size = 0;
        for (int index =  0; index < position; index++) {
            if (items[index].getName() != null) {
                namesWithoutNull[size].setName(items[index].getName());
                namesWithoutNull[size].setId(items[index].getId());
                size++;
            } else {
                namesWithoutNull[index].setName("null");
                namesWithoutNull[index].setId("null");
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        for (int index = 0; index < namesWithoutNull.length; index++) {
            System.out.println("findAll " + namesWithoutNull[index].getName());
        }
        return namesWithoutNull;
    }


     //получение списка по имени
    public Item[] findByName(String key) {
        Item[] foundNames = new Item[position];
        int size = 0;
        for (int index =  0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                foundNames[size].setName(items[index].getName());
                foundNames[size].setId(items[index].getId());
                size++;
            } else {
                foundNames[index].setName("null");
                foundNames[index].setId("null");
            }
        }
        foundNames = Arrays.copyOf(foundNames, size);
        for (int index = 0; index < foundNames.length; index++) {
            System.out.println("findByName " + foundNames[index].getName());
        }
        return foundNames;
    }

    //получение заявки по id
    public Item findById(String id) {
        Item foundId = new Item(null);
        for (int index =  0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                foundId.setName(items[index].getName());
                foundId.setId(items[index].getId());
                System.out.println("findById " + foundId.getName() + " " + foundId.getId());
                break;
            } else {
                foundId.setName("null");
                foundId.setId("null");
            }
        }
        return foundId;
    }

    //Метод генерирует уникальный ключ для заявки.
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}