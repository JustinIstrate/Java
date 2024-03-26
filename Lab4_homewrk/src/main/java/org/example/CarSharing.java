package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CarSharing {
    private List<Person> persons;

    public CarSharing(List<Person> persons) {
        this.persons = persons;
    }

    public LinkedList<Person> getDriversSortedByAge() {
        return persons.stream()
                .filter(persons -> persons.getPersonAge() >= 20)
                .sorted(Comparator.comparingInt(Person::getPersonAge))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Set<Person> getPassengersSortedByName() {
        Comparator<Person> byNameComparator = Comparator.comparing(Person::getPersonName);
        return persons.stream()
                .filter(person -> person.getPersonAge() < 20)
                .collect(Collectors.toCollection(() -> new TreeSet<>(byNameComparator)));
    }
}
