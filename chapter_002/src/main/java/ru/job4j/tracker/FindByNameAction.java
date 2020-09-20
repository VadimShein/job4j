package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> findByName = tracker.findByName(name);
        if (findByName.size() != 0) {
            for (int index = 0; index < findByName.size(); index++) {
                System.out.println("Find value: " + findByName.get(index).getName()
                        + " " + findByName.get(index).getId());
            }
        } else {
            System.out.println("Value not found");
        }
        return true;
    }
}
