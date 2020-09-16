package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        String id = input.askStr("Enter id: ");
        Item newItem = new Item(input.askStr("Enter name: "));
        if (tracker.replace(id, newItem)) {
            System.out.println("performed");
        } else {
            System.out.println("not performed");
        }
        return true;
    }
}
