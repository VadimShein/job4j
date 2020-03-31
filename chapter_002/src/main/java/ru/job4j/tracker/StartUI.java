package ru.job4j.tracker;

//import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            System.out.println();
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Added: " + item.getName() + " " + item.getId());
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                if (tracker.findAll().length != 0) {
                    for (int index = 0; index < tracker.findAll().length; index++) {
                        System.out.println("Find value: " + tracker.findAll()[index].getName() + " " + tracker.findAll()[index].getId());
                    }
                } else {
                    System.out.println("Value not found");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                String id = input.askStr("Enter id: ");
                System.out.print("Enter name: ");
                Item newItem = new Item(input.askStr("Enter name: "));
                if (tracker.replace(id, newItem)) {
                    System.out.println("performed");
                } else {
                    System.out.println("not performed");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                String id = input.askStr("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("performed");
                } else {
                    System.out.println("not performed");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter id: ");
                String id = input.askStr("Enter id: ");
                if (tracker.findById(id) != null) {
                    System.out.println("Find value: " + tracker.findById(id).getName() + " " + tracker.findById(id).getId());
                } else {
                    System.out.println("Value not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = input.askStr("Enter name: ");
                if (tracker.findByName(name).length != 0) {
                    for (int index = 0; index < tracker.findByName(name).length; index++) {
                        System.out.println("Find value: " + tracker.findByName(name)[index].getName() + " " + tracker.findByName(name)[index].getId());
                    }
                } else {
                    System.out.println("Value not found");
                }
            } else if (select == 6) {
                System.out.println("=== Exit Program ====");
                run = false;
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