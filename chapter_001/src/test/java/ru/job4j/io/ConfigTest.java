package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/configOne.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key"), is("value"));
        assertThat(config.value("key2"), is("value2"));
        assertThat(config.value("key3"), is("value3"));
    }

    @Test
    public void whenComment() {
        String path = "./data/configOne.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key4"), is(nullValue()));
    }

    @Test
    public void whenEmpty() {
        String path = "./data/configTwo.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key"), is(nullValue()));
    }


}
