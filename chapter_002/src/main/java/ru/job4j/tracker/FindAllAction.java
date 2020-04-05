package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {

        return "=== Find all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] findAll = tracker.findAll();
        if (findAll.length != 0) {
            for (int index = 0; index < findAll.length; index++) {
                System.out.println("Find value: " + findAll[index].getName() + " " + findAll[index].getId());
            }
        } else {
            System.out.println("Value not found");
        }
        return true;
    }
}
