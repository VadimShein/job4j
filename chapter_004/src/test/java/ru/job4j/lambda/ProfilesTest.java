package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void addressList() {
        Address adr1 = new Address("city1", "street1", 11, 1);
        Address adr2 = new Address("city2", "street2", 22, 2);
        Address adr3 = new Address("city2", "street2", 22, 2);

        List<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile(adr3));
        profileList.add(new Profile(adr2));
        profileList.add(new Profile(adr1));

        Profiles profiles = new Profiles();

        List<Address> expected = List.of(
                new Address("city1", "street1", 11, 1),
                new Address("city2", "street2", 22, 2)
        );
        List<Address> result = profiles.collect(profileList);
        assertThat(result, is(expected));
    }
}
