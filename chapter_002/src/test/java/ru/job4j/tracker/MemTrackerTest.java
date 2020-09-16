package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class MemTrackerTest {
    @Test
    public void idIsFound() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void idIsNotFound() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId() + 100);
        Assert.assertNull(result);
    }
    @Test
    public void nameIsFound() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item item2 = new Item("test1");
        tracker.add(item2);
        List<Item> result = tracker.findByName(item.getName());
        assertThat(result.get(0).getName(), is(item.getName()));
        assertThat(result.get(1).getName(), is(item2.getName()));
    }
    @Test
    public void nameIsNotFound() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item item2 = new Item("test1");
        tracker.add(item2);
        List<Item> result = tracker.findByName("test3");
        assertThat(result.size(), is(0));
    }
    @Test
    public void findAll() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item item2 = new Item("test2");
        tracker.add(item2);
        List<Item> result = tracker.findAll();
        assertThat(result.get(0).getName(), is(item.getName()));
        assertThat(result.get(1).getName(), is(item2.getName()));
    }
    @Test
    public void notFindAll() {
        MemTracker tracker = new MemTracker();
        List<Item> result = tracker.findAll();
        assertThat(result.size(), is(0));
    }
    @Test
    public void whenReplaceTrue() {
        boolean rsl;
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        rsl = tracker.replace(id, bugWithDesc);
        assertThat(rsl, is(true));
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }
    @Test
    public void whenReplaceFalse() {
        boolean rsl;
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        rsl = tracker.replace(id + 100, bugWithDesc);
        assertThat(rsl, is(false));
        assertThat(tracker.findById(id).getName(), is("Bug"));
    }
    @Test
    public void whenDeleteTrue() {
        boolean rsl;
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        rsl = tracker.delete(id);
        assertThat(rsl, is(true));
        assertThat(tracker.findById(id), is(nullValue()));
    }
    @Test
    public void whenDeleteFalse() {
        boolean rsl;
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        rsl = tracker.delete(id + 100);
        assertThat(rsl, is(false));
        assertThat(tracker.findById(id).getId(), is(bug.getId()));
    }

    @Test
    public void sortByAscending() {
        MemTracker tracker = new MemTracker();
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("test2"));
        items.add(new Item("test1"));
        items.add(new Item("test3"));

        for (Item value : items) {
            tracker.add(value);
        }
        
        Collections.sort(items);
        System.out.println(items);
        assertThat(items.get(0).getName(), is("test1"));
        assertThat(items.get(1).getName(), is("test2"));
        assertThat(items.get(2).getName(), is("test3"));
    }

    @Test
    public void sortByDescending() {
        MemTracker tracker = new MemTracker();
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("test2"));
        items.add(new Item("test1"));
        items.add(new Item("test3"));

        for (Item value : items) {
            tracker.add(value);
        }

        Collections.sort(items, Collections.reverseOrder());
        System.out.println(items);
        assertThat(items.get(0).getName(), is("test3"));
        assertThat(items.get(1).getName(), is("test2"));
        assertThat(items.get(2).getName(), is("test1"));
    }
}