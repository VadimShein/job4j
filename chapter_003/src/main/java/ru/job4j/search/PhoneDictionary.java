package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();

        for (Person person : persons) {
            String str = person.getName() + person.getSurname()
                    + person.getPhone() + person.getAddress();
            if (str.contains(key)) {
                result.add(new Person(person.getName(), person.getSurname(),
                        person.getPhone(), person.getAddress()));
            }
        }
        return result;
    }
}