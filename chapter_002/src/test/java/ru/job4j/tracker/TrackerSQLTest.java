package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Bug"));
            assertThat(tracker.findByName("Bug").size(), is(1));
        }
    }

    @Test
    public void replaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item("Bug");
            Item newBug = new Item("newBug");
            tracker.add(bug);
            tracker.replace(bug.getId(), newBug);
            assertThat(tracker.findByName("newBug").size(), is(1));
            assertThat(tracker.findByName("Bug").size(), is(0));
        }
    }
    @Test
    public void whenReplaceItemFalse() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item("Bug");
            Item newBug = new Item("newBug");
            tracker.add(bug);
            tracker.replace(bug.getId() + 100, newBug);
            assertThat(tracker.findByName("newBug").size(), is(0));
            assertThat(tracker.findByName("Bug").size(), is(1));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item("Bug");
            tracker.add(bug);
            tracker.delete(bug.getId());
            assertThat(tracker.findByName("Bug").size(), is(0));
        }
    }
    @Test
    public void whenDeleteItemFalse() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item("Bug");
            tracker.add(bug);
            tracker.delete(bug.getId() + 100);
            assertThat(tracker.findByName("Bug").size(), is(1));
        }
    }

    @Test
    public void findAllItems() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Bug_1"));
            tracker.add(new Item("Bug_2"));
            assertThat(tracker.findAll().size(), is(2));
        }
    }

    @Test
    public void findByNameItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Bug"));
            assertThat(tracker.findByName("Bug").size(), is(1));
        }
    }
    @Test
    public void whenFindByNameItemFalse() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Bug"));
            assertThat(tracker.findByName("LostBug").size(), is(0));
        }
    }

    @Test
    public void findByIdItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item("Bug");
            tracker.add(bug);
            assertThat(tracker.findById(bug.getId()).getId(), is(bug.getId()));
        }
    }
    @Test
    public void whenFindByIdItemFalse() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item("Bug");
            tracker.add(bug);
            Assert.assertNull(tracker.findById("111"));
        }
    }

}
