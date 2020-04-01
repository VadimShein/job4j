package ru.job4j.tracker;

//import java.util.Scanner;

public class StartUI {

    public static boolean run = true;

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Added: " + item.getName() + " " + item.getId());
    }
    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] findAll = tracker.findAll();
        if (findAll.length != 0) {
            for (int index = 0; index < findAll.length; index++) {
                System.out.println("Find value: " + findAll[index].getName() + " " + findAll[index].getId());
            }
        } else {
            System.out.println("Value not found");
        }
    }
    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter id: ");
        Item newItem = new Item(input.askStr("Enter name: "));
        if (tracker.replace(id, newItem)) {
            System.out.println("performed");
        } else {
            System.out.println("not performed");
        }
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("performed");
        } else {
            System.out.println("not performed");
        }
    }
    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr("Enter id: ");
        Item findById =  tracker.findById(id);
        if (findById != null) {
            System.out.println("Find value: " + findById.getName() + " " + findById.getId());
        } else {
            System.out.println("Value not found");
        }
    }
    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] findByName = tracker.findByName(name);
        if (findByName.length != 0) {
            for (int index = 0; index < findByName.length; index++) {
                System.out.println("Find value: " + findByName[index].getName() + " " + findByName[index].getId());
            }
        } else {
            System.out.println("Value not found");
        }
    }
    public static void exitProgram(Input input, Tracker tracker) {
        System.out.println("=== Exit Program ====");
        run = false;
    }

    public void init(Input input, Tracker tracker) {
        while (run) {
            System.out.println();
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                StartUI.exitProgram(input, tracker);
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}