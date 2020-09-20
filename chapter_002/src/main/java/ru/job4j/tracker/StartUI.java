package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            System.out.println();
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            run = actions.get(select).execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

//    public static void main(String[] args) {
//        Input input = new ConsoleInput();
//        Input validate = new ValidateInput(input);
//        try (Store tracker = new SqlTracker()) {
//            tracker.init();
//            UserAction[] actions = {
//                    new CreateAction()
//            };
//            new StartUI().init(validate, tracker, actions);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
////        MemTracker tracker = new MemTracker();
////        List<UserAction> actions =  new ArrayList<UserAction>();
////        actions.add(new CreateAction());
////        actions.add(new FindAllAction());
////        actions.add(new ReplaceAction());
////        actions.add(new DeleteAction());
////        actions.add(new FindByIdAction());
////        actions.add(new FindByNameAction());
////        actions.add(new ExitAction());
//
//       new StartUI().init(validate, tracker, actions);
//    }


    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateAction());
        actions.add(new FindAllAction());
        actions.add(new ReplaceAction());
        actions.add(new DeleteAction());
        actions.add(new FindByIdAction());
        actions.add(new FindByNameAction());
        actions.add(new ExitAction());
            new StartUI().init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}