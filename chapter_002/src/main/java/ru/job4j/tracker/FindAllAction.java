package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    @Override
    public String name() {

        return "=== Find all items ====";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        List<Item> findAll = tracker.findAll();
        if (findAll.size() != 0) {
            for (int index = 0; index < findAll.size(); index++) {
                System.out.println("Find value: " + findAll.get(index).getName()
                        + " " + findAll.get(index).getId());
            }
        } else {
            System.out.println("Value not found");
        }
        return true;
    }
}
