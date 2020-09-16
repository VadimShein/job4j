package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
public String name() {
    return "=== Create a new Item ====";
}

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Added: " + item.getName() + " " + item.getId());
        return true;
    }
}