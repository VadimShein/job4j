package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void idIsFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void idIsNotFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId() + 100);
        Assert.assertNull(result.getName());
    }
    @Test
    public void nameIsFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item item2 = new Item("test1");
        tracker.add(item2);
        Item[] result = tracker.findByName(item.getName());
        assertThat(result[0].getName(), is(item.getName()));
        assertThat(result[1].getName(), is(item2.getName()));
    }
    @Test
    public void nameIsNotFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item item2 = new Item("test1");
        tracker.add(item2);
        Item[] result = tracker.findByName("test3");
        assertThat(result.length, is(0));
    }
    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item item2 = new Item("test2");
        tracker.add(item2);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is(item.getName()));
        assertThat(result[1].getName(), is(item2.getName()));
    }
    @Test
    public void notFindAll() {
        Tracker tracker = new Tracker();
        Item[] result = tracker.findAll();
        assertThat(result.length, is(0));
    }
}