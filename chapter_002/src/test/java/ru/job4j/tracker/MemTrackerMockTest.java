package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MemTrackerMockTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void whenReplaceActionTrue() {
        Store tracker = new MemTracker();
        Item addedItem = tracker.add(new Item("item"));
        String replacedName = "New item name";
        UserAction action = new ReplaceAction();

        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn(addedItem.getId());
        when(input.askStr("Enter name: ")).thenReturn(replacedName);

        System.setOut(new PrintStream(this.out));
        System.out.println(action.name());
        action.execute(input, tracker);
        System.setOut(System.out);

        String result = tracker.findByName(replacedName).get(0).getName();
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ====" + ln + "performed" + ln));
        assertThat(result, is(replacedName));
    }

    @Test
    public void whenDeleteActionTrue() {
        Store tracker = new MemTracker();
        Item addedItem = tracker.add(new Item("item"));
        UserAction action = new DeleteAction();

        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn(addedItem.getId());

        System.setOut(new PrintStream(this.out));
        System.out.println(action.name());
        action.execute(input, tracker);
        System.setOut(System.out);

        int result = tracker.findAll().size();
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ====" + ln + "performed" + ln));
        assertThat(result, is(0));
    }

    @Test
    public void whenDeleteActionFalse() {
        Store tracker = new MemTracker();
        tracker.add(new Item("item"));
        UserAction action = new DeleteAction();

        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn("99");

        System.setOut(new PrintStream(this.out));
        System.out.println(action.name());
        action.execute(input, tracker);
        System.setOut(System.out);

        int result = tracker.findAll().size();
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ====" + ln + "not performed" + ln));
        assertThat(result, is(1));
    }

    @Test
    public void whenFindByIdActionTrue() {
        Store tracker = new MemTracker();
        Item addedItem = tracker.add(new Item("item"));
        UserAction action = new FindByIdAction();

        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn(addedItem.getId());

        System.setOut(new PrintStream(this.out));
        System.out.println(action.name());
        action.execute(input, tracker);
        System.setOut(System.out);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by Id ====" + ln
                + "Find value: item " + addedItem.getId() + ln));
    }

    @Test
    public void whenFindByIdActionFalse() {
        Store tracker = new MemTracker();
        tracker.add(new Item("item"));
        UserAction action = new FindByIdAction();

        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn("99");

        System.setOut(new PrintStream(this.out));
        System.out.println(action.name());
        action.execute(input, tracker);
        System.setOut(System.out);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by Id ====" + ln
               + "Value not found" + ln));
    }

    @Test
    public void whenFindByNameActionTrue() {
        Store tracker = new MemTracker();
        Item addedItem = tracker.add(new Item("item"));
        UserAction action = new FindByNameAction();

        Input input = mock(Input.class);
        when(input.askStr("Enter name: ")).thenReturn("item");

        System.setOut(new PrintStream(this.out));
        System.out.println(action.name());
        action.execute(input, tracker);
        System.setOut(System.out);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln
                + "Find value: item " + addedItem.getId() + ln));
    }

    @Test
    public void whenFindByNameActionFalse() {
        Store tracker = new MemTracker();
        tracker.add(new Item("item"));
        UserAction action = new FindByNameAction();

        Input input = mock(Input.class);
        when(input.askStr("Enter name: ")).thenReturn("99");

        System.setOut(new PrintStream(this.out));
        System.out.println(action.name());
        action.execute(input, tracker);
        System.setOut(System.out);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln
                + "Value not found" + ln));
    }
}
