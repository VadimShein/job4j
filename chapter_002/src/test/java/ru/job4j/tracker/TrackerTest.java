package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void idIsFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
    //    assertThat(result.getName(), is(item.getName()));
        assertThat(result.getId(), is(item.getId()));
    }
    @Test
    public void idIsNotFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId() + 1);
        //assertThat(result.getName(), is(item.getName()));
        assertThat(result.getId(), is("null"));
    }
    @Test
    public void nameIsFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
  //      Item item2 = new Item("test1");
  //      tracker.add(item2);
        Item[] result =  tracker.findByName(item.getName());
        assertThat(result[0].getId(), is(item.getId()));
    }
}