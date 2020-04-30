package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;

public class JobSorterTest {
    @Test
    public void sortAscendByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscendByName());
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(new Job("Fix bug", 1)));
        assertThat(it.next(), is(new Job("Fix bug", 4)));
        assertThat(it.next(), is(new Job("Fix bug", 2)));
        assertThat(it.next(), is(new Job("X task", 0)));
    }

    @Test
    public void sortDescendByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(new Job("X task", 0)));
        assertThat(it.next(), is(new Job("Fix bug", 1)));
        assertThat(it.next(), is(new Job("Fix bug", 4)));
        assertThat(it.next(), is(new Job("Fix bug", 2)));

    }

    @Test
    public void sortAscendByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscendByPriority());
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(new Job("X task", 0)));
        assertThat(it.next(), is(new Job("Fix bug", 1)));
        assertThat(it.next(), is(new Job("Fix bug", 2)));
        assertThat(it.next(), is(new Job("Fix bug", 4)));
    }

    @Test
    public void sortDescendByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDescByPriority());
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(new Job("Fix bug", 4)));
        assertThat(it.next(), is(new Job("Fix bug", 2)));
        assertThat(it.next(), is(new Job("Fix bug", 1)));
        assertThat(it.next(), is(new Job("X task", 0)));
    }

    @Test
    public void sortAscendByNameAndPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscendByName().thenComparing(new JobAscendByPriority()));
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(new Job("Fix bug", 1)));
        assertThat(it.next(), is(new Job("Fix bug", 2)));
        assertThat(it.next(), is(new Job("Fix bug", 4)));
        assertThat(it.next(), is(new Job("X task", 0)));
    }

    @Test
    public void sortAscendByNameAndDescendByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscendByName().thenComparing(new JobDescByPriority()));
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(new Job("Fix bug", 4)));
        assertThat(it.next(), is(new Job("Fix bug", 2)));
        assertThat(it.next(), is(new Job("Fix bug", 1)));
        assertThat(it.next(), is(new Job("X task", 0)));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
