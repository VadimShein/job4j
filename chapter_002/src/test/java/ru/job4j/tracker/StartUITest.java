package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"FirstName", "SecondName", "ThirdName"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        for (int i = 0; i < answers.length; i++) {
            StartUI.createItem(input, tracker);
            Item[] created = tracker.findAll();
            assertThat(created[i].getName(), is(answers[i]));
        }
    }
}
