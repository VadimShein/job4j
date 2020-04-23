package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
            for (Map.Entry<String, Citizen> entry : citizens.entrySet()) {
                String key = entry.getKey();
                Citizen value = entry.getValue();
                System.out.println("added " + key + " " + value.getUsername());
            }
        } else {
            System.out.println("citizen " + citizen.getUsername() + " is already added");
            rsl = false;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen rsl = null;
        if (citizens.containsKey(passport)) {
            rsl = citizens.get(passport);
        }
        return rsl;
    }
}