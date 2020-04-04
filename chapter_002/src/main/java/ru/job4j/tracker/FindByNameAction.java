package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] findByName = tracker.findByName(name);
        if (findByName.length != 0) {
            for (int index = 0; index < findByName.length; index++) {
                System.out.println("Find value: " + findByName[index].getName() + " " + findByName[index].getId());
            }
        } else {
            System.out.println("Value not found");
        }
        return true;
    }
}
